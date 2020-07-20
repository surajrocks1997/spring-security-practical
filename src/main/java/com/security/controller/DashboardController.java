package com.security.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.security.entities.User;

@Controller
public class DashboardController {

	@GetMapping("/dashboard")
	public String getDashboard(@AuthenticationPrincipal User user, ModelMap modelMap) {
		System.out.println(user);
		modelMap.put("user", user);
		return "dashboard";
	}
}
