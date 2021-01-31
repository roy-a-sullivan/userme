package io.roysullivan.cooltings.userme


import org.springframework.boot.SpringApplication
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import org.springframework.web.reactive.config.EnableWebFlux

@EnableWebFlux
@EnableReactiveMongoRepositories
@SpringBootApplication(exclude = [
            WebMvcAutoConfiguration.class,
            SecurityAutoConfiguration.class])
class UsermeApplication {
    static void main(String[] args) {
        SpringApplication.run(UsermeApplication, args)
    }
}
