package com.wai.service;

import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component("userDetailsService")
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    final private UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findOneWithAuthoritiesByUsername(username).orElseThrow(() -> new UsernameNotFoundException("데이터베이스에서 찾을 수 없습니다."));
        return createUser(username, user);
    }

    private org.springframework.security.core.userdetails.User createUser(String username, User user) {
//        if (!user.getIsActivated()) {
//            throw new RuntimeException(username + " -> 활성화되어 있지 않습니다.");
//        }
        List<GrantedAuthority> grantedAuthorities = user.getUserRoles().stream()
                .map(userRole -> new SimpleGrantedAuthority(userRole.getRole().name()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                grantedAuthorities
        );
    }
}