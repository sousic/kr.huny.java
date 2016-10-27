<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Test</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap.min.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/resources/css/summernote/summernote.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/admin.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/font-awesome/font-awesome.min.css" rel="stylesheet"/>
</head>

<body>
<div>
    <nav class="navbar navbar-inverse navbar-fixed-top">
    <tiles:insertAttribute name="top"/>
    </nav>
    <div class="container-fluid">
        <tiles:insertAttribute name="left" ignore="true"/>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <tiles:insertAttribute name="content"/>
        </div>
    </div>
    <tiles:insertAttribute name="footer"/>
</div>
<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/summernote/summernote.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/summernote/lang/summernote-ko-KR.min.js"></script>
<!-- /compose -->
<tiles:insertAttribute name="footerScript" ignore="true"/>
</body>
</html>
