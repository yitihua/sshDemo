package cn.edu.nenu.service;

import cn.edu.nenu.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User getUser(String username, String password){
        User user = new User();
        if(username.equals("admin")&&password.equals("admin")){
            user.setUsername(username);
            user.setPassword(password);
        }
        else{
            user = null;
        }
        return user;
    }
    public User setUser(Long id){
        return null;
    }
}
