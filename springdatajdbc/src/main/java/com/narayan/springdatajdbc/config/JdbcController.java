package com.narayan.springdatajdbc.config;


import com.narayan.springdatajdbc.details.UserDetails;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/jdbc")
public class JdbcController {


    @GetMapping
    public String get (Model model){
        model.addAttribute("obj",new UserDetails());
        return "template";
    }

    @PostMapping
    public String post(@ModelAttribute("obj") UserDetails userDetails, Model model){
        JDBC SQL  = new JDBC();
        int result = SQL.insert(userDetails);
        if( result == 1 )
            model.addAttribute("message","Successful JDBC connection and execution of SQL statement");
        else
            model.addAttribute("message","Query not submitted!");
        return "Status";
    }

}
