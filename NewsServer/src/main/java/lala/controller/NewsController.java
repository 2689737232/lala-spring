package lala.controller;

import lala.mapper.NewsMapper;
import lala.po.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsMapper newsMapper;
    @GetMapping("/homeNews")
    public List<News> getHomeNews(){
        return  newsMapper.getHomeNews();
    }

    @GetMapping("/bannerNews")
    public List<News> getBannerNews(){
        return  newsMapper.getBannerNews();
    }

    @GetMapping("/getNewsById/{newsId}")
    public News getNewsById(@PathVariable("newsId") Integer newsId){
        return  newsMapper.getNewsById(newsId);
    }
}
