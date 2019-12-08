package pickle.community_pro.controller;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pickle.community_pro.dto.AccessTokenDTO;
import pickle.community_pro.dto.GithubUser;
import pickle.community_pro.provider.GithubProvider;

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

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                                 @RequestParam(name="state")String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(ClientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);

        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);

        return "index";
    }
}
