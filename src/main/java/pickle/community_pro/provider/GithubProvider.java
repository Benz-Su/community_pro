package pickle.community_pro.provider;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.stereotype.Component;
import pickle.community_pro.dto.AccessTokenDTO;
import pickle.community_pro.dto.GithubUser;

import java.io.IOException;

/**
 * @ClassName GthubProvider
 * @Description
 * @Author 黑奔驰
 * @Date 2019/12/8 15:51
 * @Verison 1.0
 **/
@Component
public class GithubProvider{

    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        //JSON.toJSONString是将对象转化为Json字符串
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            //System.out.println(string);
            //access_token=902a475fc19dddda7e1d21f79aa2b19870ebfef5&scope=user&token_type=bearer
            String[] split = string.split("&");
            String tokenStr = split[0];
            String token = tokenStr.split("=")[1];

            return token;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String string =  response.body().string();

            //JSON.parseObject是将Json字符串转化为相应的对象
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
