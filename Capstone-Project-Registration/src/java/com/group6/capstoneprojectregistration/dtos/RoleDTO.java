/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.capstoneprojectregistration.dtos;

import lombok.Data;

/**
 *
 * @author admin
 */
@Data
public class RoleDTO {
    
    private int roleId;
    private String Name;

    public RoleDTO() {
    }

    public RoleDTO(int roleId, String Name) {
        this.roleId = roleId;
        this.Name = Name;
    }
}
