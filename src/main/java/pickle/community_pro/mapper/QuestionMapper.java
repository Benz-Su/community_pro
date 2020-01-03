package pickle.community_pro.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import pickle.community_pro.model.Question;

import java.util.List;

/**
 * @ClassName QuestionMapper
 * @Description
 * @Author 黑奔驰
 * @Date 2019/12/18 20:14
 * @Verison 1.0
 **/
public interface QuestionMapper{

    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmt_create},#{gmt_modified},#{creator},#{tag})")
    void create(Question question);

    @Select("select * from question")
    List<Question> list();
}
