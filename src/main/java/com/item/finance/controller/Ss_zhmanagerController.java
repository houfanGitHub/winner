package com.item.finance.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.item.finance.bean.BbinInfo;
import com.item.finance.bean.FinancialPlanner;
import com.item.finance.bean.Member;
import com.item.finance.bean.MemberAccount;
import com.item.finance.bean.MemberDepositRecord;
import com.item.finance.bean.MemberProfitRecord;
import com.item.finance.bean.MemberTradeRecord;
import com.item.finance.bean.MemberWithdrawRecord;
import com.item.finance.bean.Ss_suminvest;
import com.item.finance.bean.Ss_sumorder;
import com.item.finance.bean.Subject;
import com.item.finance.bean.SubjectBbinPurchaseRecord;
import com.item.finance.bean.SubjectOrderRecord;
import com.item.finance.bean.SubjectPurchaseRecord;
import com.item.finance.services.Ss_zhmanagerService;

@Controller
@RequestMapping("/sushuang1")
public class Ss_zhmanagerController {
	@Autowired
	private Ss_zhmanagerService ss_zhmanagerService;
	
	@RequestMapping("/list1")
	public String listShowzh(HttpSession session,Model model,@RequestParam(required=false)String qname1,
			@RequestParam(required=false)String mobile,
			@RequestParam(required=false)String qname2,
			@RequestParam(required=false)String invit,
			@RequestParam(required=false)String create_date1,
			@RequestParam(required=false)String create_date2){
		
		Map map=new HashMap();
		map.put("qname1", qname1);  //用户名
		map.put("mobile", mobile);//手机号
		map.put("qname2", qname2);//姓名
		map.put("invit", invit);  //邀请码
		map.put("create_date1", create_date1);//注册时间1开始
		map.put("create_date2", create_date2);//注册时间2 结束
		List<Member>listzh=ss_zhmanagerService.list(map);
		//model.addAttribute("listzh", listzh);
		session.setAttribute("listzh", listzh);
		
		session.setAttribute("qname1", qname1);
		session.setAttribute("mobile", mobile);
		session.setAttribute("qname2", qname2);
		session.setAttribute("invit", invit);
		session.setAttribute("create_date1", create_date1);
		session.setAttribute("create_date2", create_date2);
		
		
		/*//模糊查询
		model.addAttribute("qname1", qname1);
		model.addAttribute("mobile", mobile);
		model.addAttribute("qname2", qname2);
		model.addAttribute("invit", invit);
		model.addAttribute("create_date1", create_date1);
		model.addAttribute("create_date2", create_date2);*/
		
		return "WEB-INF/ssjsp/zhmanager";
	}
	//重置操作
	@RequestMapping("/listcz1")
	public String listcz(HttpSession session){
		session.removeAttribute("qname1");
		session.removeAttribute("mobile");
		session.removeAttribute("qname2");
		session.removeAttribute("invit");
		session.removeAttribute("create_date1");
		session.removeAttribute("create_date2");
		
		return "redirect:/sushuang1/list1";   //重定向到首页
	}
	
	//得到id  传值     model 保存  传值
	@RequestMapping("/getmemberId/{id}")
	public String getMember(@PathVariable("id")String id,Model model){
	
		Member member=this.ss_zhmanagerService.selectGetById(id);  //会员表
		System.out.println("aaaaa="+member.getId());
		 //集合取出来
		List<MemberAccount>memberAccount=this.ss_zhmanagerService.getmemberaccountid(id);//资金信息表
		List<FinancialPlanner>financialPlanner=this.ss_zhmanagerService.getfinaid(id);//理财师表
		List<SubjectPurchaseRecord>listspr=this.ss_zhmanagerService.getlistspr(id); //投资详请
		for (SubjectPurchaseRecord s : listspr) {
			System.out.println("标的周期："+s.getSubject().getPeriod());
			
		}
		System.out.println("11111111111111111");
/*	     Date date = new Date();
		double day = 0;//天数
		double earnings = 0;//投资收益(earnings)
		String result = "";//格式化小数位后的投资收益数
		System.out.println("22222222222222");
		for (SubjectPurchaseRecord s : listspr) {
			//时间date格式  转换为String类型
		//	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ssss");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("3333333333");
			String sdate =sdf.format(s.getSubject().getStartDate());//得到开始时间
			System.out.println("444444444444");
			String edate = sdf.format(s.getSubject().getEndDate());//得到结束时间
			System.out.println("开始日期："+sdate);
			System.out.println("结束日期："+edate);
			System.out.println("5555555555555555");
			//这块转错了  只能输出555555555555
			double time1=Double.valueOf(sdate);//   字符串string类型转换为double类型
			double time2=Double.valueOf(edate);
			System.out.println("time1="+time1);
			System.out.println("time2="+time2);
			System.out.println("66666666666");
			double qamount= s.getAmount();//标的购买金额
			double yearRate= s.getSubject().getYearRate();//标的年化率.
			day = (Math.abs(time2 - time1))/1000/60/60/24;//得到天数   /1000  毫秒    Math.abs（）取绝对值
			System.out.println("777777777777777");
			//amount*.subject.yearRate/365*day
			earnings = qamount*yearRate/365*day;
			System.out.println("8888888888888");
			result= String.format("%.2f", earnings);//格式化数据
		}
		System.out.println("day="+day);
		System.out.println("投资收益="+result);  
	*/

				
		List<MemberWithdrawRecord> memberWithdrawRecord=this.ss_zhmanagerService.getByIdwith(id);//提现记录表
		List<MemberDepositRecord> memberDepositRecord=this.ss_zhmanagerService.getbyIddeposit(id);//充值记录表
		for (MemberDepositRecord mea : memberDepositRecord) {
			System.out.println("订单号："+mea.getSerialNumber()+",金额："+mea.getAmount());
			
		}
		List<MemberTradeRecord> memberTradeRecord=this.ss_zhmanagerService.getbyIdtrade(id);//钱包交易记录表
		model.addAttribute("member", member);
		
		model.addAttribute("memberAccount", memberAccount);
		model.addAttribute("financialPlanner", financialPlanner);
	
		
	   model.addAttribute("listspr", listspr);
		model.addAttribute("memberWithdrawRecord", memberWithdrawRecord);
	
		model.addAttribute("memberDepositRecord", memberDepositRecord);
		/*for (int i = 0; i < memberDepositRecord.size(); i++) {
			System.out.println(memberDepositRecord.get(i).getId());
		}*/
	
		model.addAttribute("memberTradeRecord", memberTradeRecord);
	
		return "WEB-INF/ssjsp/details";   //跳转页面
	}
	
	//前台个人 收益记录    成员利润
	@RequestMapping("/getmemberprofit1")  //memberinfo信息  是存在session里的
	public String getMemberprofit(Model model,HttpSession session){
		String id = ((Member)session.getAttribute("memberinfo")).getId();  //得到 id  在下面可以用
		String name=((Member)session.getAttribute("memberinfo")).getName();
		System.out.println("id="+id);
		System.out.println("name="+name);
		List<MemberProfitRecord>listprofit=ss_zhmanagerService.getmeberpro(id);//收益  成员利润表
		for (MemberProfitRecord m : listprofit) {
			System.out.println("订单号："+m.getSerialNumber()+",金额："+m.getAmount());
			
		}
		model.addAttribute("listprofit", listprofit); 
		return "WEB-INF/myself/myself";  //页面跳转  
		
	}

	//前台个人充值记录    直接从service里面拿过来
	@RequestMapping("/getmemberdepo1")       //memberinfo信息  是存在session里的
	public String getmemberdepo(Model model,HttpSession session){
		String id=((Member)session.getAttribute("memberinfo")).getId(); //得到 id  在下面可以用
		String name=((Member)session.getAttribute("memberinfo")).getName();
		System.out.println("id="+id);
		System.out.println("name="+name);
		System.out.println("333333333333");
		List<MemberDepositRecord> listmemberdepo=ss_zhmanagerService.getbyIddeposit(id);//充值记录表
		System.out.println("bbbbbbbbb="+listmemberdepo.size());
		for (MemberDepositRecord me : listmemberdepo) {
			System.out.println("订单号："+me.getSerialNumber()+",金额："+me.getAmount());
		}
		System.out.println("44444444444444");
		model.addAttribute("listmemberdepo", listmemberdepo);
		return "WEB-INF/myself/rechargeRecords";//页面跳转
		
	}
	
	//前台 个人 提款记录   直接从 service里面 拿出来
	@RequestMapping("/getmemberwith1")
	public String getmemberwith(Model model,HttpSession session){
		System.out.println("555555555555555");
		String id=((Member)session.getAttribute("memberinfo")).getId();//得到 id 在下面可以带到list集合方法里
		String name=((Member)session.getAttribute("memberinfo")).getName();
		System.out.println("id="+id);
		System.out.println("name="+name);
																		//id  是上面得到的 string类型得id
		List<MemberWithdrawRecord> listmemberwith=ss_zhmanagerService.getByIdwith(id);//提款（提现）记录表
		for (MemberWithdrawRecord mem : listmemberwith) {
			System.out.println("订单号："+mem.getSerialNumber()+",金额："+mem.getAmount());
			
		}
		
		model.addAttribute("listmemberwith", listmemberwith);
		System.out.println("6666666666666666");
		return "WEB-INF/myself/withdrawals"; //页面跳转
		
	}
	
	//前台 个人投资记录  直接从service里面拿出来
	@RequestMapping("/getsubjectpur")
	public String getsubjectpur(HttpSession session,Model model){
		System.out.println("77777777777777");
		String id=((Member)session.getAttribute("memberinfo")).getId();//得到 id 在下面可以带到list集合方法里
		String name=((Member)session.getAttribute("memberinfo")).getName();
		System.out.println("id="+id);
		System.out.println("name="+name);
		                                                  //id  是上面得到的 string类型得id
		List<SubjectPurchaseRecord> subjectpro=ss_zhmanagerService.getlistspr(id);//投资记录表
		System.out.println("aaaaaaaaaaa="+subjectpro.size());
		for (SubjectPurchaseRecord su : subjectpro) {
			System.out.println("订单编号："+su.getSerialNumber()+",金额："+su.getAmount());
			
		}
		Ss_suminvest listinvest=this.ss_zhmanagerService.selectinvestgetbyid(id); //投资几笔数据
		System.out.println("数据1="+listinvest.getSuminvest());
		
		List<SubjectOrderRecord>liSubjectord=this.ss_zhmanagerService.listorder(id);//预约记录   订单记录
		for (SubjectOrderRecord su : liSubjectord) {
			System.out.println("订单金额："+su.getAmount());
			
		}
		Ss_sumorder listorder=this.ss_zhmanagerService.getlistorder(id); //预约几笔数据
		System.out.println("数据2="+listorder.getSumorder());
		
		model.addAttribute("subjectpro", subjectpro); //投资记录表
		model.addAttribute("listinvest", listinvest);  //投资几笔数据
		model.addAttribute("liSubjectord", liSubjectord); //预约记录   订单表
		model.addAttribute("listorder", listorder);  //预约几笔数据
		System.out.println("888888888888888888888");
		return "WEB-INF/myself/invests"; //页面跳转
	
	}
	//体验金记录信息
	@RequestMapping("/getbbin")
	public String getbbin(HttpSession session,Model model){
		System.out.println("9999999");
		String id=((Member)session.getAttribute("memberinfo")).getId();//得到 id 在下面可以带到list集合方法里
		String name=((Member)session.getAttribute("memberinfo")).getName();
		System.out.println("id="+id);
		System.out.println("name="+name);
		                                                  //id  是上面得到的 string类型得id
		BbinInfo listbb=ss_zhmanagerService.getbbin(id);//体验金记录表
	//	System.out.println("体验金金额："+listbb.getAmont());
		
		//SubjectBbinPurchaseRecord  //体验金购买标 的表
		SubjectBbinPurchaseRecord listjectbbr=this.ss_zhmanagerService.getsubjectbbinpurBYid(id);
				//System.out.println("id="+listjectbbr.getId());
	/*	List<MemberProfitRecord>listprofit=ss_zhmanagerService.getmeberpro(id);//收益  成员利润表
		for (MemberProfitRecord m : listprofit) {
			System.out.println("订单号："+m.getSerialNumber()+",金额："+m.getAmount());
			
		}*/
	/*	List<SubjectPurchaseRecord> subjectpro=ss_zhmanagerService.getlistspr(id);//投资记录表
		System.out.println("aaaaaaaaaaa="+subjectpro.size());
		for (SubjectPurchaseRecord su : subjectpro) {
			System.out.println("订单编号："+su.getSerialNumber()+",金额："+su.getAmount());
			
		}*/
	
		
			
		model.addAttribute("listbb", listbb); //体验金
		model.addAttribute("listjectbbr", listjectbbr);//体验金购买标 的表
		//model.addAttribute("listprofit", listprofit); //成员利润表
		//model.addAttribute("subjectpro", subjectpro);//投资记录
		System.out.println("1010101010101");
		return "WEB-INF/myself/goldexperience"; //页面跳转 
	
	}
	
	//提款 记录 跳转到  我要提款 界面
	//前台 个人 提款记录   直接从 service里面 拿出来
	/*	@RequestMapping("/getmemberwithdraw1")
		public String getmemberwithdraw(Model model,HttpSession session){
			System.out.println("121212121212");
			String id=((Member)session.getAttribute("memberinfo")).getId();//得到 id 在下面可以带到list集合方法里
			String name=((Member)session.getAttribute("memberinfo")).getName();
			System.out.println("id="+id);
			System.out.println("name="+name);
																			//id  是上面得到的 string类型得id
			List<MemberWithdrawRecord> listmemberwithdraw=ss_zhmanagerService.getByIdwith(id);//提款（提现）记录表
			for (MemberWithdrawRecord mem : listmemberwithdraw) {
				System.out.println("订单号："+mem.getSerialNumber()+",金额："+mem.getAmount());
				
			}
			
			model.addAttribute("listmemberwithdraw", listmemberwithdraw);
			System.out.println("131313131313");
			return "WEB-INF/myself/recharge"; //页面跳转
			
		}*/
		
	

}
