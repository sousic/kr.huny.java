<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html ng-app="hunyApp">
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
        <div class="container content" ng-controller="joinCtrl">
            <div class="row">
            <!-- content -->
                <div class="col-md-5 col-md-offset-4">
                    <form:form modelAttribute="userJoin" method="post" cssClass="reg-page" action="/join" ng-submit="onsubmit($event)">
                        <div class="reg-header">
                            <h4>가입하기</h4>
                        </div>
                        <div>
                            <form:errors path="password_confirm"/>
                        </div>
                        <div class="form-group">
                            <label for="userid">아이디</label>
                            <input type="text" name="userid" id="userid" value="${userJoin.userid}" class="form-control input-sm" ng-model="userid" required="required" ng-keyup="validationUserId()"/>
                            <div class="well">
                                {{id_message}}
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="password">비밀번호</label>
                                    <form:password path="password" class="form-control input-sm" required="required" />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="password_confirm">비밀번호 확인</label>
                                    <form:password path="password_confirm" class="form-control input-sm"  required="required"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name">이름</label>
                            <form:input path="name" class="form-control input-sm" required="required"/>
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
    var hunyApp = angular.module("hunyApp", []);
    hunyApp.controller("joinCtrl", function($scope, $http) {
       $scope.onSubmit = function (event) {

           event.preventDefault();
       };

       $scope.validationUserId = function () {
           $scope.id_message = $scope.userid;
       };
    });
</script>
</body>
</html>
