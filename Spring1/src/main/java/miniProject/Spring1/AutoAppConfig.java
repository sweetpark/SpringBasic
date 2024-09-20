package miniProject.Spring1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AutoAppConfig {
    //외부 라이브러리의 경우 @Bean 옵션을 이용하여 콜백함수 처리
    @Bean(initMethod = "create", destroyMethod = "end")
    public BeanCallBackMethod beanCallBackMethod(){
        BeanCallBackMethod bc = new BeanCallBackMethod();
        return bc;
    }
}
