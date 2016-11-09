<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html ng-app="hunyApp">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>angularJS Samples</title>
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
                <form method="post" cssClass="reg-page" action="/join" ng-submit="onSubmit($event)" name="joinForm">
                    <div class="reg-header">
                        <h4>가입하기</h4>
                    </div>
                    <div class="form-group">
                        <label for="userid">아이디</label>
                        <input type="text" name="userid" id="userid" class="form-control input-sm" ng-model="userid" required="required" ng-keyup="validationUserId()" ng-blur="onUserId()" ng-minlength="4" ng-maxlength="20" placeholder="아이디를 넣어주세요."/>
                        <div class="well" ng-show="id_message">
                            {{id_message}}
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="password">비밀번호</label>
                                <input type="password" id="password" name="password" class="form-control input-sm" required="required" />
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="password_confirm">비밀번호 확인</label>
                                <input type="password" id="password_confirm" name="password_confirm" class="form-control input-sm"  required="required"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name">이름</label>
                        <input type="text" id="name" name="name" class="form-control input-sm" required="required"/>
                    </div>
                    <input type="submit" class="btn btn-block btn-primary" value="가입하기"/>
                </form>
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
            if ($scope.joinForm.userid.$invalid) {
                $scope.id_message = '길이 초과';
            }
            else
            {
                $scope.id_message = "사용 가능합니다.";
            }
        };

        $scope.onUserId = function () {
            if($scope.joinForm.userid.$valid) {
                $scope.id_message = '길이 초과';
            }
            else
            {
                $scope.id_message = "사용 가능합니다.";
            }
        };
    });
</script>
</body>
</html>