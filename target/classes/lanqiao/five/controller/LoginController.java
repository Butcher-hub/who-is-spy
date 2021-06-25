package lanqiao.five.controller;

import lanqiao.five.mvc.annotation.Controller;
import lanqiao.five.mvc.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public Map<String, String> login(String username, String password) {
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        return map;
    }

}
