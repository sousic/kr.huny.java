<%--
  Created by IntelliJ IDEA.
  User: dhjang
  Date: 2016-09-09
  Time: 오후 5:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="">
    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_panel">
                <div class="x_title">
                    <h2>로그인</h2>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <br />
                    <div class="x_content">
                        <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" method="post" action="/${adminPath}/login">

                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">아이디 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" id="first-name" required="required" class="form-control col-md-7 col-xs-12">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">암호 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" id="last-name" name="last-name" required="required" class="form-control col-md-7 col-xs-12">
                            </div>
                        </div>
                        <div class="ln_solid"></div>
                        <div class="form-group">
                            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                <button type="submit" class="btn btn-primary">로그인</button>
                                <button type="button" class="btn btn-default">취소</button>
                            </div>
                        </div>

                    </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
