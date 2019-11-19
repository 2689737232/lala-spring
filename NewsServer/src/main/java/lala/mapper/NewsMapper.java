package lala.mapper;

import lala.po.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewsMapper {
    // 消息列表
    @Select("select * from tb_news")
    List<News>getHomeNews();

    // 轮播图列表
    @Select("select * from tb_news where newsId in (select newsId from tb_banner)")
    List<News>getBannerNews();

    // 通过id查找news
    @Select("select * from tb_news where newsId = #{newsId}")
    News getNewsById(Integer newsId);
}
