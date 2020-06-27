package com.example.demo.contoroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPagerController {

	@RequestMapping("/MainPage")
	public String MainPage() {
		return "/MainPage";
	}
}
