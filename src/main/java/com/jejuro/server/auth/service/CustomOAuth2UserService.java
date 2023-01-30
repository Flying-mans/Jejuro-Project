package com.jejuro.server.auth.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.jejuro.server.auth.entity.PrincipalDetails;
import com.jejuro.server.auth.service.provider.GoogleUserInfo;
import com.jejuro.server.auth.service.provider.KakaoUserInfo;
import com.jejuro.server.auth.service.provider.NaverUserInfo;
import com.jejuro.server.auth.service.provider.OAuth2UserInfo;
import com.jejuro.server.dao.MemberDao;
import com.jejuro.server.entity.Member;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

	@Autowired
	private MemberDao memberDao;

	// userRequest는 code를 받아서 accessToken을 응답 받은 객체
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) {
		System.out.println();
		// code를 통해 구성한 정보
		System.out.println("userRequest clientRegistration : " + userRequest.getClientRegistration());
		// token을 통해 응답받은 회원정보
		System.out.println("getAccessToken:" + userRequest.getAccessToken().getTokenValue());

		OAuth2User oAuth2User = super.loadUser(userRequest);

		// 소셜 회원 프로필 조회
		System.out.println();
		System.out.println("oAuth2User : " + oAuth2User);
		System.out.println();
		System.out.println("getAttributes : " + oAuth2User.getAttributes());
		System.out.println();

		return processOAuth2User(userRequest, oAuth2User);
	}

	private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {

		// Attribute를 파싱해서 공통 객체로 묶는다. 관리가 편함.
		OAuth2UserInfo oAuth2UserInfo = null;

		if (userRequest.getClientRegistration().getRegistrationId().equals("google")) {

			System.out.println("구글 로그인 요청~~");
			oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());

		} else if (userRequest.getClientRegistration().getRegistrationId().equals("kakao")) {

			System.out.println("카카오 로그인 요청~~");
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("id", oAuth2User.getAttributes().get("id"));

			Map<String, Object> properties = (Map<String, Object>) oAuth2User.getAttributes().get("properties");
			attributes.putAll(properties);

			Map<String, Object> kakaoAccount = (Map<String, Object>) oAuth2User.getAttributes().get("kakao_account");
			Map<String, Object> email = new HashMap<>();
			email.put("email", kakaoAccount.get("email"));

			attributes.putAll(email);

			oAuth2UserInfo = new KakaoUserInfo(attributes);

		} else if (userRequest.getClientRegistration().getRegistrationId().equals("naver")) {

			System.out.println("네이버 로그인 요청~~");
			oAuth2UserInfo = new NaverUserInfo((Map) oAuth2User.getAttributes().get("response"));

		} else {
			System.out.println("소셜 로그인 오류");
		}

		Optional<Member> memberOptional = memberDao.findByProviderId(oAuth2UserInfo.getProviderId());

		Member member;
		if (memberOptional.isPresent()) {
			member = memberOptional.get();
			// user가 존재하면 update 해주기
			member.setEmail(oAuth2UserInfo.getEmail());
			memberDao.update(member);
		} else {
			// user의 패스워드가 null이기 때문에 OAuth 유저는 일반적인 로그인을 할 수 없음. 대신 UUID를 이용해 넣어줌
			member = Member.builder()
					.nickName(oAuth2UserInfo.getProvider() + "_" + oAuth2UserInfo.getProviderId().substring(0, 5))
					.email(oAuth2UserInfo.getEmail())
					.role("ROLE_USER")
					.provider(oAuth2UserInfo.getProvider())
					.providerId(oAuth2UserInfo.getProviderId())
					.password(uuidPwd())
					.isPresent(true)
					.build();
			memberDao.signUp(member);
		}
		return new PrincipalDetails(member, oAuth2User.getAttributes());
	}

	public String uuidPwd() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String pwd = passwordEncoder.encode(
				UUID
						.randomUUID()
						.toString()
						.replace("-", "")
						.substring(0, 10)
						.toUpperCase());
		return pwd;
	}
}
