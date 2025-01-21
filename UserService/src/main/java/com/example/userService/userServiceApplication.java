    package com.example.userService;

    import com.example.userService.config.GlobalConfig;
    import com.example.userService.entities.User;
    import com.example.userService.repositories.UserRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.CommandLineRunner;
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    import org.springframework.boot.context.properties.EnableConfigurationProperties;
    import org.springframework.cloud.openfeign.EnableFeignClients;
    import org.springframework.context.annotation.Bean;

    import java.util.List;


    @SpringBootApplication
    @EnableConfigurationProperties(GlobalConfig.class)
    @EnableFeignClients
    public class userServiceApplication{

        public static void main(String[] args) {
            SpringApplication.run(userServiceApplication.class, args);
        }
        @Autowired
        private UserRepository userRepository;

        @Bean
        CommandLineRunner createDefaultUsers() {
            return args -> {
                List<User> defaultUsers = List.of(
                        new User(1L, "John Doe", "john.doe@example.com", null),
                        new User(2L, "Jane Smith", "jane.smith@example.com", null),
                        new User(3L, "Alice Johnson", "alice.johnson@example.com", null)
                );

                for (User user : defaultUsers) {
                    userRepository.findById(user.getId()).ifPresentOrElse(
                            existingUser -> System.out.println("User already exists: " + existingUser),
                            () -> {
                                userRepository.save(user);
                                System.out.println("Created user: " + user);
                            }
                    );
                }
            };
        }

        }
