package pickle.community_pro.mapper;


import org.apache.ibatis.annotations.Insert;
import pickle.community_pro.model.User;


/**
 * @ClassName UserMapper
 * @Description
 * @Author 黑奔驰
 * @Date 2019/12/9 18:07
 * @Verison 1.0
 **/


public interface UserMapper{

    @Insert("insert into user (account_id,name,token,gmt_created,gmt_modified) values ('${account_id}','${name}','${token}',${gmt_created},${gmt_modified})")
    void insert(User user);

}
