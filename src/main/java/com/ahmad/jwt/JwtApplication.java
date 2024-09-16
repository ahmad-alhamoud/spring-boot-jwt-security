package com.ahmad.jwt;

import com.ahmad.jwt.role.Role;
import com.ahmad.jwt.role.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class JwtApplication {


    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(RoleRepository roleRepository){
      return arg -> {
         if (roleRepository.findRoleByName("USER").isEmpty()){
             roleRepository.save(
                     Role.builder().name("USER").build()
             );
         }
      };
    }
}
