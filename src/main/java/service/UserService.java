package service;

import java.util.List;


import pojo.User;

public interface UserService {
     List<User>  getAll(Integer from,Integer size);
     User getInfo(Integer id);
     int  add(User user);
     int  update (User user);
     int  del(Integer id);
     int  getUserCount();
}
