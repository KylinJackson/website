<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>用户注册</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet" />
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <script>
        function isEmpty (str) {
            return str === null || str === '' || str === '0';
        }
        function formCheck() {
            var userId = document.forms['register']['userId'].value;
            var userName = document.forms['register']['userName'].value;
            var password1 = document.forms['register']['password1'].value;
            var password2 = document.forms['register']['password2'].value;
            var userSex = document.forms['register']['userSex'].value;
            var userTel = document.forms['register']['userTel'].value;
            var userEmail = document.forms['register']['userEmail'].value;
            if (isEmpty(userId)) {
                document.getElementById('form').setAttribute('class', 'list-group-item list-group-item-danger');
                document.getElementById('form').innerHTML = '请填写账号';
                return false;
            }
            if (isEmpty(userName)) {
                document.getElementById('form').setAttribute('class', 'list-group-item list-group-item-danger');
                document.getElementById('form').innerHTML = '请填写用户名';
                return false;
            }
            if (isEmpty(password1)) {
                document.getElementById('form').setAttribute('class', 'list-group-item list-group-item-danger');
                document.getElementById('form').innerHTML = '请填写密码';
                return false;
            }
            if (isEmpty(password2)) {
                document.getElementById('form').setAttribute('class', 'list-group-item list-group-item-danger');
                document.getElementById('form').innerHTML = '请再次填写密码';
                return false;
            } else if (password1 !== password2) {
                document.getElementById('form').setAttribute('class', 'list-group-item list-group-item-danger');
                document.getElementById('form').innerHTML = '两次填写不一致';
                return false;
            }
            if (isEmpty(userSex)) {
                document.getElementById('form').setAttribute('class', 'list-group-item list-group-item-danger');
                document.getElementById('form').innerHTML = '请选择性别';
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
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                用户注册
            </h3>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-2 column">
        </div>
        <div class="col-md-8 column">
            <form class="form-horizontal" action="/servlet/UserLARServlet" method="post" onsubmit="return formCheck();" name="register">
                <input type="hidden" name="flag" value="UserRegister"/>
                <div class="form-group">
                    <label class="col-sm-2 control-label">账号</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" name="userId" title="账号" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" name="userName" title="用户名" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="password1" title="密码" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">再次输入</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="password2" title="再次输入" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-10">
                        <select class="form-control" title="性别" name="userSex">
                            <option value="0">请选择性别</option>
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">电话</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" name="userTel" title="电话" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">电子邮件</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" name="userEmail" title="电子邮件" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">注册</button>
                        <br /><br />
                        <span id="form"></span>
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