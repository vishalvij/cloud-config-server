package com.vishal.userservice.controller;

import com.vishal.userservice.VO.ResponseTemplateVO;
import com.vishal.userservice.entity.User;
import com.vishal.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser in User Controller");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside getUserWithDepartment in UserController");
        return userService.getUserWithDepartment(userId);
    }

}
