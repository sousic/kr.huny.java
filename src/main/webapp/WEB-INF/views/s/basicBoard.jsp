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
                <div class="article-list-header">
                    <div class="list-sort">
                        <a href="#" class="btn-xs">최신순</a> | <a href="#" class="btn-xs">추천수</a> | <a href="#" class="btn-xs">댓글수</a> | <a href="#" class="btn-xs">스크랩순</a> | <a href="#" class="btn-xs">조회수</a>
                    </div>
                    <div class="list-category-filter">
                        <form method="get">
                            <div class="input-group input-group-sm">
                                <input type="text" id="search" name="search" class="input-sm form-control" placeholder="검색어를 입력하세요."/>
                                <span class="input-group-btn">
                                    <button type="submit" class="btn btn-default">
                                        <i class="fa fa-search" aria-hidden="true"></i>
                                    </button>
                                </span>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="article-list-main">
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
