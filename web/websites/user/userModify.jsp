<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>修改个人信息</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <script>
        function isEmpty(str) {
            return str === null || str === '';
        }
        function formCheck() {
            var userName = document.forms['modify']['userName'].value;
            var userTel = document.forms['modify']['userTel'].value;
            var userEmail = document.forms['modify']['userEmail'].value;
            if (isEmpty(userName)) {
                document.getElementById('form').setAttribute('class', 'list-group-item list-group-item-danger');
                document.getElementById('form').innerHTML = '请填写用户名';
                return false;
            }
            if (isEmpty(userTel)) {
                document.getElementById('form').setAttribute('class', 'list-group-item list-group-item-danger');
                document.getElementById('form').innerHTML = '请填写电话';
                return false;
            }
            if (isEmpty(userEmail)) {
                document.getElementById('form').setAttribute('class', 'list-group-item list-group-item-danger');
                document.getElementById('form').innerHTML = '请填写电子邮件';
                return false;
            }
        }
    </script>
</head>
<body>
<%@include file="head.jsp" %>


<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                修改个人信息
            </h3>
        </div>
    </div>
    <c:forEach items="${UserList}" var="user">
        <div class="row clearfix">
            <div class="col-md-2 column">
            </div>
            <div class="col-md-8 column">
                <form class="form-horizontal" action="/servlet/UserAlterServlet?userId=${user.userId}"
                      method="post" onsubmit="return formCheck();" name="modify">
                    <input type="hidden" name="flag" value="alteruser"/>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="userName" title="用户名"
                                   value="${user.userName}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10">
                            <select class="form-control" title="性别" name="userSex">
                                <c:choose>
                                    <c:when test="${user.userSex == '男'}">
                                        <option value="男" selected="selected">男</option>
                                        <option value="女">女</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="男">男</option>
                                        <option value="女" selected="selected">女</option>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">电话</label>
                        <div class="col-sm-10">
                            <input class="form-control" type="text" name="userTel" title="电话" value="${user.userTel}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">电子邮件</label>
                        <div class="col-sm-10">
                            <input class="form-control" type="text" name="userEmail" title="电子邮件"
                                   value="${user.userEmail}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">确认修改</button>
                            <br/><br/>
                            <span id="form"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-md-2 column">
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>

