<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<div class="">
    <div class="page-title">
        <div class="title_left">
            <h3>${boardTitle} 관리 <small>게시판 목록</small></h3>
        </div>
    </div>

    <div class="clearfix"></div>

    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_panel">
                <div class="x_title">
                    <h2>${boardTitle} 보기<small></small></h2>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                        <%--DataTables has most features enabled by default, so all you need to do to use it with your own tables is to call the construction function: <code>$().DataTable();</code>--%>
                    </p>
                    <div class="row">
                        <div class="x_content">
                            <br />
                            <form id="sForm" data-parsley-validate class="form-horizontal form-label-left" method="post" action="${adminPath}/board/articles/create">
                                <input type="hidden" id="bm_seq" name="bm_seq" value="${bm_seq}"/>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">제목 <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        ${articlesVO.title}
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">공지유무</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <c:choose>
                                            <c:when test="${false == articlesVO.isNotice}">일반글</c:when>
                                            <c:when test="${true == articlesVO.isNotice}">공지글</c:when>
                                        </c:choose>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">댓글유무</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <c:choose>
                                            <c:when test="${false == articlesVO.isComment}">가능</c:when>
                                            <c:when test="${true == articlesVO.isComment}">불가능</c:when>
                                        </c:choose>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">내용 <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        ${articlesVO.contents}
                                    </div>
                                </div>
                                <div class="ln_solid"></div>
                                <div class="form-group">
                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                        <a href="${adminPath}/board/articles/list?bm_seq=${bm_seq}" class="btn btn-default">목록</a>
                                        <button type="button" id="btnDelete" class="btn btn-danger">삭제</button>
                                        <a href="${adminPath}/board/articles/modify?bm_seq=${bm_seq}&seq=${articlesVO.seq}" class="btn btn-primary">수정</a>
                                    </div>
                                </div>

                            </form>
                            <form id="aForm" method="post">
                                <input type="hidden" id="seq" name="seq" value="${articlesVO.seq}"/>
                                <input type="hidden" id="bm_seq" name="bm_seq" value="${articlesVO.bm_seq}"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(function(){
        $('#summernote').summernote({
            height: 300,                 // set editor height
            minHeight: 300,             // set minimum height of editor
            maxHeight: 500,
            lang:'ko-KR',
            placeholder:''
        });

        <c:if test="${flag ne null}">
            <c:choose>
            <c:when test="${flag eq 'error'}">
            alert('다시 등록해 주세요.');
            </c:when>
            </c:choose>
        </c:if>

        $("#btnDelete").on("click", function() {
            if(!confirm("삭제하시겠습니까?")) {
                return false;
            } else {
                $("#aForm").attr("action","${adminPath}/board/articles/delete").submit();
            }
        });
    });

    function ChkFrm()
    {
        $("#contents").val($("#summernote").summernote('code'));
    }

</script>