package com.example.demo.service;

import java.util.List;

import com.example.demo.util.Criteria;
import com.example.demo.util.SearchCriteria;
import com.example.demo.vo.MemberVo;
import com.example.demo.vo.Member_PicVo;


public interface MemberService {
	//모든 회원
	public List<MemberVo> allMember(SearchCriteria scri);
	
	//전체 회원 수
	public int countMember(SearchCriteria scri);
	
	//회원 상세
	public MemberVo searchMember(int member_no);
	
	//회원 가입
	public void insertMember(MemberVo m);
	
	//사진 등록
	public void insertMember_Pic(Member_PicVo mp);
	
	//로그인
	public MemberVo login(MemberVo m);
}
