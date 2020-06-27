<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	<% String id =  (String)session.getAttribute("id");%> 
	alert('${id}' + "님이 로그인 하셨습니다");
})
</script>
</head>
<body>
<a href="/MainPage">메인 페이지</a>

</body>
</html>