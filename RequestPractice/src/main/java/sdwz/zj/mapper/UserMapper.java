package sdwz.zj.mapper;

import sdwz.zj.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectLogin(User user);
}
