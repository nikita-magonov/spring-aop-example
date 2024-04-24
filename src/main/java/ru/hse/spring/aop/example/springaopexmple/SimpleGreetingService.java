package ru.hse.spring.aop.example.springaopexmple;

public class SimpleGreetingService implements GreetingService {

    @Log
    @Override
    public String createGreeting(String name) {
        return "Hello, " + name + "!";
    }
}
