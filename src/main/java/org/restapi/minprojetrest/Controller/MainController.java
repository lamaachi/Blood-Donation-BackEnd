package org.restapi.minprojetrest.Controller;


import org.restapi.minprojetrest.Service.CenterService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class MainController {

    CenterService centerService;

    public MainController(CenterService centerService) {
        this.centerService = centerService;
    }
    @GetMapping("hello")
    public String getHello(){
        return "Hello World";
    }

}
