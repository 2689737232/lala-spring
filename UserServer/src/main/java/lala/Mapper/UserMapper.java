package lala.Mapper;

import lala.po.Collection;
import lala.po.Encrypted;
import lala.po.News;
import lala.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    // 登录
    @Select("select * from tb_user where userAccount = #{arg0} and userPassword = #{arg1}")
    User logging( String userAccount,String userPassword);

    @Select("select * from tb_user where userId = #userId")
    User getUserById(Integer userId);

    // 插入
    @Insert("INSERT INTO tb_user (userAccount,userPassword) VALUES(#{arg0},#{arg1})")
    Integer register(String userAccount,String userPassword);

    // 获取用户收藏
    @Select("select * from tb_collection where userAccount = #{userAccount}")
    List<Collection> getUserCollection(Integer userAccount);

    // 获取密保
    @Select("select * from tb_encrypted where userAccount = #{userAccount}")
    Encrypted getCollection(Integer userAccount);

    // 更改密码
    @Update("UPDATE tb_user SET userPassword = #{arg0} WHERE userAccount = #{arg1}")
    Integer setPassword(String userPassword,Integer userAccount);
}
