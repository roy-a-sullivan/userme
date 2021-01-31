package io.roysullivan.cooltings.userme.services

import io.roysullivan.cooltings.userme.entities.user.UserEntity
import io.roysullivan.cooltings.userme.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserService {
    @Autowired
    UserRepository userRepository
}
