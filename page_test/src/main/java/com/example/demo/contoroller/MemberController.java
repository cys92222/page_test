package com.example.demo.contoroller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.MemberService;
import com.example.demo.util.Criteria;
import com.example.demo.util.PageMaker;
import com.example.demo.util.SearchCriteria;
import com.example.demo.vo.MemberVo;
import com.example.demo.vo.Member_PicVo;

@Controller
public class MemberController {
	
	@Autowired
	MemberService ms;
	
	//모든 회원 목록
	@RequestMapping(value = "/allMember", method = RequestMethod.GET)
	public String allMember(Model model, @ModelAttribute("scri") SearchCriteria scri) {
		System.out.println("모든 회원 목록 컨트롤로");
		List<MemberVo> list = ms.allMember(scri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(ms.countMember(scri));
		
		model.addAttribute("allMember", list);
		model.addAttribute("pageMaker", pageMaker);
		return "/allMember";
	}
	
	//회원 상세 보기
	@RequestMapping("/searchMember")
	@ResponseBody
	public MemberVo searchMember(int member_no) {
		System.out.println("회원 상세 보기");
		System.out.println("상세보기할 회원 번호" +member_no);
		MemberVo m = ms.searchMember(member_no);
		return m;
	}
	
	//회원가입폼
	@RequestMapping("insertMemberForm")
	public String insertMemberForm() {
		return "insertMember";
	}
	
	//회원가입
	@RequestMapping(value = "insertMember", method = RequestMethod.POST)
	public String insertMember(MemberVo m, MultipartFile mf,HttpServletRequest request) {
		System.out.println("회원 가입 컨트롤러");
		ms.insertMember(m);
		
		//사진 등록
		if(!mf.isEmpty()) {
			System.out.println("사진등록함");
			Member_PicVo mp = new Member_PicVo();
			mp.setPic_name(mf.getOriginalFilename());
			mp.setUser_id(m.getUser_id());
			//db에 입력
			ms.insertMember_Pic(mp);
			//파일 저장
			try {
				//저장경로
				String path = request.getRealPath("member_pic");
				System.out.println(path);
				
				byte []data = mf.getBytes();
//				File file = new File(path + "/" + mf.getOriginalFilename());
				FileOutputStream fos = new FileOutputStream(path + "/" + mf.getOriginalFilename());
				fos.write(data);
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			
			
		}
		//사진 등록 안함
		else {
			System.out.println("사진등록안함");
			Member_PicVo mp = new Member_PicVo();
			mp.setPic_name("사진등록안함.jpg");
			mp.setUser_id(m.getUser_id());
			ms.insertMember_Pic(mp);
		}
		
		return "redirect:/allMember";
	}
	
	@RequestMapping("/login")
	public String login(MemberVo m, HttpSession session) {
		MemberVo re = ms.login(m);
		System.out.println("로그인 아이디" +m.getUser_id());
		session.setAttribute("id",m.getUser_id());
		return "/loginOk";
	}
	
	@RequestMapping("/logout")
	@ResponseBody
	public String logout(HttpSession session) {
		System.out.println("로그아웃 컨트롤러");
		session.removeAttribute("id");
		return "로그아웃했습니다";
	}
}
