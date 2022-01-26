/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.capstoneprojectregistration.dtos;


import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author admin
 */
@Getter
@Setter
public class UserDTO {

    private String userId;
    private String email;
    private String userName;
    private String gender;
    private RoleDTO role;
    private GroupDTO group;
    private boolean isLeader;

    public UserDTO() {
    }

    public UserDTO(String userId, String email, String userName, String gender, RoleDTO role, GroupDTO group, boolean isLeader) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
        this.gender = gender;
        this.role = role;
        this.group = group;
        this.isLeader = isLeader;
    }

  
}
