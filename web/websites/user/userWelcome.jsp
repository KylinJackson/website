<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <title>首页</title>
</head>
<body>
<%@include file="head.jsp" %>


<div class="container">

    <div class="row clearfix">
        <div class="col-md-6 column">
            <div class="alert alert-success alert-dismissable">
                <h4>
                    <a href="/servlet/UserTypeServlet?flag=Type&type=1&userId=${userId}">政策法规</a>
                    &nbsp;<c:if test="${!sub1}"><a href="/servlet/UserSubsServlet?action=subs&type=1&userId=${userId}">订阅</a></c:if>
                </h4>
            </div>
            <c:forEach items="${pub1}" var="pub1" begin="0" end="3">
                <p>
                    <a href="/servlet/UserLinkServlet?publishId=${pub1.publishId}&userId=${userId}">${pub1.publishTitle}</a>
                </p>
            </c:forEach>
        </div>
        <div class="col-md-6 column">
            <div class="alert alert-success alert-dismissable">
                <h4>
                    <a href="/servlet/UserTypeServlet?flag=Type&type=2&userId=${userId}">便民服务</a>
                    &nbsp;<c:if test="${!sub2}"><a href="/servlet/UserSubsServlet?action=subs&type=2&userId=${userId}">订阅</a></c:if>
                </h4>
            </div>
            <c:forEach items="${pub2}" var="pub2" begin="0" end="3">
                <p>
                    <a href="/servlet/UserLinkServlet?publishId=${pub2.publishId}&userId=${userId}">${pub2.publishTitle}</a>
                </p>
            </c:forEach>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-6 column">
            <div class="alert alert-success alert-dismissable">
                <h4>
                    <a href="/servlet/UserTypeServlet?flag=Type&type=2&userId=${userId}">基层公开</a>
                    &nbsp;<c:if test="${!sub3}"><a href="/servlet/UserSubsServlet?action=subs&type=3&userId=${userId}">订阅</a></c:if>
                </h4>
            </div>
            <c:forEach items="${pub3}" var="pub3" begin="0" end="3">
                <p>
                    <a href="/servlet/UserLinkServlet?publishId=${pub3.publishId}&userId=${userId}">${pub3.publishTitle}</a>
                </p>
            </c:forEach>
        </div>
        <div class="col-md-6 column">
            <div class="alert alert-success alert-dismissable">
                <h4>
                    <a href="/servlet/UserTypeServlet?flag=Type&type=4&userId=${userId}">服务发展</a>
                    &nbsp;<c:if test="${!sub4}"><a href="/servlet/UserSubsServlet?action=subs&type=4&userId=${userId}">订阅</a></c:if>
                </h4>
            </div>
            <c:forEach items="${pub4}" var="pub4" begin="0" end="3">
                <p>
                    <a href="/servlet/UserLinkServlet?publishId=${pub4.publishId}&userId=${userId}">${pub4.publishTitle}</a>
                </p>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>