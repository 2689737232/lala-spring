package lala.controller;

import lala.mapper.NewsMapper;
import lala.po.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {
    @Autowired
    private NewsMapper newsMapper;
    @GetMapping("/news/banners")
    public List<News> getBannerNews(){
        return  newsMapper.getHomeNews();
    }
}
