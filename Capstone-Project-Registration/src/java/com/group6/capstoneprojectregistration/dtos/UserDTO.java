/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.capstoneprojectregistration.dtos;

/**
 *
 * @author admin
 */
public class UserDTO {

    private String user_id;
    private String email;
    private String username;
    private String gender;
    private RoleDTO role;
    private boolean IsLeader;
    private boolean HasGroup;
    
    public UserDTO() {
    }

    public UserDTO(String user_id, String email, String username, String gender, RoleDTO role, boolean IsLeader, boolean HasGroup) {
        this.user_id = user_id;
        this.email = email;
        this.username = username;
        this.gender = gender;
        this.role = role;
        this.IsLeader = IsLeader;
        this.HasGroup = HasGroup;
    }

    public boolean isIsLeader() {
        return IsLeader;
    }

    public void setIsLeader(boolean IsLeader) {
        this.IsLeader = IsLeader;
    }

    public boolean isHasGroup() {
        return HasGroup;
    }

    public void setHasGroup(boolean HasGroup) {
        this.HasGroup = HasGroup;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole_id(RoleDTO role) {
        this.role = role;
    }

    
}
