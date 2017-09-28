package com.item.finance.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.config.AlipayConfig;
import com.item.finance.avtivity.DeoploymentProcessDefinition;
import com.item.finance.bean.Member;
import com.item.finance.bean.MemberAccount;
import com.item.finance.bean.MemberBankcard;
import com.item.finance.bean.MemberDepositRecord;
import com.item.finance.bean.MemberWithdrawRecord;
import com.item.finance.services.MemberAccountService;
import com.item.finance.services.MemberBankcardService;
import com.item.finance.services.MemberDepositRecordService;
import com.item.finance.services.MemberService;
import com.item.finance.services.MemberWithdrawRecordService;
import com.item.finance.services.UserRoleRelationService;
import com.item.finance.services.UserRoleService;
import com.item.finance.services.UserService;

@Controller
@RequestMapping("/itemweb")
public class HoufanWebItemController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleRelationService userRoleRelationService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberBankcardService memberBankcardService;
	@Autowired
	private MemberDepositRecordService memberDepositRecordService;
	@Autowired
	private MemberAccountService memberAccountService;
	@Autowired
	private DeoploymentProcessDefinition deoploymentProcessDefinition;
	@Autowired
	private MemberWithdrawRecordService memberWithdrawRecordService;

	//充值
	@RequestMapping("/accountRecharge")
	public String accountRecharge(@RequestParam(value="fee")String fee,Map<String, Object> map,HttpServletRequest request) {
		//生成订单号
		String randomPayName = getRandomPayName();

		request.setAttribute("serialNumber", randomPayName);
		//付款金额，必填
		request.setAttribute("amountDecimal", fee);
		//订单名称，必填
		request.setAttribute("payName", "富友账户充值");
		//商品描述，可空
		request.setAttribute("payinfo", "");
		
		return "/WEB-INF/myself/accountRecharge";
	}
	
//	功能：支付宝服务器同步通知页面
	@RequestMapping("/returnUrl")
	public String returnUrl(HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException, AlipayApiException{
		//获取支付宝GET过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
//			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		
		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

		//——请在这里编写您的程序（以下代码仅作参考）——
		if(signVerified) {
			//商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("UTF-8"),"UTF-8");
			System.out.println("商户订单号:"+out_trade_no);
			//支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("UTF-8"),"UTF-8");
			System.out.println("支付宝交易号:"+out_trade_no);
			//付款金额
			String total_amount = new String(request.getParameter("total_amount").getBytes("UTF-8"),"UTF-8");
			System.out.println("付款金额:"+total_amount);
			//账户充值
			Member member =(Member)session.getAttribute("memberinfo");
			//根据memberId查询该用户的账户信息
			try {
				System.out.println("账户id:"+((Member)session.getAttribute("memberinfo")).getId());
				MemberAccount memberAccount = memberAccountService.selectGetByMemberId(member.getId());
				//如果没有查询到该用户的账户信息则进行添加
				if(memberAccount == null){
					memberAccount = new MemberAccount(Double.valueOf(0), Double.valueOf(0), new Date(), (byte)0, Double.valueOf(0), Double.valueOf(0), Double.valueOf(0), new Date(), Double.valueOf(total_amount), member);
					memberAccountService.save(memberAccount);
					System.out.println("账户充值成功(添加)");
					//重新查询member
					Member member2 = memberService.selectGetByName(member.getName());
					session.setAttribute("memberinfo", member2);
					System.out.println("重新查询member"+member2.toString());
				}else{
					//修改账户余额
					memberAccount.setUseableBalance(memberAccount.getUseableBalance()+Double.valueOf(total_amount));
					memberAccount.setUpdateDate(new Date());
					memberAccountService.update(memberAccount);
					System.out.println("账户充值成功(修改)");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("账户充值失败");
			}
			//添加充值记录
			try {
				MemberDepositRecord memberDepositRecord = 
						new MemberDepositRecord(Double.valueOf(total_amount), new Date(), (byte)0, "FUIOU", getRandomPayName(), trade_no, (byte)1, new Date(), (Member)session.getAttribute("memberinfo"));
				memberDepositRecordService.save(memberDepositRecord);
				System.out.println("充值记录信息添加成功");
				//重新查询member
				Member member2 = memberService.selectGetByName(member.getName());
				session.setAttribute("memberinfo", member2);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("充值记录信息添加失败");
			}
			System.out.println("trade_no:"+trade_no+"\n"+"out_trade_no:"+out_trade_no+"\n"+"total_amount:"+total_amount);
		}else {
			System.out.println("验签失败");
		}
		return "redirect:/itemweb/rechargeRecords";
	}
	
//	功能：支付宝服务器异步通知页面
	@RequestMapping("/notifyUrl")
	@ResponseBody
	public void notifyUrl(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException{
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		
		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

		//——请在这里编写您的程序（以下代码仅作参考）——
		
		/* 实际验证过程建议商户务必添加以下校验：
		1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
		2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
		3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
		4、验证app_id是否为该商户本身。
		*/
		if(signVerified) {//验证成功
			//商户订单号
//			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		
			//支付宝交易号
//			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
		
			//交易状态
			String trade_status = new String(request.getParameter("trade_status").getBytes("UTF-8"),"UTF-8");
			
			if(trade_status.equals("TRADE_FINISHED")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
					
				//注意：
				//退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
			}else if (trade_status.equals("TRADE_SUCCESS")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
				
				//注意：
				//付款完成后，支付宝系统发送该交易状态通知
			}
			
			System.out.println("success");
			
		}else {//验证失败
			System.out.println("fail");
		
			//调试用，写文本函数记录程序运行情况是否正常
			//String sWord = AlipaySignature.getSignCheckContentV1(params);
			//AlipayConfig.logResult(sWord);
		}
	}
	
	//生成订单号
	public String getRandomPayName() {

		  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		  Date date = new Date();

		  String str = simpleDateFormat.format(date);
		  Random random = new Random();
		  int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数
		  return  str + rannum;// 当前时间  
	}
	//绑卡
	@RequestMapping("/TiedCard")
	@ResponseBody
	public boolean TiedCard(String cardNo,String cardaddress,String type,HttpSession session){
		
		System.out.println("填写的绑卡信息:cardNo="+cardNo+",cardaddress="+cardaddress+",type="+type);
		try {
			MemberBankcard memberBankcard = new MemberBankcard();
			memberBankcard.setCardNo(cardNo);
			memberBankcard.setCardaddress(cardaddress);
			memberBankcard.setType(type);
			memberBankcard.setCreateDate(new Date());
			memberBankcard.setDelflag((byte)0);
			//获取当前用户信息
			Member member = (Member) session.getAttribute("memberinfo");
			memberBankcard.setMember(member);
			
			//添加信息
			memberBankcardService.save(memberBankcard);
			//重新查询member信息
			Member newmember = memberService.selectGetByName(member.getName());
			System.out.println(newmember.toString());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}	
	//提款记录
	@RequestMapping("/withdraw")
	public String withdraw(){
		return "redirect:/sushuang1/getmemberwith1";//跳转到controller
	}
	
	//设置提款密码
	@RequestMapping("/insertDrawMoney")
	@ResponseBody
	public boolean insertDrawMoney(String password,HttpSession session){
		//获取当前用户信息
		Member member = (Member)session.getAttribute("memberinfo");
		//添加提款密码
		member.setWithdrawPassword(password);
		//修改当前用用户信息
		try {
			memberService.update(member);
			System.out.println("添加用户提款密码成功");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			//添加用户提款密码失败
			System.out.println("添加用户提款密码失败");
		}
		return false;
	}
	
	//提款申请
	@RequestMapping("/drawMoneyApplyFor")
	@ResponseBody
	public String drawMoneyApplyFor(String withdrawAmount,String withdrawPW,String bankCard,HttpSession session){
		System.out.println("提款申请>>>withdrawAmount:"+withdrawAmount+",withdrawPW:"+withdrawPW+",bankCard:"+bankCard);
		//查询提款密码是否正确
		Member member = (Member) session.getAttribute("memberinfo");
		if(withdrawPW.equals(member.getWithdrawPassword())){
			try {
				//----------------activiti工作流
				//部署流程定义
				ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
//			    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
			    System.out.println("部署流程定义:processEngine = "+ processEngine);
			    deoploymentProcessDefinition.getDeployment(processEngine);
			    //启动流程实例
			    ProcessInstance pi = deoploymentProcessDefinition.startProcessInstance(processEngine,member.getName());
			    //查询任务通过流程实例id 
			   String id = deoploymentProcessDefinition.findHistoryTask(processEngine, pi.getId());
			  //添加提款记录
        		//查询个人账户信息
        		MemberBankcard  memberBankcard = memberBankcardService.selectGetByMemberId(member.getId());
        		//流水号
        		String randomPayNumber = getRandomPayName();
        		MemberWithdrawRecord memberWithdrawRecord = 
        				//提现金额 银行卡号 银行名称 开户银行所在地 打款通道 创建时间 是否删除 流水号 提现状态 修改时间 用户信息
        				new MemberWithdrawRecord(withdrawAmount, bankCard, memberBankcard.getType(), memberBankcard.getCardaddress(), "FUIOU", new Date(), (byte)0, randomPayNumber, (byte)0, new Date(), member);
			    memberWithdrawRecordService.save(memberWithdrawRecord);
			  //设置流程变量
			    if(id!=null){
			    	deoploymentProcessDefinition.setProcessVariables(processEngine,id, member.getName(), withdrawAmount, bankCard,randomPayNumber);
			    }
        		return "yes";
			} catch (Exception e) {
				e.printStackTrace();
				return "提款申请失败";
			}
		}else{
			System.out.println("提款密码错误");
			return "提款密码错误";
		}
	}
	
	//查看历史任务
	@RequestMapping("/selectFlowState")
	@ResponseBody
	public List<Map<String,String>> selectFlowState(HttpSession session){
		Member member = (Member) session.getAttribute("memberinfo");
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		//查询已完成的历史任务
		List<String> list = deoploymentProcessDefinition.historyTaskList(processEngine, member.getName());
		//通过id 查询流程变量
		List<Map<String,String>> listMaps = deoploymentProcessDefinition.getProcessVariables(processEngine, list);
		return listMaps;
	}
	
	/**
	 * 查看流程图
	 * @throws Exception 
	 */
	@RequestMapping("/viewImage")
	public String viewImage(String deploymentId,String imageName,HttpServletResponse response) throws Exception{
		System.out.println("viewImage : deploymentId = "+deploymentId+",imageName = "+imageName);
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		InputStream  in = processEngine.getRepositoryService().getResourceAsStream(deploymentId,imageName);
        try {
            OutputStream out = response.getOutputStream();
            // 把图片的输入流程写入resp的输出流中
            byte[] b = new byte[1024];
            for (int len = -1; (len= in.read(b))!=-1; ) {
                out.write(b, 0, len);
            }
            // 关闭流
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
	}
	
	/**
	 * 查看当前流程图（查看当前活动节点，并使用红色的框标注）
	 */
	@RequestMapping("/showImg/{id}")
	public String showImg(@PathVariable(value="id")String id,HttpServletResponse resp,Map<String,Object> map) throws IOException{
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		//根据流程id查询流程图
		ProcessDefinition processDefinition = deoploymentProcessDefinition.viewPic(processEngine, id);
		map.put("deploymentId", processDefinition.getDeploymentId());
		map.put("resourceName", processDefinition.getDiagramResourceName());
		
//		System.out.println("deploymentId = "+processDefinition.getDeploymentId());
//		System.out.println("resourceName = "+processDefinition.getResourceName());
//		System.out.println("DiagramResourceName = "+processDefinition.getDiagramResourceName());
//		System.out.println("name = "+processDefinition.getName());
//		System.out.println("Key = "+processDefinition.getKey());
		
		/**二：查看当前活动，获取当期活动对应的坐标x,y,width,height，将4个值存放到Map<String,Object>中*/
		Map<String, Object> maps = deoploymentProcessDefinition.findCoordingByTask(processEngine,id);
		map.put("acs", maps);
		System.out.println("acs>>Maps>> = "+maps.toString());
		return "WEB-INF/myself/image";
	}
	
	//账户充值
		@RequestMapping("/deposit")
		public String experienceGold(){
			return "WEB-INF/myself/recharge";
		}
		
//充值记录
		@RequestMapping("/rechargeRecords")
		public String rechargeRecords(){
			return "redirect:/sushuang1/getmemberdepo1";//跳转到controller
			
		}
		
		//安全信息
		@RequestMapping("/security")
		public String security(){
			return "WEB-INF/myself/security";
		}
				
				//我要提款
				@RequestMapping("/drawMoney")
				public String drawMoney(){
					return "WEB-INF/myself/drawMoney";
																	//我没有写参数  
				//return "redirect:/sushuang1/getmemberwithdraw1";//跳转到 Ss_zhmanagecontroller 方法里
				}
				//我是理财师
				@RequestMapping("/financialPlanner")
				public String financialPlanner(){
					return "WEB-INF/myself/financialPlanner";
				}

	// 进入用户登录界面
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "WEB-INF/login/login";
	}

	// 进入用户注册界面
	@RequestMapping("/toRegistration")
	public String toRegistration(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		return "WEB-INF/registration/registration";
	}

	/**
	 * 前台登陆
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/memberLogin")
	public String userLogin(Member member,Map<String,Object> map,HttpSession session) {
		System.out.println("登录用户填写信息:name="+member.getName()+",password="+member.getPassword());
		//从数据库中根据用户名查询
		try {
			Member member2 = memberService.selectGetByName(member.getName());

			// 盐值加密
			String hashAlgorithmName = "MD5";
			Object credentials = member.getPassword();
			Object obj = ByteSource.Util.bytes(member.getName());
			int hashIterations = 1024;
			Object result = new SimpleHash(hashAlgorithmName, credentials, obj,
					hashIterations);
			member.setPassword(result.toString());
			System.out.println("加密之后密码比对:登录用户的密码="+member.getPassword());
			System.out.println("加密之后密码比对:数据库中的密码="+member2.getPassword());
			if(member.getPassword().equals(member2.getPassword())){
				System.out.println("登陆成功!");
				System.out.println("Member的信息:"+member2.toString());
				session.setAttribute("memberinfo", member2);
				return "redirect:/itemweb/index";
			}else{
				System.out.println("密码错误");
				map.put("errorinfo", "密码错误");
			}
		}catch (IndexOutOfBoundsException e1) {
			System.out.println("用户不存在");
			map.put("errorinfo", "用户不存在");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/itemweb/toLogin";
	}

	public void login(String name, String password,RedirectAttributes attributes) {
		//退出当前的用户
		allUserLogout();
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(name, password);
		try {
			subject.login(token);
			Session session = subject.getSession();
//			System.out.println("sessionId:"+session.getId());
//			System.out.println("sessionHost:"+session.getHost());
//			System.out.println("sessionTimeout:"+session.getTimeout());
			//查询用户的信息
			session.setAttribute("userinfo", userService.getUserByUserName(name));
		}catch(UnknownAccountException uae){
            System.out.println("对用户[" + name + "]进行登录验证..验证未通过,未知账户");  
            attributes.addFlashAttribute("errorMsg", "未知账户！"); 
        }catch(IncorrectCredentialsException ice){  
            System.out.println("对用户[" + name + "]进行登录验证..验证未通过,错误的凭证");  
            attributes.addFlashAttribute("errorMsg", "密码不正确");  
        }catch(LockedAccountException lae){  
            System.out.println("对用户[" + name + "]进行登录验证..验证未通过,账户已锁定");  
            attributes.addFlashAttribute("errorMsg", "账户已锁定");  
        }catch(ExcessiveAttemptsException eae){  
            System.out.println("对用户[" + name + "]进行登录验证..验证未通过,错误次数过多");  
            attributes.addFlashAttribute("errorMsg", "用户名或密码错误次数过多");  
        }catch(AuthenticationException ae){  
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
            System.out.println("对用户[" + name + "]进行登录验证..验证未通过,堆栈轨迹如下");  
            ae.printStackTrace();  
            attributes.addFlashAttribute("errorMsg", "用户名或密码不正确");  
        }  catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 退出 返回到后台登陆页面
	 * 
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout() {
		allUserLogout();
		return "redirect:/itemweb/backstageLogin";
	}
	
	public void allUserLogout(){
		SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
	}
	/**
	 * 前台用户退出	返回index
	 * @param name
	 * @param password
	 * @param attributes
	 * @return
	 */
	@RequestMapping("webUserLogout")
	public String webUserLogout(HttpSession session){
		//清除session
		session.invalidate();
		return "redirect:/itemweb/toLogin";
	} 

	/**
	 * 后台用户登录
	 * @param name
	 * @param password
	 * @param attributes
	 * @return
	 */
	@RequestMapping("/backstageUserLogin")
	public String backstageUserLogin(@RequestParam("name") String name,
			@RequestParam("password") String password,RedirectAttributes attributes) {
		login(name, password,attributes);
		return "redirect:/itemweb/backstage";
	}
	
	//随机生成邀请码
    //生成随机数字和字母,  
    public String getStringRandom(int length) {  
          
        String val = "";  
        Random random = new Random();  
          
        //参数length，表示生成几位随机数  
        for(int i = 0; i < length; i++) {  
              
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";  
            //输出字母还是数字  
            if( "char".equalsIgnoreCase(charOrNum) ) {  
                //输出是大写字母还是小写字母  
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;  
                val += (char)(random.nextInt(26) + temp);  
            } else if( "num".equalsIgnoreCase(charOrNum) ) {  
                val += String.valueOf(random.nextInt(10));  
            }  
        }  
        return val;  
    }

	// 用户注册
	@RequestMapping("/userRegistration")
	public String userRegistration(Member member,
			@RequestParam(required = false) String invitedCode) {
		System.out.println("invitedCode = " + invitedCode);
		System.out.println("用户注册信息:用户名="+member.getName()+",password="+member.getPassword());
//		private Date createDate;  //创建时间
		member.setCreateDate(new Date());
//		private byte delFlag;  //删除标志
		member.setDelFlag((byte)0);
//		private BigInteger headid; // 头像图片id
		member.setHeadid(null);
//		private String identity;//身份证
		member.setIdentity(null);
//		private String invitationCode;  //邀请码
		//随即生成6位数字和字母的组合
		member.setInvitationCode(getStringRandom(6));
//		private String invitedCode;  //被邀请码
		member.setInvitedCode(invitedCode);
//		private String memberName;  //真实姓名
		member.setMemberName(member.getMemberName());
//		private String mobile_Phone;  //手机号
		member.setMobile_Phone(member.getMobile_Phone());
//		private String name;   //用户名
//		private String salt;  //密码盐
		member.setSalt(member.getName());
//		private String password;  //密码
		// 盐值加密
		String hashAlgorithmName = "MD5";
		Object credentials = member.getPassword();
		Object obj = ByteSource.Util.bytes(member.getName());
		int hashIterations = 1024;
		Object result = new SimpleHash(hashAlgorithmName, credentials, obj,
				hashIterations);
		System.out.println("password = " + member.getPassword() + ",盐值加密之后 = "
				+ result);
		member.setPassword(result.toString());
//		private String qqAccount;  //QQ账号关联	null
//		private String qqNumber;  //QQ号码	null
//		private byte status; //账号状态（正常，锁定，删除）
		member.setStatus((byte)0);
//		private Date updateDate; //修改时间
		member.setUpdateDate(new Date());
//		private String weiBoAccount; //微博账号关联	null
//		private String weixinAccount;  //微信账号关联	null
//		private String withdrawPassword;  //提款密码	null
		// 输出用户信息
		System.out.println(member.toString());
		// 添加用户信息
		try {
			memberService.save(member);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/itemweb/toRegistration";
		}
		return "redirect:/itemweb/toLogin";
	}

	// 返回首页
	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	// 后台显示页面
	@RequestMapping("/backstage")
	public String backstage() {
		return "WEB-INF/backstage/show";
	}

	// 后台登陆页面
	@RequestMapping("/backstageLogin")
	public String backstageLogin() {
		return "WEB-INF/backstage/login";
	}

	// 错误页面
	@RequestMapping("/error")
	public String error() {
		return "WEB-INF/error/error";
	}

	// 网上体验中心
	@RequestMapping("/experience")
	public String experience() {
		return "WEB-INF/experience/experience";
	}

	// 产品中心
	@RequestMapping("/products")
	public String products() {
		return "WEB-INF/products/products";
	}

	// 新闻中心
	@RequestMapping("/news")
	public String news() {
		return "WEB-INF/news/news";
	}

	// 下载中心
	@RequestMapping("/download")
	public String download() {
		return "WEB-INF/download/download";
	}

	// 商学院
	@RequestMapping("/business")
	public String business() {
		return "WEB-INF/business/business";
	}

	// 投研中心
	@RequestMapping("/research")
	public String research() {
		return "WEB-INF/research/research";
	}

	// 我的加法库    收益记录
	@RequestMapping("/myself")
	public String myself() {
		return "redirect:/sushuang1/getmemberprofit1"; //跳转到 controller
	}
	
	//忘记密码
	@RequestMapping("/forgetPassword")
	public String forgetPassword(){
		return "WEB-INF/forgetPassword/forgetPassword";
	}
	
	//到产品购买页面
	@RequestMapping("/toBuyProducts/{id}")
	public String toBuyProducts(@PathVariable(value="id")String id){
		return "WEB-INF/products/buyProducts";
	}
	//投资记录
	@RequestMapping("/invests")
	public String invests(){
		return "redirect:/sushuang1/getsubjectpur"; //跳转到 controller
	}
	
		
	 //体验金记录
	@RequestMapping("/experienceGold")
	public String goldexperience(){
		return "redirect:/sushuang1/getbbin";  //跳转到controller
	}
	
}
