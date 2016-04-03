<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<form  id='registration' >
	First Name : <input type="text" name="firstName"/> <br/>
	Last Name : <input type="text" name="lastName"/> <br/>
	User Name : <input type="text" name="userName"/> <br/>
	Password : <input type="password" name="password"/> <br/>
	<input type="Button" value="Register" onclick="getRegister()" />
</form>


<script>
function getRegister() {
  var user = {
  firstName : $('#registration').find( "input[name='firstName']" ).val(),
  lastName : $('#registration').find( "input[name='lastName']" ).val(),
  userName : $('#registration').find( "input[name='userName']" ).val(),
  password : $('#registration').find( "input[name='password']" ).val()
  }  
  
  $.ajax({
      url: '<spring:url value="/action/register"/>',
      type: 'post',
      headers: { 
      'Accept': 'application/json',
      'Content-Type': 'application/json' 
      },      
      dataType: 'json',
      success: function (data) {
    	  window.location.replace('<spring:url value="/login"/>');
      },
      data: JSON.stringify(user)
  });    
}  
 
</script>