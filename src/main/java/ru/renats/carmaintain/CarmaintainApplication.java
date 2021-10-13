package ru.renats.carmaintain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class CarmaintainApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarmaintainApplication.class, args);
    }

//    @Bean
//    public ViewResolver viewResolver() {
//        final InternalResourceViewResolver r = new InternalResourceViewResolver();
//        r.setPrefix("/WEB-INF/jsp/");
//        r.setSuffix(".jsp");
//        return r;
//    }

}
