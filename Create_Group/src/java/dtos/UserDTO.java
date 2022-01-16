/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author admin
 */
public class UserDTO {

    private String user_id;
    private String email;
    private String username;
    private String gender;
    private RoleDTO role_id;
    private GroupDTO group_id;
    private boolean leader;

    public UserDTO() {
    }

    public UserDTO(String user_id, String email, String username, String gender, RoleDTO role_id) {
        this.user_id = user_id;
        this.email = email;
        this.username = username;
        this.gender = gender;
        this.role_id = role_id;
    }

    public UserDTO(String user_id, String email, String username, String gender, RoleDTO role_id, GroupDTO group_id) {
        this.user_id = user_id;
        this.email = email;
        this.username = username;
        this.gender = gender;
        this.role_id = role_id;
        this.group_id = group_id;
    }

    public UserDTO(String user_id, String email, String username, String gender, RoleDTO role_id, GroupDTO group_id, boolean leader) {
        this.user_id = user_id;
        this.email = email;
        this.username = username;
        this.gender = gender;
        this.role_id = role_id;
        this.group_id = group_id;
        this.leader = leader;
    }

    public boolean isLeader() {
        return leader;
    }

    public void setLeader(boolean leader) {
        this.leader = leader;
    }
    
    public GroupDTO getGroup_id() {
        return group_id;
    }

    public void setGroup_id(GroupDTO group_id) {
        this.group_id = group_id;
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

    public RoleDTO getRole_id() {
        return role_id;
    }

    public void setRole_id(RoleDTO role_id) {
        this.role_id = role_id;
    }

    
}
