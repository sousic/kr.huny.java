<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title><spring:message code="title"/> > <spring:message code="title.user.register"/></title>
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
                    <form:form modelAttribute="userJoin" method="post" cssClass="reg-page" action="/join">
                        <div class="reg-header">
                            <h4>가입하기</h4>
                        </div>
                        <div>
                            <form:errors path="*"/>
                        </div>
                        <div class="form-group">
                            <label for="userid">아이디</label>
                            <input type="text" name="userid" id="userid" value="${userJoin.userid}" class="form-control input-sm" required="required"/>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="password">비밀번호</label>
                                    <input type="password" id="password" name="password" required="required" class="form-control input-sm" required="required" value="${userJoin.password}"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="password_confirm">비밀번호 확인</label>
                                    <input type="password" id="password_confirm" name="password_confirm"  class="form-control input-sm"  required="required" value="${userJoin.password_confirm}"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name">이름</label>
                            <input type="text" id="name" name="name" class="form-control input-sm" required="required" value="${userJoin.name}"/>
                        </div>
                        <input type="submit" class="btn btn-block btn-primary" value="가입하기"/>
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
