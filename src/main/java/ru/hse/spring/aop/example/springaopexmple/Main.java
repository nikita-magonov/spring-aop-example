package ru.hse.spring.aop.example.springaopexmple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class Main {

    @Bean
    GreetingService greetingService() {
        return new SimpleGreetingService();
    }

    @Bean
    LogAspect logAspect() {
        return new LogAspect();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);

        GreetingService greetingService = applicationContext.getBean(GreetingService.class);

        System.out.println(greetingService.createGreeting("Ivan"));
    }
}
