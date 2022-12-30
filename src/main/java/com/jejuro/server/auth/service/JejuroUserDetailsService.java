package com.jejuro.server.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jejuro.server.auth.entity.JejuroUserDetails;
import com.jejuro.server.dao.MemberDao;
import com.jejuro.server.entity.Member;

public class JejuroUserDetailsService implements UserDetailsService{

    @Autowired
    private MemberDao memberDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Member member = memberDao.getByEmail(email);

        JejuroUserDetails user = new JejuroUserDetails();
        user.setEmail(member.getEmail());
        user.setPassword(member.getPassword());
        user.setNickName(member.getNickName());
        return user;
    }

}
