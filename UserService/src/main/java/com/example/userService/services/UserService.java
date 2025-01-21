package com.example.userService.services;

import com.example.userService.entities.User;
import com.example.userService.feign.UserDonFeignClient;
import com.example.userService.models.UserDonDTO;
import com.example.userService.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDonFeignClient userDonFeignClient;

    public UserService(UserRepository userRepository, UserDonFeignClient userDonFeignClient) {
        this.userRepository = userRepository;
        this.userDonFeignClient = userDonFeignClient;
    }

    public User getUserWithDonations(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<UserDonDTO> userDonDTOS = userDonFeignClient.getUserDonsByUserId(userId);

        user.setUserDonDTOS(userDonDTOS);
        System.out.println("Done");
        return user;
    }

    public List<User> getAllUsers(){
        List<User> usersList = userRepository.findAll();
        usersList.forEach(user -> {
            user.setUserDonDTOS(userDonFeignClient.getUserDonsByUserId(user.getId()));
        });
        System.out.println(usersList);

        return usersList;
    }
    public User getUserById(Long id){
        User user = userRepository.findById(id).get();
        user.setUserDonDTOS(userDonFeignClient.getUserDonsByUserId(user.getId()));
        System.out.println(user);

        return user;
    }

    public User createUser(User user) {
        userRepository.save(user);
        System.out.println("Done");
        return user;
    }

}
