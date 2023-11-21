package com.example.demoargela.Controller;

import com.example.demoargela.Models.Role;
import com.example.demoargela.Models.SaveRoleRequest;
import com.example.demoargela.Services.ServiceImpl.RoleServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("roles")
public class RoleController {

    @Autowired
    RoleServiceImpl roleService;

    @GetMapping("/all")
    public ResponseEntity<List<Role>> ListAllRoles(){
        List<Role> roles = roleService.FindAll();
        if (roles.size()>0)
            return ResponseEntity.ok().body(roles);
        else return ResponseEntity.ok(Collections.emptyList());

    }

    @Transactional
    @DeleteMapping("")
    public ResponseEntity DeleteById(@RequestParam("id") Long id){
        try {
            roleService.DeleteRoleRelation(id);
            roleService.DeleteRoleById(id);
            return ResponseEntity.ok().body("Role deleted");
        }catch (Exception e)
        {
            return ResponseEntity.internalServerError().body(e.getMessage());

        }
    }

    @PostMapping(value = "")
    public ResponseEntity SaveRole(@RequestBody SaveRoleRequest request)
    {
        Role role = new Role(request.getRole());
        try
        {
            return ResponseEntity.ok().body(roleService.SaveRole(role));
        }catch (Exception e )
        {
            return ResponseEntity.ok().body("Already Created");
        }

    }
}
