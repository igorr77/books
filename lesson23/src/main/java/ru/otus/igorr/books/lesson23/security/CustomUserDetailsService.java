package ru.otus.igorr.books.lesson23.security;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.otus.igorr.books.lesson23.domain.security.User;
import ru.otus.igorr.books.lesson23.service.security.UserService;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService service;

    @Autowired
    public CustomUserDetailsService(UserService service) {
        super();
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = service.getUser(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        LOG.debug("****: " + user.getUsername() + " " + user.getRole() + " " + user.getPassword());

        return new CustomUserPrincipal(user);
    }
}
