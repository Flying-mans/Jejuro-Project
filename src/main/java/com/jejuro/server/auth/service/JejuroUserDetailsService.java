package com.jejuro.server.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jejuro.server.auth.entity.PrincipalDetails;
import com.jejuro.server.dao.MemberDao;
import com.jejuro.server.entity.Member;

@Service
public class JejuroUserDetailsService implements UserDetailsService{

    @Autowired
    private MemberDao memberDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Member member = memberDao.getByEmail(email);

        if(member.isPresent()) {
            return new PrincipalDetails(member);
        }
        
        return null;
    }

}
