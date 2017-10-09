package com.item.finance.controller;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RespectBinding;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.item.finance.bean.Feedback;
import com.item.finance.bean.Member;
import com.item.finance.bean.News;
import com.item.finance.bean.NewsType;
import com.item.finance.bean.PushNotice;
import com.item.finance.bean.SubjectFile;
import com.item.finance.services.Xzy_FeedbackService;
import com.item.finance.services.Xzy_NewsService;
import com.item.finance.services.Xzy_NewsTypeService;
import com.item.finance.services.Xzy_PushNoticeService;

@Controller
public class XiezhengyuController {
	@Autowired
	private Xzy_NewsService newsService;
	@Autowired
	private Xzy_NewsTypeService newsTypeService;
	@Autowired
	private Xzy_PushNoticeService PushNoticeService;
	@Autowired
	private Xzy_FeedbackService feedbackService;

	@RequestMapping("/show")
	public String login(Map<String, Object> map) {
		return "WEB-INF/backstage/show";
	}

	// -----------------------------------------------------------------news-----------------------------------------------------
	@RequestMapping("/listNews")
	public String listNews(Map<String, Object> map, String stname, String stitle) {
		map.put("stitle", stitle);
		map.put("stname", stname);
		List<NewsType> listt = this.newsTypeService.listNewsType(map);
		List<News> list = this.newsService.listNews(map);
		map.put("list", list);
		map.put("listt", listt);
		return "WEB-INF/backstage/NewsRight";
	}

	// 添加/saveNews",
	// 上传
	@RequestMapping("/saveNews")
	public String saveNews(News n, int tid, HttpServletRequest request, @RequestParam("file") MultipartFile file,HttpSession session)
			throws Exception {
	   Member m = (Member) session.getAttribute("memberinfo");
		n.setAddTime(new Date());
		NewsType type = this.newsTypeService.selectGetById(String.valueOf(tid));
		n.setNewsType(type);
		n.setAddId(Integer.valueOf(m.getId()));
		n.setClickNumber(1);
		n.setAddTime(new Date());
		// 获取上传文件名称
		String filename = file.getOriginalFilename();
		String new_name = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		int index = filename.lastIndexOf(".");
		// 取得文件名
		String tname = filename.substring(index).toString();
		new_name = new_name + tname;
		// 获取将要上传的文件位置
		String path = request.getRealPath("/HomeUpload/");
		System.out.println(path);
		System.out.println(new_name);
		// 创建该文件
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path, new_name));
		n.setcPhoto("HomeUpload\\" + new_name);
		// 判断文件是否存在
		/*
		 * if(!newfile.exists()){ newfile.createNewFile(); } //把上传的内容传送给新创建的文件中
		 * file.transferTo(newfile);
		 */
		this.newsService.save(n);
		return "redirect:listNews";
	}

	// 修改前获得当前ID和对象
	@RequestMapping("/getNews/{id}")
	public String getNews(@PathVariable("id") String id, Map<String, Object> map) {
		News n = this.newsService.selectGetById(id);
		List<NewsType> list = this.newsTypeService.listNewsType(map);
		map.put("n", n);
		map.put("list", list);
		return "WEB-INF/backstage/NewsUpdate";
	}

	// 修改
	@RequestMapping("/updateNews")
	public String update(News n, HttpServletRequest request, @RequestParam("file") MultipartFile file, int tid,HttpSession session)
			throws Exception {
		Member m = (Member) session.getAttribute("memberinfo");
		if (!file.isEmpty()) {
			// 获取上传文件名称
			String filename = file.getOriginalFilename();
			String new_name = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			int index = filename.lastIndexOf(".");
			// 取得文件名
			String tname = filename.substring(index);
			new_name = new_name + tname;
			// 获取将要上传的文件位置
			String path = request.getRealPath("/HomeUpload/");
			// 创建该文件
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path, new_name));
			n.setcPhoto("HomeUpload\\" + new_name);
		}
		String addTime = request.getParameter("ttime");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");
		if (addTime != null && !addTime.equals("")) {
			Date date = null;
			date = dateFormat.parse(addTime);
			n.setAddTime(date);
		} else {
			n.setAddTime(new Date());
		}
		n.setId(Integer.valueOf(request.getParameter("id")));
		n.setUpdId(Integer.valueOf(m.getId()));
		n.setUpdTime(new Date());
		NewsType type = this.newsTypeService.selectGetById(String.valueOf(tid));
		n.setNewsType(type);
		this.newsService.update(n);
		return "redirect:listNews";
	}

	@RequestMapping("/deleteNews/{id}")
	public String deleteNews(@PathVariable("id") String id) {
		News n = this.newsService.selectGetById(id);
		n.setNewsType(null);
		this.newsService.delete(n);
		return "redirect:/listNews";
	}

	// -----------------------------------------------------------------newstype-----------------------------------------------------
	// 查询
	@RequestMapping("/listNewsType")
	public String listNewsType(Map map) {
		List<NewsType> list = this.newsTypeService.listNewsType(map);
		map.put("list", list);
		return "WEB-INF/backstage/NewsTypeRight";
	}

	// 添加
	@RequestMapping("/saveNewsType")
	public String saveNewsType(NewsType nt) {
		nt.setAddId(1);
		nt.setAddTime(new Date());
		this.newsTypeService.save(nt);
		return "redirect:/listNewsType";
	}

	// 删除
	@RequestMapping("/deleteNewsType")
	public String deleteNewsType(int tid) {
		NewsType nt = this.newsTypeService.selectGetById(String.valueOf(tid));
		this.newsTypeService.delete(nt);
		return "redirect:/listNewsType";
	}

	// 修改
	@RequestMapping("/updateNewsType")
	public String updateNewsType(NewsType nt, HttpServletRequest request) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");
		String addTime = request.getParameter("ttime");
		if (addTime != null && !addTime.equals("")) {
			Date date = dateFormat.parse(addTime);
			nt.setAddTime(date);
		} else {
			nt.setAddTime(new Date());
		}
		nt.setUpdTime(new Date());
		this.newsTypeService.update(nt);
		System.out.println(nt.getSort());
		return "redirect:/listNewsType";
	}

	// 修改前显示
	@RequestMapping("/getNewsType/{id}")
	public String getPushNotice(@PathVariable("id") String id, Map map) {
		NewsType nt = this.newsTypeService.selectGetById(id);
		map.put("nt", nt);
		return "WEB-INF/backstage/NewsTypeUpdate";
	}

	// -----------------------------------------------------------------PushNotice-----------------------------------------------------
	// 查询
	@RequestMapping("/listPushNotice")
	public String listPushNotice(Map map, String tname) {
		map.put("tname", tname);
		List<PushNotice> list = this.PushNoticeService.listPushNotice(map);
		map.put("list", list);
		return "WEB-INF/backstage/push_notice";
	}

	// 添加
	@RequestMapping("/savePushNotice")
	public String savePushNotice(PushNotice p) {
		p.setCreateDate(new Date());
		this.PushNoticeService.save(p);
		return "redirect:/listPushNotice";
	}

	// 修改
	@RequestMapping("/updatePushNotice")
	public String updateNewsType(PushNotice p, HttpServletRequest request) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");
		String addTime = request.getParameter("ttime");
		if (addTime != null && !addTime.equals("")) {
			Date date = dateFormat.parse(addTime);
			p.setCreateDate(date);
			System.out.println(p.getStatus());
		} else {
			p.setCreateDate(new Date());
		}
		p.setUpdate_Date(new Date());
		this.PushNoticeService.update(p);
		System.out.println(p.getStatus());
		return "redirect:/listPushNotice";
	}

	// 修改前显示
	@RequestMapping("/getPushNotice/{id}")
	public String getNewsType(@PathVariable("id") String id, Map<String, Object> map) {
		PushNotice p = this.PushNoticeService.selectGetById(id);
		map.put("p", p);
		return "WEB-INF/backstage/PushNoticeUpdate";
	}

	// status0
	@RequestMapping("/status/{id}")
	public String status(@PathVariable("id") String id, Map<String, Object> map) {
		PushNotice p = this.PushNoticeService.selectGetById(id);
		p.setStatus(1);
		this.PushNoticeService.update(p);
		return "redirect:/listPushNotice";
	}

	// status1
	@RequestMapping("/statused/{id}")
	public String statused(@PathVariable("id") String id, Map<String, Object> map) {
		PushNotice p = this.PushNoticeService.selectGetById(id);
		p.setStatus(0);
		this.PushNoticeService.update(p);
		return "redirect:/listPushNoticeed";
	}

	@RequestMapping("/listPushNoticeed")
	public String listPushNoticeed(Map map, String tname) {
		map.put("tname", tname);
		List<PushNotice> list = this.PushNoticeService.listPushNoticeed(map);
		map.put("list", list);
		return "WEB-INF/backstage/push_noticeed";
	}

	/*
	 * //删除
	 * 
	 * @RequestMapping("/deletePushNotice") public String deletePushNotice(int
	 * tid){ PushNotice p =
	 * this.PushNoticeService.selectGetById(String.valueOf(tid));
	 * this.PushNoticeService.delete(p);; return "redirect:/listPushNotice"; }
	 */
	// -----------------------------------------------------------------feedback-----------------------------------------------------
	@RequestMapping("/listFeedback")
	public String listFeedback(Map<String, Object> map, String tname) {
		map.put("tname", tname);
		List<Feedback> list = this.feedbackService.listFeedback(map);
		map.put("list", list);
		return "WEB-INF/backstage/FeedbackRight";
	}

	@RequestMapping("/getMember/{id}")
	public String getMember(@PathVariable("id") String id,Map map) {
		Member m = this.feedbackService.selectGetById(id);
		map.put("m", m);
		return "WEB-INF/backstage/MemberRight";
	}
//-----------------------------------------------------------------前台-----------------------------------------------------------------
@RequestMapping("/feedback")
public String front(Map<String,Object> map,HttpSession session) {
	//查询意见反馈
	List<Feedback> feedbacklist = this.feedbackService.listFeedback(map);
	map.put("feedbacklist", feedbacklist);
	Member  m = (Member) session.getAttribute("memberinfo");
	if(m!= null){
	map.put("ok", "ok");
	}else{
	map.put("no", "no");	
	}
	return "WEB-INF/news/feedback";
}
@RequestMapping("/pushshow")
@ResponseBody
public List<PushNotice> pushshow(Map<String,Object> map) {
	List<PushNotice> PushNoticelist = this.PushNoticeService.listPushNotice(map);
	map.put("PushNoticelist", PushNoticelist);
	return PushNoticelist;
}
//得到新闻
@RequestMapping("/push/{id}")
@ResponseBody
public PushNotice newsText(@PathVariable("id")String id,Map<String,Object> map) {
	//新闻
	System.out.println(id);
    PushNotice push = this.PushNoticeService.selectGetById(id);
	map.put("push",push);
	return push;
}
@RequestMapping("/imgs/{id}")
@ResponseBody
public List<SubjectFile> imgs(@PathVariable("id")String[] id){
List<SubjectFile> list = new ArrayList<>();
for(int i=0;i<id.length;i++){
list.add(this.feedbackService.selectSubjectFile(Integer.valueOf(id[i])));
}
return list;
}
@RequestMapping("/saveFeed/{id}")
public String saveFeed(@PathVariable("id")String id,Feedback f){
Member m= this.feedbackService.selectGetById(id);
System.out.println(m.getName());
f.setCreateDate(new Date());
f.setId(Integer.valueOf(id));
f.setMember(m);
this.feedbackService.saveFeed(f);
System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjf");
return "redirect:/feedback";	
}
}