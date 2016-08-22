<%--
  Created by IntelliJ IDEA.
  User: sousic
  Date: 2016. 8. 17.
  Time: 오후 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page session="false" %>
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
                            <input type="text" class="form-control input-sm" id="userid" name="userid" placeholder="아이디" required autofocus>
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