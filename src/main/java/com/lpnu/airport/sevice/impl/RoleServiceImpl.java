package com.lpnu.airport.sevice.impl;

import com.lpnu.airport.sevice.RoleService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Override
    @Cacheable("roles")
    public String getRole() {
        System.out.println("inside RoleServiceImpl -> getRole");
        return "admin";
    }
}
