package dograre.controller;

import dograre.entity.Usr;
import dograre.mapper.UsrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/api")
@SuppressWarnings("PMD.ClassNamingShouldBeCamelRule")
public class APIController {

    @Autowired
    private UsrMapper usrMapper;

    public APIController() {
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> data, HttpServletResponse response) {
        String username = data.get("username");
        String password = data.get("password");
        String responseJson = "";

        if (password.equals(usrMapper.findPswByName(username))) {
            String sessionId = usrMapper.getIdByName(username);
            Cookie cookie = new Cookie("session_id", sessionId);
            cookie.setHttpOnly(false);
            cookie.setPath("/");
            response.addCookie(cookie);
            responseJson = "{\"status\": \"good\"}";
        }
//        // 如果不正确，返回一个错误的json信息
        else {
            responseJson = "{\"status\": \"bad\", \"errMsg\": \"用户名密码错误\"}";
        }
        return responseJson;
    }

    @RequestMapping("/test")
    public Usr test() {
        return usrMapper.getUsrByID(1);
    }




}
