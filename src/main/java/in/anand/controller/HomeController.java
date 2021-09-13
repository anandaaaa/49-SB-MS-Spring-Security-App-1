package in.anand.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String getHomeController()
	{
		return "homepage";
	}
	
	@GetMapping("/welcome")
	public String getWelcomeController()
	{
		return "welcome";
	}
	
	@GetMapping("/admin")
	public String getAdminController()
	{
		return "admin";
	}
	
	@GetMapping("/employee")
	public String getEmployeeController()
	{
		return "employee";
	}
	
	@GetMapping("/manager")
	public String getManagerController()
	{
		return "manager";
	}
	
	@GetMapping("/common")
	public String getCommonController()
	{
		return "common";
	}

	@GetMapping("/accessDenied")
	public String getAccessDeniedController()
	{
		return "accessDenied";
	}


}
