<%@ page import="kr.huny.utils.RequestHelper" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- page content -->
    <div class="">
        <div class="page-title">
            <div class="title_left">
                <h3>게시판 관리 <small>게시판 목록</small></h3>
            </div>
        </div>

        <div class="clearfix"></div>

        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>게시판 목록<small></small></h2>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        <p class="text-muted font-13 m-b-30">
                            <%--DataTables has most features enabled by default, so all you need to do to use it with your own tables is to call the construction function: <code>$().DataTable();</code>--%>
                        </p>
                        <div id="datatable_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                            <form method="get" action="<%=RequestHelper.getCurrentRequest().getRequestURI()%>">
                                <div class="row">
                                    <div class="col-sm-4">
                                        <div class="dataTables_length" id="perPageNum">
                                            <label>Show
                                                <select name="perPageNum" aria-controls="datatable" class="form-control input-sm">
                                                    <option value="10" <c:if test="${10 == pagingHelper.pageInfo.perPageNum}">selected="selected"</c:if>>10</option>
                                                    <option value="25" <c:if test="${25 == pagingHelper.pageInfo.perPageNum}">selected="selected"</c:if>>25</option>
                                                    <option value="50" <c:if test="${50 == pagingHelper.pageInfo.perPageNum}">selected="selected"</c:if>>50</option>
                                                    <option value="100" <c:if test="${100 == pagingHelper.pageInfo.perPageNum}">selected="selected"</c:if>>100</option>
                                                </select>
                                                entries</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-8">
                                        <div id="datatable_filter" class="dataTables_filter"><label>Search:<input type="search" class="form-control input-sm" placeholder="검색어를 넣어주세요" aria-controls="datatable" id="schText" name="schText" value="${pagingHelper.pageInfo.schText}"><button type="submit" class="btn btn-default">검색</button></label>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <div class="row">
                                <table id="datatable" class="table table-striped table-bordered">
                                    <thead>
                                    <tr>
                                        <th>seq</th>
                                        <th>title</th>
                                        <th>description</th>
                                        <th>totalArticle</th>
                                        <th>createDate</th>
                                        <th>modifyDate</th>
                                        <th>displayType</th>
                                        <th>isComment</th>
                                        <td>listSize</td>
                                        <th>writer</th>
                                        <th>isArticleWriter</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:if test="${fn:length(list) == 0}">
                                        <tr>
                                            <td colspan="11" class="text-center">내용이 없습니다.</td>
                                        </tr>
                                    </c:if>
                                    <c:if test="${fn:length(list) > 0}">
                                    <c:forEach items="${list}" var="boardManageVO">
                                        <tr>
                                            <td>${boardManageVO.seq}</td>
                                            <td>${boardManageVO.title}</td>
                                            <td>${boardManageVO.description}</td>
                                            <td>${boardManageVO.totalArticle}</td>
                                            <td><fmt:formatDate value="${boardManageVO.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                            <td><fmt:formatDate value="${boardManageVO.modifiyDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                            <td>${boardManageVO.displayType}</td>
                                            <td>${boardManageVO.isComment}</td>
                                            <td>${boardManageVO.listSize}</td>
                                            <td>${boardManageVO.writer}</td>
                                            <td>${boardManageVO.isArticleWriter}</td>
                                        </tr>
                                    </c:forEach>
                                    </c:if>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div class="clearfix"></div>

                    <div class="text-right">
                        <a href="${adminPath}/board/manager/create" class="btn btn-primary">등록</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="text-center">
            ${pagingHelper.printPaging(pageContext.request)}
        </div>
    </div>
<!-- /page content -->
<script>

</script>
