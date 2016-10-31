<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <div class="container-fluid">
        <div class="row">
            <div class="page-title">
                <div class="page-header">
                    <h3>${boardTitle} 관리 <small>게시판 목록</small></h3>
                </div>
            </div>
        </div>
        <div class="boardWrapper">
            <form id="sForm" data-parsley-validate class="form-horizontal form-label-left" method="post" action="${adminPath}/board/articles/create" onsubmit="return ChkFrm();">
                <input type="hidden" id="bm_seq" name="bm_seq" value="${bm_seq}"/>
                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="title">제목 <span class="required">*</span>
                    </label>
                    <div class="col-md-9 col-sm-6 col-xs-12">
                        <input type="text" id="title" name="title" required="required" class="form-control col-md-7 col-xs-12" value="${articlesVO.title}" data-parsley-length="[4,150]">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12">공지유무</label>
                    <div class="col-md-9 col-sm-6 col-xs-12">
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
                    <div class="col-md-9 col-sm-6 col-xs-12">
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
                    <div class="col-md-9 col-sm-6 col-xs-12">
                        <div id="summernote">${articlesVO.contents}</div>
                        <input type="hidden" id="contents" name="contents" required="required" class="form-control col-md-7 col-xs-12" value="">
                    </div>
                </div>
                <div class="ln_solid"></div>
                <div class="form-group">
                    <div class="col-md-9 col-sm-6 col-xs-12 col-md-offset-3 text-center">
                        <a href="${adminPath}/board/articles/list?bm_seq=${bm_seq}" class="btn btn-primary">취소</a>
                        <button type="submit" class="btn btn-success">등록</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    $(function(){
        $('#summernote').summernote({
            height: 350,                 // set editor height
            minHeight: 350,             // set minimum height of editor
            maxHeight: 500,
            lang:'ko-KR',
            callbacks: {
                onImageUpload: function (files) {
                    sendFile(files[0], this);
                }
            }
        });

        var index = 0;
        function sendFile(file, editor) {
            var data = new FormData();
            data.append("uploadFile", file);
            data.append("bm_seq", ${bm_seq});
            data.append("a_seq", 0);
            $.ajax({
                data:data,
                type:"POST",
                url : "/attach/upload",
                cache:false,
                contentType : false,
                processData: false,
                success:function (result) {
                    if(result.resultCode == 1) {
                        $(editor).summernote('editor.insertImage', result.url);
                        $("#sForm").append("<input type='hidden' name='attachments[" + index + "].seq' value='"+ result.f_seq + "'/>");
                        index++;
                    }
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