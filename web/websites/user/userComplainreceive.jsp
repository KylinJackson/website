<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <title>收件箱</title>
</head>
<body>

<%@ include file="head.jsp" %>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                收件箱
            </h3>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>
                        序号
                    </th>
                    <th>
                        用户ID
                    </th>
                    <th>
                        标题
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ReplyList}" var="reply" varStatus="status">
                    <tr>
                        <td>
                                ${status.count}
                        </td>
                        <td>
                                ${reply.replyuserId}
                        </td>
                        <td>
                            <a href="/servlet/UserComplainServlet?flag=showreply&replyId=${reply.replyId}">${reply.replyTitle}</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>