package com.example.demo

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class DemoApplication
{
    @Bean
    fun runLazily(personHandler: PersonHandler) = CommandLineRunner {

        personHandler.initialize()
    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
