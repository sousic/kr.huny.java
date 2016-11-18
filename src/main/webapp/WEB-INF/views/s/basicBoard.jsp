<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
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
                        <li class="item item-has-comment clearfix">
                            <div class="list-title-wrapper clearfix">
                                <div>
                                    <span>#111111</span>
                                    <span>자유게시판</span>
                                </div>
                                <div class="title">
                                    <span >
                                   제목영역 제목영역 제목영역 제목영역 제목영역 제목영역 제목영역 제목영역 제목영역 제목영역 제목영역 제목영역
                                    </span>
                                </div>
                            </div>
                            <div class="list-count-wrapper clearfix">
                                <div class="list-count-wrapper-box">
                                    <div class="list-count-vote">
                                        <i class="fa fa-star" aria-hidden="true">추천수</i> 0
                                    </div>
                                    <div class="list-count-comment">
                                        <i class="fa fa-comments" aria-hidden="true">댓글수</i> 0
                                    </div>
                                    <%--<i class="fa fa-eye" aria-hidden="true">조회수</i>--%>
                                </div>
                            </div>
                            <div class="list-writer-wrapper clearfix">
                                <div class="list-writer-wrapper-box">
                                    <div class="list-writer">
                                        <span>홍길동</span>
                                        <span class="small"><i class="fa fa-bolt" aria-hidden="true"> 11111</i></span>
                                    </div>
                                    <div class="list-write-date">
                                        <span class="small"><i class="fa fa-clock-o" aria-hidden="true"></i>1분전</span>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="item clearfix">
                            <div class="list-title-wrapper clearfix">
                                <div>
                                    <span>#111111</span>
                                    <span>자유게시판</span>
                                </div>
                                <div class="title">
                                    <span >
                                    제목영역 제목영역 제목영역 제목영역 제목영역 제목영역 제목영역
                                    </span>
                                </div>
                            </div>
                            <div class="list-count-wrapper clearfix">
                                <div class="list-count-wrapper-box">
                                    <div class="list-count-vote">
                                        <i class="fa fa-star" aria-hidden="true">추천수</i> 0
                                    </div>
                                    <div class="list-count-comment">
                                        <i class="fa fa-comments" aria-hidden="true">댓글수</i> 0
                                    </div>
                                    <%--<i class="fa fa-eye" aria-hidden="true">조회수</i>--%>
                                </div>
                            </div>
                            <div class="list-writer-wrapper clearfix">
                                <div class="list-writer-wrapper-box">
                                    <div class="list-writer">
                                        <span>홍길동</span>
                                        <span class="small"><i class="fa fa-bolt" aria-hidden="true"> 11111</i></span>
                                    </div>
                                    <div class="list-write-date">
                                        <span class="small"><i class="fa fa-clock-o" aria-hidden="true"></i>1분전</span>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="item item-has-comment clearfix">
                            <div class="list-title-wrapper clearfix">
                                <div>
                                    <span>#111111</span>
                                    <span>자유게시판</span>
                                </div>
                                <div class="title">
                                    <span >
                                    제목영역 제목영역 제목영역 제목영역
                                    </span>
                                </div>
                            </div>
                            <div class="list-count-wrapper clearfix">
                                <div class="list-count-wrapper-box">
                                    <div class="list-count-vote">
                                        <i class="fa fa-star" aria-hidden="true">추천수</i> 0
                                    </div>
                                    <div class="list-count-comment">
                                        <i class="fa fa-comments" aria-hidden="true">댓글수</i> 0
                                    </div>
                                    <%--<i class="fa fa-eye" aria-hidden="true">조회수</i>--%>
                                </div>
                            </div>
                            <div class="list-writer-wrapper clearfix">
                                <div class="list-writer-wrapper-box">
                                    <div class="list-writer">
                                        <span>홍길동</span>
                                        <span class="small"><i class="fa fa-bolt" aria-hidden="true"> 11111</i></span>
                                    </div>
                                    <div class="list-write-date">
                                        <span class="small"><i class="fa fa-clock-o" aria-hidden="true"></i>1분전</span>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="text-center">
                    <ul class="pagination">
                        <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
                        <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li> <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
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
