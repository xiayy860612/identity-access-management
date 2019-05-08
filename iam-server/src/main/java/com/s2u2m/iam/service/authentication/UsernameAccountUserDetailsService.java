package com.s2u2m.iam.service.authentication;

import com.s2u2m.iam.domain.account.UsernameAccount;
import com.s2u2m.iam.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsernameAccountUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UsernameAccount account = accountRepository.getUsernameAccount(s);
        return new UsernameAccountUserDetails(account);
    }
}
