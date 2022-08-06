package com.sydx.oauth2.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 登录用户信息
 * Created by macro on 2020/6/19.
 */
@Data
public class SecurityUser implements UserDetails {

    /**
     * ID
     */
    private Integer user_Id;

    private String User_Account;
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    private String realname;
    private String unitid;
    private String dataSource;
    private String oilfield;
    private String unitname;
    /**
     * 用户状态
     */
    private Boolean enabled;
    /**
     * 权限数据
     */
    private Collection<SimpleGrantedAuthority> authorities;

    public SecurityUser() {

    }

    public SecurityUser(UserDTO userDTO) {
        this.setUser_Id(userDTO.getUser_Id());
        this.setUser_Account(userDTO.getUser_Account());
        this.setOilfield(userDTO.getOilfield());
        this.setDataSource(userDTO.getDataSource());
        this.setUnitid(userDTO.getUnit_id());
        this.setUnitname(userDTO.getUnit_name());
        this.setRealname(userDTO.getTrue_name());
        this.setId(userDTO.getId());
        this.setUsername(userDTO.getUser_name());
        this.setPassword(userDTO.getPassword());
        this.setEnabled(userDTO.getStatus() == 1);
        if (userDTO.getRoles() != null) {
            authorities = new ArrayList<>();
            userDTO.getRoles().forEach(item -> authorities.add(new SimpleGrantedAuthority(item)));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public Integer getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Integer user_Id) {
        this.user_Id = user_Id;
    }
}
