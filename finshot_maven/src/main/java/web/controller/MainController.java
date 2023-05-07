package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(){
        return "index"; // index.jsp로 이동
    }
    @GetMapping("/main")
    public String main(){
        return "main";
    }
}
