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
    <script>
        function isEmpty(str) {
            return str === null || str === '';
        }
        function formCheck() {
            var previous = document.forms['password']['previous'].value;
            var new1 = document.forms['password']['new1'].value;
            var new2 = document.forms['password']['new2'].value;
            if (isEmpty(previous)) {
                document.getElementById('form').setAttribute('class', 'list-group-item list-group-item-danger');
                document.getElementById('form').innerHTML = '请填写原密码';
                return false;
            }
            if (isEmpty(new1)) {
                document.getElementById('form').setAttribute('class', 'list-group-item list-group-item-danger');
                document.getElementById('form').innerHTML = '请填写新密码';
                return false;
            }
            if (isEmpty(new2)) {
                document.getElementById('form').setAttribute('class', 'list-group-item list-group-item-danger');
                document.getElementById('form').innerHTML = '请再次填写新密码';
                return false;
            }
            else if (new1 !== new2) {
                document.getElementById('wrong').setAttribute('class', '');
                document.getElementById('wrong').innerHTML = '';
                document.getElementById('form').setAttribute('class', 'list-group-item list-group-item-danger');
                document.getElementById('form').innerHTML = '两次输入密码不一致';
                return false;
            }
        }
    </script>
</head>
<body>

<%@ include file="head.jsp" %>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                修改密码
            </h3>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-2 column">
        </div>
        <div class="col-md-8 column">
            <form class="form-horizontal" action="/servlet/ManagerServlet" method="post" onsubmit="return formCheck();"
                  name="password">
                <input type="hidden" name="managerId" value="${managerId}"/>
                <input type="hidden" name="flag" value="alterPassword2"/>
                <div class="form-group">
                    <label class="col-sm-2 control-label">原密码</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="password" name="previous" title="原密码"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">新密码</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="password" name="new1" title="新密码"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">再次输入</label>
                    <div class="col-sm-10">

                        <input class="form-control" type="password" name="new2" title="再次输入"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">确认修改</button>
                        <br/><br/>
                        <span id="form"></span>
                        <c:if test="${wrongmanager=='yes'}">
                            <span id="wrong" class="list-group-item list-group-item-danger">原密码输入错误</span>
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