package pickle.community_pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pickle.community_pro.dto.QuestionDTO;
import pickle.community_pro.mapper.QuestionMapper;
import pickle.community_pro.mapper.UserMapper;
import pickle.community_pro.model.Question;
import pickle.community_pro.model.User;
import pickle.community_pro.service.QuestionService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @ClassName HelloController
 * @Description
 * @Author 黑奔驰
 * @Date 2019/12/6 19:43
 * @Verison 1.0
 **/
@Controller
public class IndexController{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model){

        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }

        List<QuestionDTO> questionList = questionService.list();
        model.addAttribute("questions",questionList);

        return "index";
    }
}
