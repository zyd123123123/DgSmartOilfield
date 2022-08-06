package com.sydx.oauth2.service;

import com.sydx.oauth2.dao.UserDao;
import com.sydx.oauth2.domain.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sydx.oauth2.entity.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 随带写Bug的程序猿
 *
 * @auther xuyaohui
 * @date 2018/8/29
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    public User getUserByAccount(String userAccount){
        User user_pre=new User();
        user_pre.setUserAccount(userAccount);

        List<User> user=userDao.getUserByName("getUserByName",user_pre);
        //必须传入对象

        if (user!=null){
           List<String> permissions = userDao.getUserPermissions("getUserPermissions",user.get(0));
            Set<String> permset=new HashSet<>();
            for(int i=0;i<permissions.size();i++){
                permset.add(permissions.get(i));
            }
           user.get(0).setPermission( permset);
            //获取菜单

            List<String> s=  userDao.getMenuListByName("getMenuListByName",user.get(0));
            Set<String> permset2=new HashSet<>();
            for(int i=0;i<s.size();i++){
                permset2.add(s.get(i));
            }
            user.get(0).setMenuList(permset2);
        }
        return user.get(0);
    }

}
