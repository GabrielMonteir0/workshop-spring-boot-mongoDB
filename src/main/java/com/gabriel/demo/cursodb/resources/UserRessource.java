package com.gabriel.demo.cursodb.resources;

import com.gabriel.demo.cursodb.worshopmongodb.User;
import com.gabriel.demo.cursodb.dto.UserDto;
import com.gabriel.demo.cursodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class UserRessource {

    @Autowired
    private UserService service;

   @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {

        List<User> list = service.findAll();
       return ResponseEntity.ok().body(list);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> findById(@PathVariable UUID id) {
        User obj = service.findById(id);

        return ResponseEntity.ok().body(new UserDto(obj));
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity insert(@RequestBody UserDto objDto) {
        User obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }
   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable UUID id){
    service.delete(id);
    return ResponseEntity.noContent().build();
   }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody UserDto objDto, @PathVariable UUID id ) {
       User obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

}
