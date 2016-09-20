<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dhjang
  Date: 2016-09-19
  Time: 오후 3:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!-- page content -->
    <div class="">
        <div class="page-title">
            <div class="title_left">
                <h3>회원관리 <small>로그인 기록 보기</small></h3>
            </div>
        </div>

        <div class="clearfix"></div>

        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>로그인 기록 <small></small></h2>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        <p class="text-muted font-13 m-b-30">
                            <%--DataTables has most features enabled by default, so all you need to do to use it with your own tables is to call the construction function: <code>$().DataTable();</code>--%>
                        </p>
                        <div id="datatable_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="dataTables_length" id="datatable_length">
                                        <label>Show
                                            <select name="datatable_length" aria-controls="datatable" class="form-control input-sm">
                                            <option value="10">10</option>
                                            <option value="25">25</option>
                                            <option value="50">50</option>
                                            <option value="100">100</option>
                                        </select>
                                        entries</label>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div id="datatable_filter" class="dataTables_filter"><label>Search:<input type="search" class="form-control input-sm" placeholder="" aria-controls="datatable"></label>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
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
                                <c:forEach items="${list}" var="loginHistoryVO">
                                    <tr>
                                        <td>${loginHistoryVO.seq}</td>
                                        <td>${loginHistoryVO.userid}</td>
                                        <td>${loginHistoryVO.remoteip}</td>
                                        <td>${loginHistoryVO.date}</td>
                                        <td>${loginHistoryVO.result}</td>
                                        <td>${loginHistoryVO.flag}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            </div>
                        </div>
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
    $(function(){

    });
    </script>