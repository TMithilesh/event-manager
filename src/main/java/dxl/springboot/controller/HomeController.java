package dxl.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{

	@RequestMapping("/")
	public String frontPage(Model model)
	{
		model.addAttribute("message", "DXL");
		return "home";
	}
}
