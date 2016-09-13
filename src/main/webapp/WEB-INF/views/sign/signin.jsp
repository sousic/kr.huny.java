<%--
  Created by IntelliJ IDEA.
  User: sousic
  Date: 2016. 8. 17.
  Time: 오후 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br/><br/>
<div class="container">
    <h2>로그인</h2>
    <div class="panel-group">
        <div class="col-md-4 center-pill">
            <div class="panel panel-default">
                <div class="panel-heading text-center">아이디 로그인</div>
                <div class="panel-body">
                    <form role="form" id="loginForm" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control input-sm" id="userid" name="userid" value="${userid}" placeholder="아이디" required autofocus>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control input-sm" id="userpwd" name="userpwd" placeholder="비밀번호" required>
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox" id="remember" name="remember"> 로그인 유지</label>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">로그인</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    <c:if test="${flag ne null}">
    $(window).load(function() {
        <c:choose>
        <c:when test="${flag eq 'NotUserID'}">
            alert('ID가 존재 하지 않습니다.');
        </c:when>
        <c:when test="${flag eq 'PwdFailCount'}">
        alert('비밀번호를 다수 틀렸습니다.');
        </c:when>
        <c:when test="${flag eq 'LoginBlock'}">
        alert('비밀번호 오류로 로그인이 차단 되었습니다.');
        </c:when>
        </c:choose>
    });
    </c:if>
</script>