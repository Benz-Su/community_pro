package pickle.community_pro.dto;

import lombok.Data;
import pickle.community_pro.model.User;

/**
 * @ClassName Question
 * @Description
 * @Author 黑奔驰
 * @Date 2019/12/18 20:41
 * @Verison 1.0
 **/
@Data
public class QuestionDTO{
    private Integer id;
    private String title;
    private String description;
    private Long gmt_create;
    private Long gmt_modified;
    private String tag;
    private Integer creator;
    private Integer view_count;
    private Integer comment_count;
    private Integer like_count;
    private User user;
}
