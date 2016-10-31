<%@ page import="kr.huny.utils.RequestHelper" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <!-- page content -->
    <div class="container-fluid">
        <div class="row">
            <div class="page-title">
                <div class="page-header">
                    <h3>회원관리 <small>로그인 기록 보기</small></h3>
                </div>
            </div>
            <div class="searchForm text-right">
            <form method="get" action="<%=RequestHelper.getCurrentRequest().getRequestURI()%>">
                <select name="perPageNum" class="input-sm">
                    <option value="10" <c:if test="${10 == pagingHelper.pageInfo.perPageNum}">selected="selected"</c:if>>10</option>
                    <option value="25" <c:if test="${25 == pagingHelper.pageInfo.perPageNum}">selected="selected"</c:if>>25</option>
                    <option value="50" <c:if test="${50 == pagingHelper.pageInfo.perPageNum}">selected="selected"</c:if>>50</option>
                    <option value="100" <c:if test="${100 == pagingHelper.pageInfo.perPageNum}">selected="selected"</c:if>>100</option>
                </select>
                <input type="search" class="input-sm inputText" placeholder="검색어를 넣어주세요" aria-controls="datatable" id="schText" name="schText" value="${pagingHelper.pageInfo.schText}"><button type="submit" class="btn btn-default">검색</button>
            </form>
        </div>

        <div class="boardWrapper">
            <table id="datatable" class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>Seq</th>
                    <th>UserId</th>
                    <th>RemoteIP</th>
                    <th>date</th>
                    <th>Result</th>
                    <th>Flag</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${fn:length(list) == 0}">
                    <tr>
                        <td colspan="10" class="text-center">내용이 없습니다.</td>
                    </tr>
                </c:if>
                <c:if test="${fn:length(list) > 0}">
                    <c:forEach items="${list}" var="loginHistoryVO">
                        <tr>
                            <td>${loginHistoryVO.seq}</td>
                            <td>${loginHistoryVO.userid}</td>
                            <td>${loginHistoryVO.remoteip}</td>
                            <td><fmt:formatDate value="${loginHistoryVO.date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td>${loginHistoryVO.result}</td>
                            <td>${loginHistoryVO.flag}</td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
        <div class="text-center">
            ${pagingHelper.printPaging(pageContext.request)}
        </div>
    </div>
</div>
<!-- /page content -->
<script>

</script>