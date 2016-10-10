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
                    <h2>${boardTitle} 수정<small></small></h2>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                        <%--DataTables has most features enabled by default, so all you need to do to use it with your own tables is to call the construction function: <code>$().DataTable();</code>--%>
                    </p>
                    <div class="row">
                        <div class="x_content">
                            <br />
                            <form id="sForm" data-parsley-validate class="form-horizontal form-label-left" method="post" action="${adminPath}/board/articles/modify" onsubmit="return ChkFrm();">
                                <input type="hidden" id="seq" name="seq" value="${articlesVO.seq}"/>
                                <input type="hidden" id="bm_seq" name="bm_seq" value="${articlesVO.bm_seq}"/>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="title">제목 <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="title" name="title" required="required" class="form-control col-md-7 col-xs-12" value="${articlesVO.title}" data-parsley-length="[4,150]">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">공지유무</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <div class="radio">
                                            <label>
                                                <input type="radio" class="flat" name="isNotice" id="isNotice0" value="0"  required <c:if test="${false == articlesVO.isNotice}">checked=""</c:if>/> 일반</label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" class="flat" name="isNotice" id="isNotice1" value="1" <c:if test="${true == articlesVO.isNotice}">checked=""</c:if>/> 공지
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">댓글유무</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <div class="radio">
                                            <label>
                                                <input type="radio" class="flat" name="isComment" id="isComment0" value="0"  <c:if test="${false == articlesVO.isComment}">checked=""</c:if> required/> 사용
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" class="flat" name="isComment" id="isComment1" value="1" <c:if test="${true == articlesVO.isComment}">checked=""</c:if>/> 미사용
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="contents">내용 <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <div id="summernote">${articlesVO.contents}</div>
                                        <input type="hidden" id="contents" name="contents" required="required" class="form-control col-md-7 col-xs-12" value="">
                                    </div>
                                </div>
                                <div class="ln_solid"></div>
                                <div class="form-group">
                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                        <a href="${adminPath}/board/articles/list?bm_seq=${bm_seq}" class="btn btn-primary">취소</a>
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
    $(function(){
        $('#summernote').summernote({
            height: 300,                 // set editor height
            minHeight: 300,             // set minimum height of editor
            maxHeight: 500,
            lang:'ko-KR',
            callbacks: {
                onImageUpload: function (files) {
                    sendFile(files[0], this);
                }
            }
        });

        function sendFile(file, editor) {
            var data = new FormData();
            data.append("uploadFile", file);
            $.ajax({
                data:data,
                type:"POST",
                url : "${adminPath}/board/articles/uploadImage",
                cache:false,
                contentType : false,
                processData: false,
                success:function (result) {
                    console.log(result.url);
                    $(editor).summernote('editor.insertImage', result.url);
                }
            });
        }

        <c:if test="${flag ne null}">
        <c:choose>
        <c:when test="${flag eq 'error'}">
        alert('다시 등록해 주세요.');
        </c:when>
        </c:choose>
        </c:if>
    });

    function ChkFrm()
    {
        $("#contents").val($("#summernote").summernote('code'));
    }

</script>