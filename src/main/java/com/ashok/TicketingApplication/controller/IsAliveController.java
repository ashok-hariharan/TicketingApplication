package com.ashok.TicketingApplication.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class IsAliveController {

	@RequestMapping("/")
	public String index() {
		return "Ticketing Application is Alive";
	}

}