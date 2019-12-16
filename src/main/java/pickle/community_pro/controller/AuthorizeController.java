package pickle.community_pro.controller;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pickle.community_pro.dto.AccessTokenDTO;
import pickle.community_pro.dto.GithubUser;
import pickle.community_pro.mapper.UserMapper;
import pickle.community_pro.model.User;
import pickle.community_pro.provider.GithubProvider;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName AuthorizeController
 * @Description
 * @Author 黑奔驰
 * @Date 2019/12/8 15:37
 * @Verison 1.0
 **/
@Controller
@Data
@ConfigurationProperties(prefix = "github")
public class AuthorizeController{

    @Autowired
    private GithubProvider githubProvider;

    private String clientId;
    private String ClientSecret;
    private String redirectUri;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name="state")String state,
                           HttpServletRequest request){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(ClientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);

        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if (githubUser != null) {
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
            user.setName(githubUser.getName());
            user.setAccount_id(String.valueOf(githubUser.getId()));
            user.setGmt_created(System.currentTimeMillis());
            user.setGmt_modified(user.getGmt_created());
            userMapper.insert(user);
            //登录成功，写入cookie和session
            request.getSession().setAttribute("user",githubUser);
            return "redirect:/";
        }else {
            //登录失败，重新登录
            return "redirect:/";
        }
    }
}
