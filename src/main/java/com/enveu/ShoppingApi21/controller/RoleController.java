package com.enveu.ShoppingApi21.controller;

import com.enveu.ShoppingApi21.entity.Role;
import com.enveu.ShoppingApi21.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    public Role createNewRole(Role role)
    {
       return roleService.createRole(role);
    }

    @GetMapping("/findRoll/{id}")
    public Optional<Role> findByname(@PathVariable("id") String name)
    {
        return roleService.roleList(name);
    }
}
