package ro.unitbv.muzeu.cetateafagaras.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(path = "/test")
    public String test()
    {
        System.out.println("welcome");
        return "WELCOME";
    }
}
