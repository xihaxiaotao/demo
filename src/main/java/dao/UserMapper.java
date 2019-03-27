package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.User;

public interface UserMapper {
     List<User>  getAll(@Param("from")Integer from,@Param("size")Integer size);
     User getInfo(Integer id);
     int  add(User user);
     int  update (User user);
     int  del(Integer id);
     int  getUserCount();
}
