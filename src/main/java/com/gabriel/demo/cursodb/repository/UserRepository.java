package com.gabriel.demo.cursodb.repository;

import com.gabriel.demo.cursodb.worshopmongodb.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository <User, UUID> {

}
