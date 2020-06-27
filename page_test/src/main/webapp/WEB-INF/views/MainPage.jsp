<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script type="text/javascript">
$(function(){
	

/*  alert('${id}' + "님이 로그인 하셨습니다"); */

	
	$("#logout_btn").click(function(){
		$.ajax("/logout",{success:function(re){
			alert(re);
			window.location.reload(true);
			}});
		});
})
	
</script>
<body>
<h2>메인화면</h2>
<% String id =  (String)session.getAttribute("id");%> 
<% if(id != null && !"".equals(id)){%>
	<button id='logout_btn'>로그아웃</button><br>
	<%=id %>님이 로그인하셨습니다<br>
<%}else{ %>
	<section id="login_section">
	<form action="/login">
	아이디 : <input type="text" name="user_id"><br>
	암호 : <input type="password" name="pwd"><br>
	<button type="submit">로그인</button><br>
	</form>
<%
}
%>
</section>
<a href="/allMember">모든 회원리스트</a><br>
<a href="/insertMemberForm">회원 가입</a>
</body>
</html>