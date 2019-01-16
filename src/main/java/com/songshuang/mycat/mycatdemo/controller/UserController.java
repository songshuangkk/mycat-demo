package com.songshuang.mycat.mycatdemo.controller;

import com.songshuang.mycat.mycatdemo.controller.ao.UserAo;
import com.songshuang.mycat.mycatdemo.dao.entity.User;
import com.songshuang.mycat.mycatdemo.manager.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/user/{userId}")
  public Object getUser(@PathVariable("userId") Long userId) {
    return userService.getUserBy(userId).orElseThrow(() -> new RuntimeException("No User"));
  }

  @PostMapping("/user")
  @ResponseStatus(HttpStatus.CREATED)
  public Object createUser(@RequestBody UserAo userAo) {
    User user = new User();
    BeanUtils.copyProperties(userAo, user);
    return userService.createUser(user).orElseThrow(() -> new RuntimeException("Create Exception"));
  }
}
