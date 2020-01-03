package pickle.community_pro.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pickle.community_pro.model.User;


/**
 * @ClassName UserMapper
 * @Description
 * @Author 黑奔驰
 * @Date 2019/12/9 18:07
 * @Verison 1.0
 **/


public interface UserMapper{

    @Insert("insert into user (account_id,name,token,gmt_created,gmt_modified,bio,avatar_url) values (#{account_id},#{name},#{token},#{gmt_created},#{gmt_modified},#{bio},#{avatar_url})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id")Integer id);
}
