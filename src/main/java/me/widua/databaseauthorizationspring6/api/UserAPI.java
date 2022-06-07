package me.widua.databaseauthorizationspring6.api;

import me.widua.databaseauthorizationspring6.manager.UserManager;
import me.widua.databaseauthorizationspring6.model.ResponseEntityBody;
import me.widua.databaseauthorizationspring6.model.UserRegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserAPI {

    private final UserManager userManager;

    @Autowired
    public UserAPI(UserManager userManager) {
        this.userManager = userManager;
    }

    @PostMapping("/add")
    @PreAuthorize("permitAll()")
    public ResponseEntity<ResponseEntityBody> add(@RequestBody UserRegisterModel user) {
        return userManager.createUser(user);
    }

}
