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
public class ProjectDTO {
    
    private String projectId;
    private String name;
    private String mentor;
    private String coMentor;
    private int numOfStus;
    private boolean isSelected;
    private String discription;
    private SemesterDTO semester;

    public ProjectDTO() {
    }

    public ProjectDTO(String projectId, String name, String mentor, String coMentor, int numOfStus, boolean isSelected, String discription, SemesterDTO semester) {
        this.projectId = projectId;
        this.name = name;
        this.mentor = mentor;
        this.coMentor = coMentor;
        this.numOfStus = numOfStus;
        this.isSelected = isSelected;
        this.discription = discription;
        this.semester = semester;
    }
    
    
    
}
