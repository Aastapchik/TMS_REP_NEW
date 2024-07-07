package org.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class StartPageController {

    @GetMapping("/")
    public String startingPage(){
        return "startingPage";
    }
}
