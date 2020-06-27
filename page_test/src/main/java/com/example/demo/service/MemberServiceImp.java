package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao;
import com.example.demo.util.Criteria;
import com.example.demo.util.SearchCriteria;
import com.example.demo.vo.MemberVo;
import com.example.demo.vo.Member_PicVo;
@Service
public class MemberServiceImp implements MemberService {
	
	@Autowired
	MemberDao mdao;
	
	//모든 회원
	@Override
	public List<MemberVo> allMember(SearchCriteria scri) {
		// TODO Auto-generated method stub
		List<MemberVo> list = mdao.allMember(scri);
		return list;
	}
	
	//회원 상세 보기
	@Override
	public MemberVo searchMember(int member_no) {
		// TODO Auto-generated method stub
		MemberVo m = mdao.searchMember(member_no);
		return m;
	}

	//회원 가입
	@Override
	public void insertMember(MemberVo m) {
		// TODO Auto-generated method stub
		mdao.insertMember(m);
	}

	//사진 등록
	@Override
	public void insertMember_Pic(Member_PicVo mp) {
		// TODO Auto-generated method stub
		mdao.insertMember_Pic(mp);
	}
	
	//로그인
	@Override
	public MemberVo login(MemberVo m) {
		// TODO Auto-generated method stub
		MemberVo re = mdao.login(m);
		return re;
	}

	//전체 회원 수
	@Override
	public int countMember(SearchCriteria scri) {
		// TODO Auto-generated method stub
		int re = -1;
		re = mdao.countMember(scri);
		return re;
	}

	
	
}
