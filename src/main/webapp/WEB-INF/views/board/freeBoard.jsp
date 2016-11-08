<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title><spring:message code="title"/> > <spring:message code="title.board.free"/></title>
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
        <div class="row">
            <!-- content -->
            <div class="col-md-5 col-md-offset-4">

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

</body>
</html>