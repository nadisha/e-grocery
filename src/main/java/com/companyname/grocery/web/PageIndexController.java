package com.companyname.grocery.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageIndexController {
	
	@RequestMapping("/")
	public String homePage() {
		return "homepage";
	}
	
	@RequestMapping("/registration")
	public String registrationPage() {
		return "registerpage";
	}	
	
	@RequestMapping("/login")
	public String loginPage() {
		return "logipage";
	}
	
	@RequestMapping("/dashboard1")
	public String adminDashboardPage() {
		return "dashboard1page";
	}
	
	@RequestMapping("/dashboard2")
	public String userDashboardPage() {
		return "dashboard2page";
	}
	
	@RequestMapping("/roleAssignment")
	public String roleAssignmentPage() {
		return "roleAssignment";
	}	
}
