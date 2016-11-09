<%@ page import="kr.huny.utils.NaviHelper" %>
<%@ page import="kr.huny.utils.RequestHelper" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%
    String currentURL = RequestHelper.getCurrentRequest().getRequestURI();
    String activeCSS = "active";
    String nonActiveCss = "";
    //out.println(currentURL);
%>
<div class="blog-masthead">
    <div class="container">
        <ul class="blog-nav">
            <li><a href="<c:url value="/home"/>" class="blog-nav-item <%=NaviHelper.activeNavi(currentURL, "/home", activeCSS, nonActiveCss)%>">홈</a></li>
            <li><a href="<c:url value="/board/free"/>" class="blog-nav-item <%=NaviHelper.activeNavi(currentURL, "/board/free", activeCSS, nonActiveCss)%>">게시판</a></li>
            <c:if test="${isLogin == 'False'}">
            <li class="login"><a href="<c:url value="/login"/>" class="blog-nav-item"><i class="fa fa-sign-in" aria-hidden="true"></i> 로그인</a></li>
            </c:if>
            <c:if test="${isLogin != 'True'}">
                <li class="login"><a href="<c:url value="/logout"/>" class="blog-nav-item"><i class="fa fa-sign-in" aria-hidden="true"></i> 로그아웃</a></li>
            </c:if>
        </ul>
    </div>
</div>