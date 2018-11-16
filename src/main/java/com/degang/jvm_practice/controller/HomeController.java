package com.degang.jvm_practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by degang on 2018/11/15
 */
@Controller
public class HomeController {
    @ResponseBody
    @GetMapping("hello")
    public String hello() {
        return "hello world";
    }

    @ResponseBody
    @GetMapping("demo")
    public Map demo() {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        return allStackTraces;
    }

    @GetMapping("templateTest")
    public String templateTest(Model model) {
        model.addAttribute("list", Arrays.asList(1, 2, 3));
        return "jvm_console";
    }
}
