package lala.controller;

import lala.Mapper.UserMapper;
import lala.po.Collection;
import lala.po.Encrypted;
import lala.po.News;
import lala.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RestTemplate restTemplate;

    // 登录
    @GetMapping(path = "/logging/{userAccount}/{userPassword}")
    @ResponseBody
    public User logging(@PathVariable("userAccount") String userAccount, @PathVariable("userPassword") String userPassword) {
        User user = new User();
        try {
            user = userMapper.logging(userAccount, userPassword);
            return user;
        } catch (Exception e) {
            return null;
        }

    }

    // 注册
    @GetMapping(path = "/register/{userAccount}/{userPassword}")

    public Integer register(@PathVariable("userAccount") String userAccount, @PathVariable("userPassword") String userPassword) {
        try {
            Integer result = this.userMapper.register(userAccount, userPassword);
            return result;
        } catch (Exception e) {
            return -1;
        }
    }

    // 收藏
    @GetMapping("/getCollection/{userAccount}")
    @ResponseBody
    public List<News> getCollection(@PathVariable("userAccount") Integer userAccount) {
        List<Collection> collections = userMapper.getUserCollection(userAccount);
        List<News> news = new ArrayList<>();

        // 根据收藏查询新闻列表
        for (Collection collection : collections) {
            news.add(restTemplate.getForObject("http://localhost:8050/news-service/news/getNewsById/" + collection.getNewsId(), News.class));
        }
        return news;
    }

    //获取密保
    @GetMapping("/getEncrypted/{userAccount}")
    @ResponseBody
    public Encrypted getEncrypted(@PathVariable("userAccount") Integer userAccount) {
        return this.userMapper.getCollection(userAccount);
    }

    // 更改密码
    @GetMapping("/setPassword/{userAccount}/{newPassword}")
    @ResponseBody
    public Integer setPassword(@PathVariable("userAccount") Integer userAccount, @PathVariable("newPassword") String newPassword) {
        if(newPassword.length() > 12 || newPassword.length() < 6){
            return -1;
        }
        try {
            Integer result = userMapper.setPassword(newPassword, userAccount);
            System.out.println("*******" + result + "********************");
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
