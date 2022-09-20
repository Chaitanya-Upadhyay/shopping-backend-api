package com.enveu.ShoppingApi21.service;

import com.enveu.ShoppingApi21.entity.Role;
import com.enveu.ShoppingApi21.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Role createRole(Role role)
    {
        return roleRepository.save(role);
    }


//    public String findByRollName(String name)
//    {
//        return roleRepository.findById(name);
//    }
    public Optional<Role> roleList(String name)
    {
        return roleRepository.findById(name);
    }

}
