package com.example.demoargela.Services.ServiceImpl;

import com.example.demoargela.Models.User;
import com.example.demoargela.Repositories.UserRepository;
import com.example.demoargela.Services.IUserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User SaveUser(User user){
        return  userRepository.save(user);

    }
    @Override
    public List<User> ListUsers(){
        return  userRepository.findAll();
    }
    @Override
    public void DeleteUserById(Long id){
        userRepository.deleteById(id);
    }
    public Optional<User> FindById(Long id){
        return userRepository.findById(id);
    }

    @Override
    public Optional<List<User>> findAllByDobBetween(Date start, Date end) {
        return  userRepository.findAllByDobBetween(start,end);
    }

}
