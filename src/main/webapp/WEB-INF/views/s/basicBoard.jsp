<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
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
        <%@ include file="/WEB-INF/views/include/navi.jsp"%>
        <!-- GND end -->
    </div>
    <div class="container content">
        <div class="row">
            <!-- content -->
            <div class="article-list">
                <ul>
                    <li>
                        <div>제목영역</div>
                        <div>조회수/추천</div>
                        <div>작성자정보</div>
                    </li>
                    <li>
                        <div>제목영역</div>
                        <div>조회수/추천</div>
                        <div>작성자정보</div>
                    </li>
                    <li>
                        <div>제목영역</div>
                        <div>조회수/추천</div>
                        <div>작성자정보</div>
                    </li>
                </ul>
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
<script src="/resources/js/jquery/jquery.min.js"/>
</body>
</html>
