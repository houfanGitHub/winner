package com.item.finance.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.item.finance.bean.User;
import com.item.finance.bean.UserRole;
import com.item.finance.bean.UserRoleRelation;
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
	@RequestMapping("/userLogin")
	public String userLogin(User user,RedirectAttributes attributes) {
		login(user.getName(), user.getPassword(),attributes);
		// 登录成功后会跳转到successUrl配置的链接，不用管下面返回的链接。
		return "redirect:/itemweb/index";
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
	public String webUserLogout(){
		allUserLogout();
		return "redirect:/itemweb/toLogin";
	} 

	@RequestMapping("/backstageUserLogin")
	public String backstageUserLogin(@RequestParam("name") String name,
			@RequestParam("password") String password,RedirectAttributes attributes) {
		login(name, password,attributes);
		return "redirect:/itemweb/backstage";
	}

	// 用户注册
	@RequestMapping("/userRegistration")
	public String userRegistration(User user,
			@RequestParam(required = false) String invitationCode) {
		System.out.println("invitationCode = " + invitationCode);

		Date createDate = new Date(); // 创建时间
		// byte delFlag = '0'; //删除标志
		String identity = "0"; // 身份
		String salt = user.getName(); // 密码盐
		byte status = 0; // 账号状态(正常，锁定，删除)
		user.setCreateDate(createDate);
		user.setIdentity(identity);
		user.setSalt(salt);
		user.setStatus(status);
		// 盐值加密
		String hashAlgorithmName = "MD5";
		Object credentials = user.getPassword();
		Object obj = ByteSource.Util.bytes(user.getName());
		int hashIterations = 1024;
		Object result = new SimpleHash(hashAlgorithmName, credentials, obj,
				hashIterations);
		System.out.println("password = " + user.getPassword() + ",盐值加密之后 = "
				+ result);
		user.setPassword(result.toString());
		// 输出用户信息
		System.out.println(user.toString());

		// 添加用户信息
		try {
			userService.save(user);
			// 查询普通用户的信息
			UserRole userRole = userRoleService.selectGetById("4");
			// 添加角色信息
			UserRoleRelation urr = new UserRoleRelation(user, userRole,
					new Date());
			userRoleRelationService.save(urr);
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

	// 我的加法库
	@RequestMapping("/myself")
	public String myself() {
		return "WEB-INF/myself/myself";
	}
	
	//忘记密码
	@RequestMapping("/forgetPassword")
	public String forgetPassword(){
		return "WEB-INF/forgetPassword/forgetPassword";
	}
}
