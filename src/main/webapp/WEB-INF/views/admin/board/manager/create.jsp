<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
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
                    <h2>게시판 등록<small></small></h2>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                        <%--DataTables has most features enabled by default, so all you need to do to use it with your own tables is to call the construction function: <code>$().DataTable();</code>--%>
                    </p>
                    <div class="row">
                        <div class="x_content">
                            <br />
                            <form id="sForm" data-parsley-validate class="form-horizontal form-label-left" method="post" action="${adminPath}/board/manager/create">

                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="title">제목 <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="title" name="title" required="required" class="form-control col-md-7 col-xs-12" value="${boardManagerVO.title}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="description">설명 <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="description" name="description" required="required" class="form-control col-md-7 col-xs-12" value="${boardManagerVO.description}">
                                    </div>
                                </div>
                                <%--<div class="form-group">
                                    <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Middle Name / Initial</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input id="middle-name" class="form-control col-md-7 col-xs-12" type="text" name="middle-name">
                                    </div>
                                </div>--%>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">보기형식</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <div class="radio">
                                            <label>
                                            <input type="radio" class="flat" name="displayType" id="displayType1" value="1"  required <c:if test="${1 == boardManagerVO.displayType}">checked=""</c:if>/> 목록</label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                            <input type="radio" class="flat" name="displayType" id="displayType2" value="2" <c:if test="${2 == boardManagerVO.displayType}">checked=""</c:if>/> 썸네일
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                            <input type="radio" class="flat" name="displayType" id="displayType3" value="3" <c:if test="${3 == boardManagerVO.displayType}">checked=""</c:if>/> 블로그형
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">댓글유무</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <div class="radio">
                                            <label>
                                                <input type="radio" class="flat" name="isComment" id="isComment1" value="1"  <c:if test="${1 == boardManagerVO.isComment}">checked=""</c:if> required/> 사용
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" class="flat" name="isComment" id="isComment0" value="0" <c:if test="${0 == boardManagerVO.isComment}">checked=""</c:if>/> 미사용
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">목록수</label> <span class="required">*</span>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <select class="form-control" name="listSize" id="listSize" required="required">
                                            <option value="">--선택--</option>
                                            <option value="10" <c:if test="${10 == boardManagerVO.listSize}">selected="selected"</c:if>>10</option>
                                            <option value="20" <c:if test="${20 == boardManagerVO.listSize}">selected="selected"</c:if>>20</option>
                                            <option value="30" <c:if test="${30 == boardManagerVO.listSize}">selected="selected"</c:if>>30</option>
                                        </select>
                                    </div>
                                </div>
                                <%--<div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Date Of Birth <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input id="birthday" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text">
                                    </div>
                                </div>--%>
                                <div class="ln_solid"></div>
                                <div class="form-group">
                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                        <a href="${adminPath}/board/manager/list" class="btn btn-primary">취소</a>
                                        <button type="submit" class="btn btn-success">등록</button>
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    <c:if test="${flag ne null}">
    $(function(){
        <c:choose>
        <c:when test="${flag eq 'error'}">
        alert('다시 등록해 주세요.');
        </c:when>
        </c:choose>
    });
    </c:if>
</script>