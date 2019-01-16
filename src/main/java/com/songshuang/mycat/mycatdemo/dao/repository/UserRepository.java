package com.songshuang.mycat.mycatdemo.dao.repository;

import com.songshuang.mycat.mycatdemo.dao.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

  User getUserByUserId(@Param("userId") Long userId);

  Long creatUser(User user);
}
