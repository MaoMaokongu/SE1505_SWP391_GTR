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
@Setter
@Getter
public class UserStatusDTO {
    
    private int statusId;
    private String Name;

    public UserStatusDTO() {
    }

    public UserStatusDTO(int statusId, String Name) {
        this.statusId = statusId;
        this.Name = Name;
    }
}