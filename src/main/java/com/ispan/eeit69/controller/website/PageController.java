package com.ispan.eeit69.controller.website;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/index.html")
	public String toJumpPageIndex() {
		System.out.println("跳转页面index");
		return "index";
	}
	
	@GetMapping("/index")
	public String toJumpPageIndexJSP() {
		System.out.println("跳转页面index");
		return "index";
	}
	
	@GetMapping("/EnterInvitationCode")
	public String toJumpPageEnterInvitationCode() {
		System.out.println("跳转EnterInvitationCode页面");//所有商品列表
		return "EnterInvitationCode";
	}

	@GetMapping("/login.html")//登入畫面
	public String toJumpPageLogin() {
		System.out.println("跳转页面login");
		return "login";
	}
	
	@GetMapping("/loginOk")//登入成功
	public String toJumpPageLoginOk() {
		System.out.println("跳转页面login");
		return "loginOk";
	}

	@GetMapping("/contact.html")
	public String toJumpPageContact() {
		System.out.println("跳转页面contact");
		return "contact";
	}

	@GetMapping("/OderSystem.html")
	public String toJumpPageOderSystem() {
		System.out.println("跳转页面OderSystem");
		return "OderSystem";
	}

	@GetMapping("/plan.html")
	public String toJumpPagePlan() {
		System.out.println("跳转页面");
		return "plan";
	}

	@GetMapping("/Report.html")
	public String toJumpPageReport() {
		System.out.println("跳转页面");
		return "Report";
	}

	@GetMapping("/register")//註冊頁面
	public String toJumpPageregister() {
		System.out.println("跳转页面");
		return "register";
	}

	@GetMapping("/registerOk")
	public String toJumpPageregisterOk() {
		System.out.println("跳转registerOk页面");
		    return "registerOk";
	}

	@GetMapping("/resuApiPutTest")
	public String toJumpPageResuApiPutTestk() {
		System.out.println("跳转resuApiPutTest页面");
		return "resuApiPutTest";
	}

	@GetMapping("/BusinessInformation")
	public String toJumpPageBusinessInformation(HttpSession session) {
		System.out.println("跳转BusinessInformation页面");
		Object levelObject = session.getAttribute("level");
		if (levelObject != null) {
			String level = levelObject.toString();
			if ("A".equals(level)) {
				return "BusinessInformation";
			}
		}
		return "login";
	}

}