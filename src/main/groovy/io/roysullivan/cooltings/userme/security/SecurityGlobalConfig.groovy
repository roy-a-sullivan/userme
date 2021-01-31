package io.roysullivan.cooltings.userme.security


import io.roysullivan.cooltings.userme.entities.user.UserEntity
import io.roysullivan.cooltings.userme.services.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
class SecurityGlobalConfig {
    @Autowired
    private UserService userService

    private static Logger LOGGER =
            LoggerFactory.getLogger(this.getClass())

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder()
    }

    @Bean
    SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .authorizeExchange()
                .pathMatchers("/admin/dashboard")
                    .hasAnyAuthority("ROLE_SUPER", "ROLE_ADMIN")
                .pathMatchers("/**").permitAll()
                    .anyExchange()
                        .authenticated()
                        .and()
                            .formLogin()
                        .and()
                            .build()
    }

    @Bean
    MapReactiveUserDetailsService userDetailsService() {

        List<UserEntity> userModelList = new ArrayList<>()
        UserEntity userModel1 = new UserEntity()
        UserEntity userModel2 = new UserEntity()
        UserEntity userModel3 = new UserEntity()
        UserEntity userModel4 = new UserEntity()

        UserDetails superAdminUser =
                User.builder()
                        .username("userMe_super")
                        .password(
                                passwordEncoder().encode("userMe_super_password"))
                        .roles("SUPER")
                            .build()

        UserDetails adminUser =
                User.builder()
                        .username("userMe_admin")
                        .password(
                                passwordEncoder().encode("userMe_admin_password"))
                        .roles("ADMIN")
                            .build()

        UserDetails baseUser =
                User.builder()
                        .username("userMe_user")
                        .password(
                                passwordEncoder().encode("userMe_user_password"))
                        .roles("USER")
                            .build()

        UserDetails visitorUser =
                User.builder()
                    .username("visitor")
                    .password(
                            passwordEncoder().encode("visitor_password"))
                    .roles("VISITOR")
                        .build()

        userModel1.setUserDetails(superAdminUser)
        userModel1.setUserName(superAdminUser.getUsername())
        userModel1.setPassword(superAdminUser.getPassword())
        userModel1.setRoles(superAdminUser.getAuthorities() as List<String>)
        userModel1.setUserName(superAdminUser.getUsername())
        userModelList.add(userModel1)

        userModel2.setUserDetails(adminUser)
        userModel2.setUserName(adminUser.getUsername())
        userModel2.setPassword(adminUser.getPassword())
        userModel2.setRoles(adminUser.getAuthorities() as List<String>)
        userModel2.setUserName(adminUser.getUsername())
        userModelList.add(userModel2)

        userModel3.setUserDetails(baseUser)
        userModel3.setUserName(baseUser.getUsername())
        userModel3.setPassword(baseUser.getPassword())
        userModel3.setRoles(baseUser.getAuthorities() as List<String>)
        userModel3.setUserName(baseUser.getUsername())
        userModelList.add(userModel3)

        userModel4.setUserDetails(baseUser)
        userModel4.setUserName(baseUser.getUsername())
        userModel4.setPassword(baseUser.getPassword())
        userModel4.setRoles(baseUser.getAuthorities() as List<String>)
        userModel4.setUserName(baseUser.getUsername())
        userModelList.add(userModel4)

        LOGGER.info(userModelList.toString())

        return new MapReactiveUserDetailsService(
                        superAdminUser, adminUser, baseUser, visitorUser)
    }


}
