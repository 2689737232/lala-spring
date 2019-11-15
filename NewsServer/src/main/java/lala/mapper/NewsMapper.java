package lala.mapper;

import lala.po.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewsMapper {
    @Select("select * from tb_news")
    List<News>getHomeNews();

    @Select("select * from tb_banner")
    List<News>getBannerNews();
}
