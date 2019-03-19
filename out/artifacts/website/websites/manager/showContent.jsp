<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <title>内容展示</title>
</head>
<body>
<%@ include file="head.jsp" %>
<div class="container">
    <c:forEach items="${PublishList}" var="Publish">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <h3 class="text-center">
                        ${Publish.publishTitle}
                </h3>
                <p>${Publish.publishTime}</p>
                <p>
                        ${Publish.publishContent}
                </p>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>