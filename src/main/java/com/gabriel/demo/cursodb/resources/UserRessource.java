package com.gabriel.demo.cursodb.resources;

import com.gabriel.demo.cursodb.worshopmongodb.User;
import com.gabriel.demo.cursodb.dto.UserDto;
import com.gabriel.demo.cursodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserRessource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {

        List<User> list = service.findAll();
       return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id) {
        User obj = service.findById(id);

        return ResponseEntity.ok().body(new UserDto(obj));
    }
    @PostMapping
    public ResponseEntity insert(@RequestBody UserDto objDto) {
        User obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable String id){
    service.delete(id);
    return ResponseEntity.noContent().build();
   }
    @PutMapping(value = "/{id}")
    public ResponseEntity update(@RequestBody UserDto objDto, @PathVariable String id ) {
       User obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }
}
