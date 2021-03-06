<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>管理员登录</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <script>
        function isEmpty(str) {
            return str === null || str === '';
        }
        function formCheck() {
            var manageId = document.forms['login']['manageId'].value;
            var password = document.forms['login']['password'].value;
            if (isEmpty(manageId)) {
                document.getElementById('form').setAttribute('class', 'list-group-item list-group-item-danger');
                document.getElementById('form').innerHTML = '请填写帐号';
                return false;
            }
            if (isEmpty(password)) {
                document.getElementById('wrong').setAttribute('class', '');
                document.getElementById('wrong').innerHTML = '';
                document.getElementById('form').setAttribute('class', 'list-group-item list-group-item-danger');
                document.getElementById('form').innerHTML = '请填写密码';
                return false;
            }
        }
    </script>
</head>
<body>


<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                管理员登录
            </h3>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-2 column">
        </div>
        <div class="col-md-8 column">
            <form class="form-horizontal" action="/servlet/LoginServlet" method="post" name="login"
                  onsubmit="return formCheck();">
                <div class="form-group">
                    <label class="col-sm-2 control-label">登录名</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" name="manageId" title="登录名"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="password" name="password" title="密码"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">登录</button>
                        <br/><br/>
                        <span id="form"></span>

                        <c:if test="${wrongmanager1=='yesloginwrong'}">
                            <span id="wrong" class="list-group-item list-group-item-danger">输入有误,请重新输入!</span>
                        </c:if>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-2 column">
        </div>
    </div>
</div>
</body>
</html>