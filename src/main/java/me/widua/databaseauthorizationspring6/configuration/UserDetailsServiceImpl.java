package me.widua.databaseauthorizationspring6.configuration;

import me.widua.databaseauthorizationspring6.repository.MongoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MongoUserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(MongoUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getUserModelByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
