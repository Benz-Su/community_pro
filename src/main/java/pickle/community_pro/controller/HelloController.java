package pickle.community_pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName HelloController
 * @Description
 * @Author 黑奔驰
 * @Date 2019/12/6 19:43
 * @Verison 1.0
 **/
@Controller
public class HelloController{

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name")String name, Model model){

        model.addAttribute("name",name);
        return "hello";
    }
}
