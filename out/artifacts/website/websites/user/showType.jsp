<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>修改密码</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="head.jsp" %>


<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                <c:if test="${type == 1}">
                    政策法规
                </c:if>
                <c:if test="${type == 2}">
                    便民服务
                </c:if>
                <c:if test="${type == 3}">
                    基层公开
                </c:if>
                <c:if test="${type == 4}">
                    服务发展
                </c:if>
            </h3>
            <c:forEach items="${publishList}" var="publish">
                <p>
                    <hr />
                    <a href="/servlet/UserLinkServlet?publishId=${publish.publishId}&userId=${userId}">${publish.publishTitle}</a>
                </p>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>