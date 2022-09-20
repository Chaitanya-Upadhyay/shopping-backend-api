package com.enveu.ShoppingApi21.entity;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @Column(nullable = false,length = 5)
    private String rollName;

//    @Id
//    @GeneratedValue
//    private Long id;
//    private String roleName;


    private String roleDescription;

//    public String getRollName() {
//        return rollName;
//    }
//
//    public void setRollName(String rollName) {
//        this.rollName = rollName;
//    }

//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

//    public String getRoleName() {
//        return roleName;
//    }
//
//    public void setRoleName(String roleName) {
//        this.roleName = roleName;
//    }


    public String getRollName() {
        return rollName;
    }

    public void setRollName(String rollName) {
        this.rollName = rollName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
