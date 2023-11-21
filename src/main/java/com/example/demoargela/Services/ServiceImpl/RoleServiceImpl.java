package com.example.demoargela.Services.ServiceImpl;

import com.example.demoargela.Models.Role;
import com.example.demoargela.Repositories.RoleRepository;
import com.example.demoargela.Services.IRoleService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void DeleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role SaveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> FindAll() {
        return  roleRepository.findAll();
    }

    @Override
    public HashSet<Role> FindAllByIds(HashSet<Long> lists) {
        HashSet<Role> roles = new HashSet<>();
        roleRepository.findAllById(lists).forEach(value -> roles.add(value));
        return roles;
    }

    @Override
    public Role FindById(Long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public void DeleteRoleRelation(Long id) {
        roleRepository.DeleteRelation(id);
    }

}
