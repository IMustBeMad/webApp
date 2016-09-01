package ua.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ua.web.config.HibernateConfig;
import ua.web.config.SecurityConfig;

@Configuration
@EnableAutoConfiguration(exclude=HibernateJpaAutoConfiguration.class)
@ComponentScan("ua.web")
@Import({SecurityConfig.class, HibernateConfig.class})
public class WebApp {

    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }
}
