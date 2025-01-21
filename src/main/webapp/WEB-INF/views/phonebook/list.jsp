<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="<c:url value="/assets/css/phonebook.css" />" />
</head>

<body>

	<h1>전화번호부</h1>

	<h2>리스트</h2>

	<p>등록된 전화번호 리스트입니다.</p>


	<table border="1">
		<tr>
			<th>이름(name)</th>
			<td></td>
		</tr>
		<tr>
			<th>핸드폰(hp)</th>
			<td></td>
		</tr>
		<tr>
			<th>회사(company)</th>
			<td></td>
		</tr>
		<tr>
			<td><a href="">[삭제]</a>
			</td>
			<td><a href="">[수정]</a>
			</td>
		</tr>

	</table>
	<br>

	<a href="">추가번호 등록</a>

</body>

</html>