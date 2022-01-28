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
public class MessageEventDTO {
    
    private String messageEvent;
    private String messageContent;

    public MessageEventDTO() {
    }

    public MessageEventDTO(String messageContent) {
        this.messageContent = messageContent;
    }
    
}
