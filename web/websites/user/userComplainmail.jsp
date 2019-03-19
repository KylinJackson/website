<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <link href="../../css/bootstrap.min.css" rel="stylesheet" />
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <title>信箱页面</title>
</head>
<body>
<%@ include file="head.jsp"%>


<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                我的信箱
            </h3>
        </div>
    </div>
    <div class="row clearfix">
        <br/><br/>
        <div class="col-md-4 column text-center">
            <img alt="140x140" src="../../img/complain.png" class="img-circle" onclick="window.location.href='/servlet/UserComplainServlet?flag=complainMail&userId=${userId}'" />
        </div>
        <div class="col-md-4 column text-center">
            <img alt="140x140" src="../../img/send.png" class="img-circle" onclick="window.location.href='/servlet/UserComplainServlet?flag=sent&userId=${userId}'" />
        </div>
        <div class="col-md-4 column text-center">
            <img alt="140x140" src="../../img/receive.png" class="img-circle" onclick="window.location.href='/servlet/UserComplainServlet?flag=reply&userId=${userId}'" />
        </div>
    </div>
</div>
</body>
</html>
