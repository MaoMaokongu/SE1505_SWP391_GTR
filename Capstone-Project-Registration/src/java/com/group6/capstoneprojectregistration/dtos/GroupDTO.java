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
public class GroupDTO {
    
    private int groupId;
    private String name;
    private boolean isApproved;
    private String projectId;

    public GroupDTO(int groupId, String name, boolean isApproved, String projectId) {
        this.groupId = groupId;
        this.name = name;
        this.isApproved = isApproved;
        this.projectId = projectId;
    }

    public GroupDTO(int groupId, String name) {
        this.groupId = groupId;
        this.name = name;
    }
    
    
}
