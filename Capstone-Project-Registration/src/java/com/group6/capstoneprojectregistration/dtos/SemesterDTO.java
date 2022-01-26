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
public class SemesterDTO {
    
    private int semesterId;
    private String name;

    public SemesterDTO() {
    }

    public SemesterDTO(int semesterId, String name) {
        this.semesterId = semesterId;
        this.name = name;
    }
   
}
