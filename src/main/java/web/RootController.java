package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import service.UserService;

@Controller
public class RootController {

    @GetMapping("/")
    public String root() {
        return "entry";
    }
}
