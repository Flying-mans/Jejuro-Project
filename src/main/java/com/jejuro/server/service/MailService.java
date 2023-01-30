package com.jejuro.server.service;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.jejuro.server.dao.MemberDao;
import com.jejuro.server.entity.Member;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;
    
	@Autowired
	private MemberDao dao;

    // 임시 비밀번호 메일 보내기
    public void sendMail(String email, String nickname) throws MessagingException, UnsupportedEncodingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        // 메일 제목 설정
        helper.setSubject("[JEJURO] 임시 비밀번호가 도착했어요");
        // 메일 발신자 설정
        helper.setFrom("Info@Jejuro.com", "Jejuro");

        String password = UUID
                .randomUUID()
                .toString()
                .substring(0, 8);
        Context context = new Context();
        context.setVariable("name", nickname);
        context.setVariable("password", password);

        // 메일 내용 설정 : html페이지와 context객체 렌더링 작업
        String html = templateEngine.process("/html/reset-pwd/mail.html", context);

        helper.setText(html, true);
        helper.setTo(email);

        // 메일 보내기
        javaMailSender.send(message);

        Member member = dao.getByEmail(email);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		member.setPassword(passwordEncoder.encode(password));
		// member.setPassword((password));

		dao.update(member);
    }

}
