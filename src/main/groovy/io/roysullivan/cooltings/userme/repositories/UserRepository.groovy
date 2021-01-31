package io.roysullivan.cooltings.userme.repositories

import io.roysullivan.cooltings.userme.entities.user.UserEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface UserRepository extends ReactiveMongoRepository<UserEntity, UUID>{

}