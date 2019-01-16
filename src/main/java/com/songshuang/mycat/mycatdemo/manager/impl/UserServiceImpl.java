package com.songshuang.mycat.mycatdemo.manager.impl;

import com.songshuang.mycat.mycatdemo.dao.entity.User;
import com.songshuang.mycat.mycatdemo.dao.repository.UserRepository;
import com.songshuang.mycat.mycatdemo.manager.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Optional<User> getUserBy(Long userId) {
    User user = userRepository.getUserByUserId(userId);
    if (user != null) {
      return Optional.of(user);
    }
    log.info("Get user is empty user id is {}", userId);
    return Optional.empty();
  }

  @Override
  public Optional<Long> createUser(User user) {
    try {
      Long userId = userRepository.creatUser(user);
      return Optional.of(userId);
    } catch (Exception e) {
      log.info("Create user has exception ", e);
      return Optional.empty();
    }
  }
}
