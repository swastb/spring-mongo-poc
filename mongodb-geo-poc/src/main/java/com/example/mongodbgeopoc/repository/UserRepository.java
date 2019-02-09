package com.example.mongodbgeopoc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongodbgeopoc.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}