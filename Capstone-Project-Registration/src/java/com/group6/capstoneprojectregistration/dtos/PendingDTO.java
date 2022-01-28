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
public class PendingDTO {

    private int id;
    private UserStatusDTO status;
    private UserDTO user;
    private GroupDTO group;

    public PendingDTO() {
    }

    public PendingDTO(int id, UserStatusDTO status, UserDTO user, GroupDTO group) {
        this.id = id;
        this.status = status;
        this.user = user;
        this.group = group;
    }
}
