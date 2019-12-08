package pickle.community_pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @ClassName HelloController
 * @Description
 * @Author 黑奔驰
 * @Date 2019/12/6 19:43
 * @Verison 1.0
 **/
@Controller
public class IndexController{

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
