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
<div class="blog-masthead navbar-fixed-top">
    <div class="container">
        <ul class="blog-nav">
            <li><a href="<c:url value="/home"/>" class="blog-nav-item <%=NaviHelper.activeNavi(currentURL, "/home", activeCSS, nonActiveCss)%>">홈</a></li>
            <li><a href="<c:url value="/board/free"/>" class="blog-nav-item <%=NaviHelper.activeNavi(currentURL, "/board/free", activeCSS, nonActiveCss)%>">게시판</a></li>
            <c:if test="${grade == 255}">
                <li><a href="<c:url value="/category/list"/>" class="blog-nav-item <%=NaviHelper.activeNavi(currentURL, "/category/list", activeCSS, nonActiveCss)%>">분류</a></li>
                <li><a href="<c:url value="/member/list"/>" class="blog-nav-item <%=NaviHelper.activeNavi(currentURL, "/member/list", activeCSS, nonActiveCss)%>">회원</a></li>
            </c:if>
            <c:choose>
                <c:when test="${isLogin == true}">
                    <li class="login"><a href="<c:url value="/logout"/>" class="blog-nav-item"><i class="fa fa-sign-in" aria-hidden="true"></i> 로그아웃</a></li>
                </c:when>
                <c:otherwise>
                    <li class="login"><a href="<c:url value="/login"/>" class="blog-nav-item"><i class="fa fa-sign-in" aria-hidden="true"></i> 로그인</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</div>