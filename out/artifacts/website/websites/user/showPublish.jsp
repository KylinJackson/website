<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <title>showPublish</title>
</head>
<body>
<%@ include file="head.jsp" %>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                ${publish.publishTitle}
            </h3>
            <p>${publish.publishTime}</p>
            <p>${publish.publishContent}</p>
        </div>
    </div>
</div>
</body>
</html>