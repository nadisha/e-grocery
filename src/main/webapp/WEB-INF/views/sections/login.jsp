<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<form action='<spring:url value="/action/authenticate"/>' method="post">
	User Name : <input type="text" name="userName"/> <br/>
	Password : <input type="password" name="password"/> <br/>
	<input type="submit" value="Login"/>
</form>