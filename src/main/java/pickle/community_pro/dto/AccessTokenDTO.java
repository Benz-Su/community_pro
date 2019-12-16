package pickle.community_pro.dto;

import lombok.Data;

/**
 * @ClassName AccessTokenDTO
 * @Description 类和类之间网络传输数据
 * @Author 黑奔驰
 * @Date 2019/12/8 16:00
 * @Verison 1.0
 **/
@Data
public class AccessTokenDTO{
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
