package me.widua.databaseauthorizationspring6.manager;

import me.widua.databaseauthorizationspring6.model.ResponseEntityBody;
import me.widua.databaseauthorizationspring6.model.UserModel;
import me.widua.databaseauthorizationspring6.model.UserRegisterModel;
import me.widua.databaseauthorizationspring6.repository.MongoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static me.widua.databaseauthorizationspring6.roles.Roles.USER;

@Service
public class UserManager {

    private final MongoUserRepository userRepository;

    @Autowired
    public UserManager(MongoUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<UserModel> getUser(String username) {
        return ResponseEntity.ok(userRepository.getUserModelByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found")));
    }

    public ResponseEntity<ResponseEntityBody> createUser(UserRegisterModel user) {
        if (user.getPassword() == null || user.getUsername() == null) {
            return ResponseEntity.badRequest().build();
        }
        if ( user.getPassword().equals(user.getConfirmPassword())){
            UserModel toRegister = new UserModel(user.getUsername() , user.getPassword()  , USER.getAuthorities() , true);
            return ResponseEntity.ok( new ResponseEntityBody( "USER ADD SUCCESSFULLY" , HttpStatus.OK  ) );
        }
        return ResponseEntity.badRequest().build();
    }
}