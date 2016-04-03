<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta name="author" content="Shahid Yousuf" />
        <meta name="company" content="FrameworkOnly" />
        <meta name="abstract" content="Connecting Problems & Solutions." />
 		<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
 		
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<div align="center">	
        <tiles:insertAttribute name="header" />
        <hr/>
        <tiles:insertAttribute name="body" />
        <hr/>
        <tiles:insertAttribute name="footer" />
	</div>        
</body>
</html>