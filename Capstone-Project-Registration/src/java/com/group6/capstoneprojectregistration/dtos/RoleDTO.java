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
public class RoleDTO {
    
    private int roleId;
    private String Name;

    public RoleDTO() {
    }

    public RoleDTO(int roleId, String Name) {
        this.roleId = roleId;
        this.Name = Name;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }


    
}
