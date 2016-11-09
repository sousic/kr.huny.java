<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title><spring:message code="title"/> > <spring:message code="title.user.login"/></title>
    <jsp:include page="/WEB-INF/views/include/header_html.jsp"/>
</head>
<body>
<div class="layout-container">
    <div class="main">
        <!-- GNB -->
        <%@ include file="/WEB-INF/views/include/navi.jsp"%>
        <!-- GND end -->
        </div>
        <div class="container content">
            <div class="row">
            <!-- content -->
                <div class="col-md-5 col-md-offset-4">
                    <form:form modelAttribute="userLogin" method="post" cssClass="reg-page" action="/login">
                        <div class="reg-header">
                            <h4>로그인</h4>
                        </div>
                        <div>
                            <form:errors path="*"/>
                        </div>
                        <div class="form-group">
                            <label for="userid">아이디</label>
                            <input type="text" name="userid" id="userid" value="${userLogin.userid}" class="form-control input-sm" required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="password">비밀번호</label>
                            <input type="password" id="password" name="password" required="required" class="form-control input-sm" required="required" value="${userLogin.password}"/>
                        </div>
                        <div class="row">
                            <div class="col-md-6 col-xs-6">
                                <input type="submit" class="btn btn-block btn-primary" value="로그인"/>
                            </div>
                            <div class="col-md-6 col-xs-6">
                                <a href="<c:url value="/home"/>" class="btn btn-default btn-block">돌아가기</a>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
            <!-- content end -->
        </div>
        <div class="footer">
            <!-- footer -->
            <jsp:include page="/WEB-INF/views/include/footer.jsp"/>
            <!-- footer end -->
        </div>
    </div>
</div>
<script>
</script>
</body>
</html>
