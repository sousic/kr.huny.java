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
    <h2>회원가입</h2>
    <div class="panel-group">
        <div class="col-md-8 center-pill">
            <div class="panel panel-default">
                <div class="panel-heading text-center">회원 가입하기</div>
                <div class="panel-body">
                    <form role="form" id="registForm" method="post" data-toggle="validator">
                        <div class="form-group">
                            <div class="input-group">
                                <input type="text" class="form-control input-sm" id="userid" name="userid" placeholder="아이디" required autofocus>
                                <span class="input-group-btn">
                                    <button type="button" class="btn btn-default btn-sm" id="btnIdChecker">중복체크</button>
                                </span>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control input-sm" id="userpwd" name="userpwd" placeholder="비밀번호" required>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control input-sm" id="userpwd2" name="userpwd2" placeholder="비밀번호 확인" required>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control input-sm" id="nickname" name="nickname" placeholder="별명" required>
                        </div>
                        <input type="hidden" id="idchecked" value=""/>
                        <button type="submit" class="btn btn-primary">가입</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $("#registForm").on("submit", function () {
        if($.trim($("#userpwd").val()) != $.trim($("#userpwd2").val()))
        {
            $("#userpwd2").val("").focus();
            return false;
        }
    });

    $("#btnIdChecker").click(function() {
        if($.trim($("#userid").val()) == '') {
            alert("아이디를 입력해 주세요.");
            $("#userid").focus();
            return false;
        }
        else
        {
            $.getJSON("/sign/checker?userid=" + $("#userid").val(), function(data) {
                if(data.resultCode == 1)
                {
                    alert("사용 가능 합니다.");
                    $("#idchecked").val(1);
                }
                else
                {
                    alert(data.resultMsg);
                    return false;
                }
            });
        }
    });
</script>