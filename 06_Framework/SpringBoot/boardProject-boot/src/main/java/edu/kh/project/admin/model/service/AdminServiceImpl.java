package edu.kh.project.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.admin.model.mapper.AdminMapper;
import edu.kh.project.member.model.dto.Member;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper mapper;
	
	@Override
	public Member selectMember(String inputEmail) {
		return mapper.selectMember(inputEmail);
	}
	
	@Override
	public List<Member> selectAll() {
		return mapper.selectAll();
	}
	
	@Override
	public List<Member> selectSort(int sort) {
		
		// sort 값에 따라 가공 처리
		String query = null;
		
		switch(sort) {
		case 1 : query = "MEMBER_NO DESC"; break; // 회원번호 내림차순
		case 2 : query = "MEMBER_NO"; break; // 회원번호 오름차순
		case 3 : query = "MEMBER_EMAIL DESC"; break; // 이메일 내림차순
		case 4 : query = "MEMBER_EMAIL"; break; // 이메일 오름차순
		}
		
		return mapper.selectSort(query);
	}
	
	
	@Override
	public int restoration(int memberNo) {
		return mapper.restoration(memberNo);
	}
	
	
	
}
