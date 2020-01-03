package pickle.community_pro.model;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName User
 * @Description
 * @Author 黑奔驰
 * @Date 2019/12/9 18:15
 * @Verison 1.0
 **/
@Data
public class User{

    private Integer id;
    private String account_id;
    private String name;
    private String token;
    private Long gmt_created;
    private Long gmt_modified;
    private String bio;
    private String avatar_url;
}
