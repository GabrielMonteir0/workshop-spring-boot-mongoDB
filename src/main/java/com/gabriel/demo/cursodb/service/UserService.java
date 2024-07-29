package com.gabriel.demo.cursodb.service;

import com.gabriel.demo.cursodb.dto.UserDto;
import com.gabriel.demo.cursodb.service.execption.ObjectNotFoundExecption;
import com.gabriel.demo.cursodb.worshopmongodb.User;
import com.gabriel.demo.cursodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(UUID id) {
        Optional<User> user = repo.findById(id);
        if (user.isEmpty()) {
            throw new ObjectNotFoundExecption("Object not found");
        }

        return user.get();
    }
    public User insert(User obj) {
        return repo.save(obj);
    }

    public void delete(UUID id) {
        repo.delete(findById(id));
    }
    public User update(User obj){
        User newObj = repo.findById(obj.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }


    public User fromDTO(UserDto objDto) {
        return new User(objDto.getName(), objDto.getEmail());
    }

}
