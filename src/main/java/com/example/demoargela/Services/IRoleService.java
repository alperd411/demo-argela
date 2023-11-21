package com.example.demoargela.Services;

import com.example.demoargela.Models.Role;

import java.util.HashSet;
import java.util.List;

public interface IRoleService {

    void DeleteRoleById(Long id);
    Role SaveRole(Role role);
    List<Role> FindAll();
    HashSet<Role> FindAllByIds(HashSet<Long> lists);
    Role FindById(Long id);
    void DeleteRoleRelation(Long id);


}
