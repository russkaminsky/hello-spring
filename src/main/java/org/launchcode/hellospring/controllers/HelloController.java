package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/** Created by Russ */
@Controller
public class HelloController {

    // Responds to get requests at http://localhost:8080/hello
    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss");
        String dateTimeString = myFormatObj.format(LocalDateTime.now());
        return "Hello, Spring!<br>" + dateTimeString;
    }

    // Responds to get requests at http://localhost:8080/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public static String goodbye(){
        return "Goodbye, Spring!";
    }

    // Responds to get requests at http://localhost:8080/helloTemplate
    @GetMapping("helloTemplate")
    public String helloTemplate(Model model)    {
        //Test change 1
        return "hello";
    }

    // Responds to get requests at http://localhost:8080/helloTemplate2
    @GetMapping("helloTemplate2")
    public String helloTemplate2(Model model)    {
        //Clone of helloTemplate
        return "hello";
    }

    // Responds to get requests at http://localhost:8080/helloQuery?name=test123&friend=MyFriendr
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "helloQuery")
    @ResponseBody
    public String helloWithQuery(@RequestParam String name, @RequestParam String friend) {

        return "Hello, " + name + "!" + "<br>Hello friend, " + friend;
    }


    // Responds to get requests at http://localhost:8080/hello/WhateverGetsPutHere
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloAgain(@PathVariable String name)    {
        return "Hello, " + name + "!";
    }

    // Responds to get requests at http://localhost:8080/form
    @GetMapping("form")
    @ResponseBody
    public String helloForm(){
        String htmlString = "<html>" +
                "<body>" +
                "<form method = 'post' action = 'helloQuery'>" +
                "<input type = 'text' name = 'name' /><br>" +
                "<input type = 'text' name = 'friend' />" +
                "<input type = 'submit' value = 'Greet Me!' />" +
                "</form>" +
                "</body>" +
                "</html>";

        return htmlString;
    }
}
