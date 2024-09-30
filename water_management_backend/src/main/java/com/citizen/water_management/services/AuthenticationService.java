package com.citizen.water_management.services;

import com.citizen.water_management.config.jwt.JwtProvider;
import com.citizen.water_management.entity.account.Account;
import com.citizen.water_management.entity.account.Role;
import com.citizen.water_management.repository.account.AccountRepository;
import com.citizen.water_management.repository.account.RoleRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public AuthenticationService(AccountRepository accountRepository,
                                 RoleRepository roleRepository,
                                 @Lazy AuthenticationManager authenticationManager,
                                 PasswordEncoder passwordEncoder,
                                 JwtProvider jwtProvider) {
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Account not found with email : " + username));
    }

    public boolean login(String username, String password) {
        return accountRepository.findByEmail(username).map(u -> passwordEncoder.matches(password, u.getPassword()))
                .orElseThrow(() -> new BadCredentialsException("Invalid username or password"));
    }

    public Account registerAccount(Account account, Role role) {
        try{
            account.setPassword(passwordEncoder.encode(account.getPassword()));
            account.setRole(roleRepository.findByAuthority(role.getAuthority()).orElse(role));
            return accountRepository.save(account);
        } catch (Exception e) {
            e.fillInStackTrace();
            throw new BadCredentialsException("Invalid email or password");
        }
    }

    public String generateToken(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtProvider.generateToken(authentication);
    }

}
