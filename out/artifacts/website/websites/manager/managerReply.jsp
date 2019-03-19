<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <title>投诉反馈</title>
</head>
<body>
<%@ include file="head.jsp" %>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                投诉反馈
            </h3>
        </div>
    </div>
    <div class="row clearfix">
        <br/><br/>
        <div class="col-md-6 column text-center">
            <img alt="140x140" src="../../img/send.png" class="img-circle" onclick="window.location.href='/servlet/ManagerReplyServlet?flag=reply'" />
        </div>
        <div class="col-md-6 column text-center">
            <img alt="140x140" src="../../img/receive.png" class="img-circle" onclick="window.location.href='/servlet/ManagerReplyServlet?flag=receive'" />
        </div>
    </div>
</div>
</body>
</html>
