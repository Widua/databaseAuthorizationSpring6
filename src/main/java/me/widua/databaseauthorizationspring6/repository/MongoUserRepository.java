package me.widua.databaseauthorizationspring6.repository;

import me.widua.databaseauthorizationspring6.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MongoUserRepository extends MongoRepository<UserModel, String> {
    Optional<UserModel> getUserModelByUsername(String username);
}
