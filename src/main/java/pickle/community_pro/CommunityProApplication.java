package pickle.community_pro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("pickle.community_pro.mapper")
@SpringBootApplication
public class CommunityProApplication{

    public static void main(String[] args) {
        SpringApplication.run(CommunityProApplication.class, args);
    }

}
