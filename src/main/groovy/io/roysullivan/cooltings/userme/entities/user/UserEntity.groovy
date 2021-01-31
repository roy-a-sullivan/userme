package io.roysullivan.cooltings.userme.entities.user

import com.fasterxml.jackson.annotation.JsonIgnore
import io.roysullivan.cooltings.userme.entities.base.BaseEntity
import lombok.AllArgsConstructor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.security.core.userdetails.UserDetails

import javax.annotation.processing.Generated
import java.time.Instant

@Document(collection = "users")
@AllArgsConstructor
class UserEntity extends BaseEntity implements Serializable {
    @JsonIgnore
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass())

    @Generated
    private Long userIndex

    private String userName

    private String password

    private String email

    private String firstName

    private String lastName

    private String avatarImage

    private List<String> roles

    private UserDetails userDetails

    UserEntity() {
        super.setId(UUID.randomUUID())

        super.setDateCreated(Date.from(Instant.now()))
        super.setDateModified(Date.from(Instant.now()))
        super.setDateLastAccess(Date.from(Instant.now()))
    }

    Logger getLOGGER() {
        return LOGGER
    }

    Long getUserIndex() {
        return userIndex
    }

    void setUserIndex(Long userIndex) {
        this.userIndex = userIndex
    }

    String getUserName() {
        return userName
    }

    void setUserName(String userName) {
        this.userName = userName
    }

    String getPassword() {
        return password
    }

    void setPassword(String password) {
        this.password = password
    }

    String getEmail() {
        return email
    }

    void setEmail(String email) {
        this.email = email
    }

    String getFirstName() {
        return firstName
    }

    void setFirstName(String firstName) {
        this.firstName = firstName
    }

    String getLastName() {
        return lastName
    }

    void setLastName(String lastName) {
        this.lastName = lastName
    }

    String getAvatarImage() {
        return avatarImage
    }

    void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage
    }

    List<String> getRoles() {
        return roles
    }

    void setRoles(List<String> roles) {
        this.roles = roles
    }

    UserDetails getUserDetails() {
        return userDetails
    }

    void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails
    }

    @Override
    String toString() {
        return """\
    UserEntity -> {
        userIndex=$userIndex,
        userName='$userName',
        password='$password',
        email='$email',
        firstName='$firstName',
        lastName='$lastName',
        avatarImage='$avatarImage',
        roles=$roles,
        userDetails=$userDetails,
        super=${super.toString()}
    }"""
    }
}
