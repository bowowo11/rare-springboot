package dograre.controller;

import dograre.entity.Usr;
import dograre.mapper.UsrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    //登录的api
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

    //根据session 获取用户
    @GetMapping("/usr")
    public Usr getUsr(@CookieValue(name = "session_id") String sessionID, HttpServletResponse response) {
        Usr res = usrMapper.getUsrByID(sessionID);
        if (res != null) return res;
        response.setStatus(HttpStatus.FORBIDDEN.value());
        return null;
    }

    //用于注册时检验用户名是否唯一的api
    @PostMapping("/checkname")
    public String checkname(@RequestBody Map<String,String> data){
        if(usrMapper.getIdByName(data.get("name"))!=null)  return "{\"status\": \"bad\", \"errMsg\": \"用户名已存在\"}";
         return "{\"status\": \"good\", \"errMsg\": \"用户名可用\"}";
    }

    //注册请求的api
    @PostMapping("/sign")
    public boolean sign(@RequestBody Map<String,String> data,HttpServletResponse response){
        return true;
    }



    @RequestMapping("/test")
    public boolean test() {
        return usrMapper.insertUsr(new Usr("root2","123456","奥特曼"));
    }


}
