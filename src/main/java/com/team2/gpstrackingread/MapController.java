package com.team2.gpstrackingread;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.*;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {
    @GetMapping("/")
    public String map(Model model) {
        return "index";
    }
}
