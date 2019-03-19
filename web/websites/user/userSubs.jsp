<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>我的订阅</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="head.jsp" %>
<div class="container">
    <c:if test="${sub1}">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <h3>
                    政策法规
                </h3>
                <hr/>
            </div>
        </div>
        <div class="row clearfix">
            <div class="col-md-8 column">
                <c:forEach items="${pub1}" var="pub1">
                    <a href="/servlet/UserLinkServlet?publishId=${pub1.publishId}&userId=${userId}">${pub1.publishTitle}</a>
                    <br/>
                    <hr/>
                </c:forEach>
            </div>
            <div class="col-md-4 column">
                <button type="button" class="btn btn-default"
                        onclick="window.location.href='/servlet/UserSubsServlet?action=cancel&type=1&userId=${userId}'">
                    取消订阅
                </button>
            </div>
        </div>
    </c:if>

    <c:if test="${sub2}">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <h3>
                    便民服务
                </h3>
                <hr/>
            </div>
        </div>
        <div class="row clearfix">
            <div class="col-md-8 column">
                <c:forEach items="${pub2}" var="pub2">
                    <a href="/servlet/UserLinkServlet?publishId=${pub2.publishId}&userId=${userId}">${pub2.publishTitle}</a>
                    <br/>
                    <hr/>
                </c:forEach>
            </div>
            <div class="col-md-4 column">
                <button type="button" class="btn btn-default"
                        onclick="window.location.href='/servlet/UserSubsServlet?action=cancel&type=2&userId=${userId}'">
                    取消订阅
                </button>
            </div>
        </div>
    </c:if>

    <c:if test="${sub3}">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <h3>
                    基层公开
                </h3>
                <hr/>
            </div>
        </div>
        <div class="row clearfix">
            <div class="col-md-8 column">
                <c:forEach items="${pub3}" var="pub3">
                    <a href="/servlet/UserLinkServlet?publishId=${pub3.publishId}&userId=${userId}">${pub3.publishTitle}</a>
                    <br/>
                    <hr/>
                </c:forEach>
            </div>
            <div class="col-md-4 column">
                <button type="button" class="btn btn-default"
                        onclick="window.location.href='/servlet/UserSubsServlet?action=cancel&type=3&userId=${userId}'">
                    取消订阅
                </button>
            </div>
        </div>
    </c:if>
    <c:if test="${sub4}">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <h3>
                    服务发展
                </h3>
                <hr/>
            </div>
        </div>
        <div class="row clearfix">
            <div class="col-md-8 column">
                <c:forEach items="${pub4}" var="pub4">
                    <a href="/servlet/UserLinkServlet?publishId=${pub4.publishId}&userId=${userId}">${pub4.publishTitle}</a>
                    <br/>
                    <hr/>
                </c:forEach>
            </div>
            <div class="col-md-4 column">
                <button type="button" class="btn btn-default"
                        onclick="window.location.href='/servlet/UserSubsServlet?action=cancel&type=4&userId=${userId}'">
                    取消订阅
                </button>
            </div>
        </div>
    </c:if>
</div>
</body>
</html>