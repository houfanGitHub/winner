package com.item.finance.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.config.AlipayConfig;
import com.item.finance.bean.Member;
import com.item.finance.bean.MemberBankcard;
import com.item.finance.services.MemberBankcardService;
import com.item.finance.services.MemberService;
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

	//充值
	@RequestMapping("/accountRecharge")
	public String accountRecharge(@RequestParam(value="fee")String fee,Map<String, Object> map,HttpServletRequest request) {
		//生成订单号
		String randomPayName = getRandomPayName();
//		map.put("serialNumber", randomPayName);
		//付款金额
//		map.put("amountDecimal", fee);
		//订单名称
//		map.put("payName", "富友账户充值");
		//商品描述
//		map.put("payinfo", "");
		//商户订单号，商户网站订单系统中唯一订单号，必填
//		String out_trade_no = randomPayName;
//				new String(request.getParameter("serialNumber").getBytes("ISO-8859-1"),"UTF-8");
		//付款金额，必填
//		String total_amount = fee;
//				new String(request.getParameter("amountDecimal").getBytes("ISO-8859-1"),"UTF-8");
		//订单名称，必填
//		String subject = "富友账户充值";
//				new String(request.getParameter("payName").getBytes("ISO-8859-1"),"UTF-8");
		//商品描述，可空
//		String body = null;
//				new String(request.getParameter("payinfo").getBytes("ISO-8859-1"),"UTF-8");
		
		request.setAttribute("serialNumber", randomPayName);
		request.setAttribute("amountDecimal", fee);
		request.setAttribute("payName", "富友账户充值");
		request.setAttribute("payinfo", "");
		
		return "/WEB-INF/myself/accountRecharge";
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
