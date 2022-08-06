package com.sydx.oauth2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Created by macro on 2020/6/19.
 */
@Data
@EqualsAndHashCode(callSuper = false)
//@AllArgsConstructor
public class UserDTO{
    private Integer user_Id;

    private String user_Roles;
    private String user_RoleNames;
    private String user_Account;


    private Long id;
    private String user_name;
    private String password;
    private String user_password;
    private Integer status;
    private List<String> roles;
    private String oilfield;
    private String unit_id;
    private String true_name;
    private String unit_name;
    private String dataSource;


}
