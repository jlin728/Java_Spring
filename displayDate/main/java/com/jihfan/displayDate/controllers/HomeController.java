package com.jihfan.displayDate.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class HomeController {
	@RequestMapping("/")
    public String index (Model model) {
		model.addAttribute("dojoname", "Burbank");
        return "index.jsp";
    }
	
	@RequestMapping("/time")
    public String time (Model model) {
		Date date = new Date();
		String sdf = "HH:mm:ss a"; 
		DateFormat formattedDate = new SimpleDateFormat(sdf);
		String time = formattedDate.format(date);
//		System.out.println(time);
		model.addAttribute("time", time);
		return "time.jsp";
    }
	
	@RequestMapping("/date")
	public String date (Model model) {
		Date myDate = new Date();
		SimpleDateFormat day = new SimpleDateFormat("EEEE");
		SimpleDateFormat date = new SimpleDateFormat("dd");
		SimpleDateFormat month = new SimpleDateFormat("MMMM");
		SimpleDateFormat year = new SimpleDateFormat("yyy");
		String strDay = day.format(myDate);
		String strDate = date.format(myDate);
		String strMon = month.format(myDate);
		String strYear = year.format(myDate);
		String sent = strDay + ", the " + strDate + " of " + strMon + ", " + strYear; 
		model.addAttribute("date", sent);
        return "date.jsp";
    }
	
	
	
//	@RequestMapping("/date")
//	public String date (Model model) {
//		Date myDate = new Date();
//		model.addAttribute("date", myDate);
//		// Sunday + ", the"+ dd + "of " + MMM + ", " + yyyy
//        return "date.jsp";
//	}
//		dateFormatter = new SimpleDateFormat("EEEE, MMMM d, yyyy");
//		System.out.println("Format 3:   " + dateFormatter.format(now));
}
