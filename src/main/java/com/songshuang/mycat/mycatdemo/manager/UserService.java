package com.songshuang.mycat.mycatdemo.manager;

import com.songshuang.mycat.mycatdemo.dao.entity.User;

import java.util.Optional;

public interface UserService {

  Optional<User> getUserBy(Long userId);

  Optional<Long> createUser(User user);
}
