package dograre.controller;

import dograre.entity.Card;
import dograre.entity.Usr;
import dograre.mapper.CardMapper;
import dograre.mapper.UsrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@SuppressWarnings("PMD.ClassNamingShouldBeCamelRule")
public class APIController {

    @Autowired
    private UsrMapper usrMapper;

    @Autowired
    private CardMapper cardMapper;

    public APIController() {
    }

    //登录的api
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> data, HttpServletResponse response) {
        String username = data.get("username");
        String password = data.get("password");
        String responseJson;

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
    public String checkname(@RequestBody Map<String, String> data) {
        if(usrMapper.getIdByName(data.get("username"))!=null) {
            return "{\"status\": \"bad\", \"errMsg\": \"用户名已存在\"}";
        }
        if(usrMapper.getIdByNickName(data.get("name"))!=null)  {
            return"{\"status\": \"bad\", \"errMsg\": \"昵称已存在\"}";
        }
        return "{\"status\": \"good\", \"errMsg\": \"用户名可用\"}";
    }

    //注册请求的api
    @PostMapping("/sign")
    public String sign(@RequestBody Map<String, String> data) {
        Usr newUsr = new Usr(data.get("usrname"), data.get("pwd"), data.get("nickname"));
        if (usrMapper.insertUsr(newUsr)) {
            return "{\"status\": \"good\", \"Msg\": \"注册成功\"}";
        } else {
            return "{\"status\": \"bad\", \"errMsg\": \"注册失败，请稍后重试\"}";
        }
    }

    @GetMapping("/card")
    public List<Card> cards(@CookieValue(name = "session_id") String session) {
        List<Card> res = new ArrayList<>();
        String cards = usrMapper.getCardlistByID(Integer.parseInt(session));
        for (int i = 0; i < cards.length(); i++) {
            if (cards.charAt(i) == '1') res.add(cardMapper.getCardById(i + 1));
        }
        return res;
    }

    @GetMapping("/single")
    public Card card(@CookieValue(name = "session_id") String session) {
        return cardMapper.getCardById(1);
    }

    @GetMapping("/tencards")
    public List<Card> tenCards(@CookieValue(name = "session_id") String session) {
        usrMapper.setCard(Integer.parseInt(session), "1111111111");
        List<Card> res = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            res.add(cardMapper.getCardById(i + 1));
        }
        return res;
    }

    @GetMapping("crystal")
    public int crystal(@CookieValue(name = "session_id") String session){
        return usrMapper.getCrystalByID(Integer.parseInt(session));
    }

    @RequestMapping("/test")
    public boolean test() {
        return usrMapper.setCard(1, "0001110001");
    }


}



