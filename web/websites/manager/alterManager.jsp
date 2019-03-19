<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <title>修改信息</title>
    <script>
        function isEmpty(str) {
            return str === null || str === '';
        }
        function formCheck() {
            var userName = document.forms['modify']['manageName'].value;
            var userTel = document.forms['modify']['manageTel'].value;
            var userEmail = document.forms['modify']['manageEmail'].value;
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
<%@ include file="head.jsp" %>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                修改信息
            </h3>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-2 column">
        </div>
        <div class="col-md-8 column">
            <c:forEach items="${ManageList}" var="manager">
                <form class="form-horizontal" action="/servlet/ManagerServlet" method="post"
                      onsubmit="return formCheck();"
                      name="modify">
                    <input type="hidden" name="flag" value="alterManager"/>
                    <input type="hidden" name="manageId" value="${manager.manageId}"/>
                    <input type="hidden" name="manageid" value="${manager.manageId}"/>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <input class="form-control" type="text" name="manageName" value="${manager.manageName}"
                                   title="姓名"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10">
                            <select class="form-control" title="性别" name="manageSex">
                                <c:choose>
                                    <c:when test="${manager.manageSex == '男'}">
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
                            <input class="form-control" type="text" name="manageTel" value="${manager.manageTel}"
                                   title="电话"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">邮箱</label>
                        <div class="col-sm-10">
                            <input class="form-control" type="text" name="manageEmail" value="${manager.manageEmail}"
                                   title="邮箱"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">确定修改</button>
                            <br/><br/>
                            <span id="form"></span>
                        </div>
                    </div>
                </form>
            </c:forEach>
        </div>
        <div class="col-md-2 column">
        </div>
    </div>
</div>
</body>
</html>
