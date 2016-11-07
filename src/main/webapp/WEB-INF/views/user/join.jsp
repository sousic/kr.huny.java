<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>타이틀 영역</title>
    <jsp:include page="/WEB-INF/views/include/header_html.jsp"/>
</head>
<body>
<div class="layout-container">
    <div class="main">
        <!-- GNB -->
        <jsp:include page="/WEB-INF/views/include/navi.jsp"/>
        <!-- GND end -->
        </div>
        <div class="container content">
            <div class="sign">
                <div class="col-md-4 col-md-offset-4">
                    <div>
                    <h4>가입하기</h4>
                    </div>
                    <div>
                        <form class="" method="post" action="/join">
                            <div class="form-group">
                                <label for="userid">아이디</label>
                                <input type="text" id="userid" name="userid" value="" class="form-control input-sm" required="required"/>
                            </div>
                            <div class="form-group">
                                <label for="password1">비밀번호</label>
                                <input type="password" id="password1" name="password" value=""  class="form-control input-sm" required="required"/>
                            </div>
                            <div class="form-group">
                                <label for="password2">비밀번호 확인</label>
                                <input type="password" id="password2" name="password" value=""  class="form-control input-sm"  required="required"/>
                            </div>
                            <div class="form-group">
                                <label for="name">이름</label>
                                <input type="text" id="name" name="name" value="" class="form-control input-sm" required="required"/>
                            </div>
                            <input type="submit" class="btn btn-block btn-primary" value="가입하기"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer">
            <!-- footer -->
            <jsp:include page="/WEB-INF/views/include/footer.jsp"/>
            <!-- footer end -->
        </div>
    </div>
</div>
<script src="/resources/js/jquery/jquery.min.js"/>
</body>
</html>
