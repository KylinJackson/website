<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <title>信息展示</title>
</head>
<body>
<%@ include file="head.jsp" %>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12">
            <c:forEach items="${PublishList}" var="Publish">
                <p>
                    <a href="/servlet/ShowInformationServlet?num=${Publish.publishId}">${Publish.publishTitle}</a>
                </p>
                <hr/>
            </c:forEach>
        </div>
    </div>
</div>

</body>
</html>