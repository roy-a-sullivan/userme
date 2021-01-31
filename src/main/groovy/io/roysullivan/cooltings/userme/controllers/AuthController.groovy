package io.roysullivan.cooltings.userme.controllers

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

import java.security.Principal

@RestController
class AuthController {

    private static Logger LOGGER =
            LoggerFactory.getLogger(this.getClass())

    @GetMapping("/")
    Mono<String> greet() {
        LOGGER.info("NO_AUTH")

        return Mono.justOrEmpty("PUBLIC_VIEW")
    }

    @GetMapping("/admin/dashboard")
    Mono<String> greetAdmin(Principal principal) {
        LOGGER.info(principal.getName().toString())

        return Mono.justOrEmpty(principal.getName())
    }
}
