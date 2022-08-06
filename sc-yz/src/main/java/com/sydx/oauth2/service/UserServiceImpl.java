package com.sydx.oauth2.service;
import cn.hutool.core.collection.CollUtil;
import com.sydx.oauth2.constant.MessageConstant;
import com.sydx.oauth2.dao.CommonDaoI;

import com.sydx.oauth2.domain.SecurityUser;
import com.sydx.oauth2.domain.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.sydx.oauth2.entity.User;

import java.util.List;
import java.util.Set;

/**
 * 用户管理业务类
 * Created by macro on 2020/6/19.
 */
@Service
public class UserServiceImpl implements UserDetailsService   {

    private List<UserDTO> userList;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CommonDaoI dao;

//    @PostConstruct
//    public void initData() {
//        System.out.println("[1]---");
//        String password = passwordEncoder.encode("123456");
//        userList = new ArrayList<>();
//        userList.add(new UserDTO(1L,"macro", password,1, CollUtil.toList("ADMIN")));
//        userList.add(new UserDTO(2L,"andy", password,1, CollUtil.toList("TEST")));
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("[4]---loadUserByUsername");
//        List<UserDTO> findUserList = userList.stream().filter(item -> item.getUsername().equals(username)).collect(Collectors.toList());
        UserDTO userDTO=new UserDTO();
        userDTO.setUser_name(username);
        List<UserDTO> findUserList = dao.find("loadUserByUsername",userDTO);
        if (CollUtil.isEmpty(findUserList)) {
            throw new UsernameNotFoundException(MessageConstant.USERNAME_PASSWORD_ERROR);
        }
        userDTO = findUserList.get(0);
        userDTO.setStatus(1);
        userDTO.setRoles(CollUtil.toList("ADMIN"));
        //数据库中的密码（需前端传递过来md5加密的密码）
          userDTO.setPassword(passwordEncoder.encode(userDTO.getUser_password().toLowerCase()));
        //因为系统中是没有密码验证的，前后端通用一个admin1234
        //userDTO.setPassword(passwordEncoder.encode("admin1234"));
        SecurityUser securityUser = new SecurityUser(userDTO);
        if (!securityUser.isEnabled()) {
            throw new DisabledException(MessageConstant.ACCOUNT_DISABLED);
        } else if (!securityUser.isAccountNonLocked()) {
            throw new LockedException(MessageConstant.ACCOUNT_LOCKED);
        } else if (!securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException(MessageConstant.ACCOUNT_EXPIRED);
        } else if (!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(MessageConstant.CREDENTIALS_EXPIRED);
        }
        return securityUser;
    }



}
