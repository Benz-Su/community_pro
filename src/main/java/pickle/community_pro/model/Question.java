package pickle.community_pro.model;

import lombok.Data;

/**
 * @ClassName Question
 * @Description
 * @Author 黑奔驰
 * @Date 2019/12/18 20:41
 * @Verison 1.0
 **/
@Data
public class Question{
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
}
