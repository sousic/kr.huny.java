<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
        <ul class="nav nav-sidebar">
            <li>${pageContext.request.contextPath}</li>
            <li><a href="${adminPath}/member/list"><i class="fa fa-user-o">&nbsp;</i>회원목록</a></li>
            <li><a href="${adminPath}/member/history"><i class="fa fa-history">&nbsp;</i>로그인기록</a></li>
            <li><a href="${adminPath}/board/manager/list"><i class="fa fa-list-alt">&nbsp;</i>게시판관리</a></li>
        </ul>
    </div>
</div>
