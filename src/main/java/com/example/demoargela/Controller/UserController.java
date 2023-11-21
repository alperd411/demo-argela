package com.example.demoargela.Controller;

import com.example.demoargela.Models.Role;
import com.example.demoargela.Models.SaveUserRequest;
import com.example.demoargela.Models.User;
import com.example.demoargela.Repositories.RoleRepository;
import com.example.demoargela.Services.ServiceImpl.RoleServiceImpl;
import com.example.demoargela.Services.ServiceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController()
@RequestMapping("users")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    RoleServiceImpl roleService;
    private final DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");


    @GetMapping("/all")
    public List<User> deneme(){
        return userService.ListUsers();
    }

    @PostMapping("")
    public ResponseEntity SaveUser(@RequestBody SaveUserRequest request) {
        HashSet<Long> roleIds = request.getRoleIds();
        HashSet<Role> rolesToAdd = roleService.FindAllByIds(roleIds);


        User user = new User(request.getName(), request.getSurname(), request.getEmailAddr(), rolesToAdd,request.getDateOfBirt());
        try {
           return ResponseEntity.ok(userService.SaveUser(user));

        } catch (Exception e) {

            return  ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @PostMapping("/role/{id}")
    public ResponseEntity AddRole(@RequestParam Long userId,@RequestBody HashSet<Long> roleIds){

        User user = new User();
        try
        {
            Optional<User> suser = userService.FindById(userId);
            if(suser.isPresent()){
                user = suser.get();
            }
        }catch (Exception e ){

            return ResponseEntity.badRequest().body("missing parameters");

        }

        user.getRoles().addAll(roleService.FindAllByIds(roleIds));
        return  ResponseEntity.ok(user);
    }

    @GetMapping("/searchByDob")
    public ResponseEntity FindUsersBetweenDob(@RequestParam("startDate") String start,@RequestParam("endDate") String end){
        try
        {
            Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(start);
            Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(end);
            Optional<List<User>> list = userService.findAllByDobBetween(startDate,endDate);
            if (list.isPresent()){
                return ResponseEntity.ok().body(list.get());
            }

            else return ResponseEntity.ok().body(Collections.emptyList());
        }catch (Exception e){

            return  ResponseEntity.badRequest().body(e.getMessage());
        }


    }
    @DeleteMapping("")
    public ResponseEntity DeleteUserById(@RequestParam("id") Long id){

        userService.DeleteUserById(id);
        return ResponseEntity.ok().body("user deleted");

    }

}
