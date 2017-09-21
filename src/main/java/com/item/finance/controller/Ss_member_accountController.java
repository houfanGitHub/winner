package com.item.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.finance.bean.FinancialPlanner;
import com.item.finance.bean.Member;
import com.item.finance.bean.MemberAccount;
import com.item.finance.bean.MemberDepositRecord;
import com.item.finance.bean.MemberTradeRecord;
import com.item.finance.bean.MemberWithdrawRecord;
import com.item.finance.bean.SubjectPurchaseRecord;
import com.item.finance.services.Ss_member_accountService;

@Controller
@RequestMapping("sushuang7")
public class Ss_member_accountController {
	
	@Autowired
	private Ss_member_accountService ss_member_accountService;
	
	
	@RequestMapping("/list7")
	public  String  listmemberaccount(Model model){
		List<MemberAccount>listmemberaccount=ss_member_accountService.list();
		model.addAttribute("listmemberaccount", listmemberaccount);
		return "WEB-INF/ssjsp/memberWithdrawRecord_details";   //跳转页面
	}
	
	//得到id  传值     model 保存  传值
		@RequestMapping("/getmemberaccountId/{id}")
		public String getMember(@PathVariable("id")String id,Model model){
			Member member=this.ss_member_accountService.selectGetBy(id);  //会员表
			MemberAccount memberAccount=this.ss_member_accountService.getById(id);//资金信息表
			FinancialPlanner financialPlanner=this.ss_member_accountService.getBYid(id);//理财师表
			 //集合取出来
			List<SubjectPurchaseRecord>listspr=this.ss_member_accountService.getlistspr(id); //投资详请
			
			List<MemberWithdrawRecord> memberWithdrawRecord=this.ss_member_accountService.getByIdwith(id);//提现记录表
			List<MemberDepositRecord> memberDepositRecord=this.ss_member_accountService.getbyIddeposit(id);//充值记录表
			List<MemberTradeRecord> memberTradeRecord=this.ss_member_accountService.getbyIdtrade(id);//钱包交易记录表
			model.addAttribute("member", member);
			model.addAttribute("memberAccount", memberAccount);
			model.addAttribute("financialPlanner", financialPlanner);
			
		   model.addAttribute("listspr", listspr);
			model.addAttribute("memberWithdrawRecord", memberWithdrawRecord);
			//System.out.println("memberWithdrawRecord"+memberWithdrawRecord.size());
		
		
			model.addAttribute("memberDepositRecord", memberDepositRecord);
			/*for (int i = 0; i < memberDepositRecord.size(); i++) {
				System.out.println(memberDepositRecord.get(i).getId());
			}*/
			//System.out.println("memberDepositRecord"+memberDepositRecord.size());
		
			model.addAttribute("memberTradeRecord", memberTradeRecord);
			//System.out.println("memberTradeRecord"+memberTradeRecord.size());
		
			return "WEB-INF/ssjsp/memberWithdrawRecord_details";   //跳转页面
		}

}
