<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<div class="container">
    <div class="form-signin">
        <form method="post" action="/${adminPath}/login">
            <div class="form-signin-header">
                <h2>로그인 하기</h2>
            </div>

            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon form-signin-label"><i class="fa fa-user"></i></span>
                    <input type="text" id="userid" name="userid" required="required" class="form-control" placeholder="아이디"/>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon form-signin-label"><i class="fa fa-lock"></i></span>
                    <input type="password" id="userpwd" name="userpwd" required="required" class="form-control" placeholder="비밀번호"/>
                </div>
            </div>

            <button type="submit" class="btn btn-primary btn-block">로그인</button>

        </form>
    </div>
</div>
