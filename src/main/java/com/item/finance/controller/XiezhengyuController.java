package com.item.finance.controller;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.item.finance.bean.News;
import com.item.finance.bean.NewsType;
import com.item.finance.services.NewsService;
import com.item.finance.services.NewsTypeService;

@Controller
public class XiezhengyuController {
@Autowired
private NewsService newsService;
@Autowired
private NewsTypeService newsTypeService;
@RequestMapping("/show")
public String login(Map<String,Object> map){
return "WEB-INF/backstage/show";
}
@RequestMapping("/NewsRight")
public String NewsRight(){
return "WEB-INF/backstage/NewsRight";
}
@RequestMapping("/listNews")
public String listNews(Map<String,Object> map,String stname,String stitle){
map.put("stitle", stitle);
map.put("stname", stname);
List<NewsType> listt=this.newsTypeService.listNewsType(map);
List<News> list = this.newsService.listNews(map);
map.put("list",list);
map.put("listt", listt);
return "WEB-INF/backstage/NewsRight";
}
//添加/saveNews",
//上传
@RequestMapping("/saveNews")
public String saveNews(News n,int tid,HttpServletRequest request,@RequestParam("file")MultipartFile file)throws Exception{
System.out.println("!!!!!!!!!!!!!!!!!!!q");
n.setAddTime(new Date());
NewsType type=this.newsTypeService.selectGetById(tid+"");
n.setNewsType(type);
n.setAddId(1);
n.setClickNumber(1);
n.setTitle(request.getParameter("title"));
n.setAuthor(request.getParameter("author"));
n.setSource(request.getParameter("source"));
n.setLink(request.getParameter("link"));
n.setSeoTitle(request.getParameter("seoTitle"));
n.setSubTitle(request.getParameter("subTitle"));
n.setInfo(request.getParameter("info"));
n.setLabel(request.getParameter("label"));
n.setFilelink(request.getParameter("filelink"));
n.setSeoDes(request.getParameter("seoDes"));
n.setSeoKey(request.getParameter("seoKey"));
n.setAudit(Integer.valueOf(request.getParameter("audit")));
n.setPlacTop(Integer.valueOf(request.getParameter("placTop")));
n.setRecommend(Integer.valueOf(request.getParameter("recommend")));
n.setText(request.getParameter("text"));
//获取上传文件名称
String filename = file.getOriginalFilename();
System.out.println("!!!!!!!!!!!!!!!!!!!2");
System.out.println(filename);
//获取将要上传的文件位置
String path = request.getRealPath("/HomeUpload/");
System.out.println(path);
//创建该文件
File newfile = new File(path, filename);
n.setcPhoto("HomeUpload\\"+filename);
//判断文件是否存在
if(!newfile.exists()){
newfile.createNewFile();
}
//把上传的内容传送给新创建的文件中
file.transferTo(newfile);
this.newsService.save(n);
return "redirect:listNews";
}
//修改前获得当前ID和对象
@RequestMapping("/getNews/{id}")
public String getNews(@PathVariable("id")String id,Map<String,Object> map){
News n = this.newsService.selectGetById(id);
map.put("n", n);
System.out.println("jjjjjjjjjjjjjjjjjjjjjj");
return "WEB-INF/backstage/NewsUpdate";
}
}
