package pickle.community_pro.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pickle.community_pro.dto.QuestionDTO;
import pickle.community_pro.mapper.QuestionMapper;
import pickle.community_pro.mapper.UserMapper;
import pickle.community_pro.model.Question;
import pickle.community_pro.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName QuestionService
 * @Description
 * @Author 黑奔驰
 * @Date 2020/1/4 0:56
 * @Verison 1.0
 **/
@Service
public class QuestionService{
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionsDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
//            将question所有属性的属性值一一对应的赋值给questionDTO
            BeanUtils.copyProperties(question,questionDTO);

            questionDTO.setUser(user);
            questionsDTOList.add(questionDTO);
        }
        
        return questionsDTOList;
    }
}
