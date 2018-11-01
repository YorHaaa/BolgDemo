package Dao.UserDao;

import Entity.User;

public interface UserDao {
     int adduser(User user);
     int updateuser(User user);
     User getUserInfobyname(String username);
     Boolean isexit(String name);
}
