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
                    <th>
                        操作
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ComplainList}" var="complain" varStatus="status">
                    <tr>
                        <td>
                                ${status.count}
                        </td>
                        <td>
                                ${complain.complainuserId}
                        </td>
                        <td>
                            <a href="/servlet/ManagerReplyServlet?flag=showcomplain&complainId=${complain.complainId}">${complain.complainTitle}</a>
                        </td>
                        <td>
                            <a href="/websites/manager/managerwriteReply.jsp?complainid=${complain.complainId}&complainuserId=${complain.complainuserId}">回复</a>
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