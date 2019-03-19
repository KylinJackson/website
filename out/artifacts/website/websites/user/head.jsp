<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <img src="../../img/123.png">
        </div>
    </div>
    <br/><br/>
    <div class="row clearfix">
        <div class="col-md-8 column">
        </div>
        <div class="col-md-2 column">
            <div class="btn-group">
                <button class="btn btn-default">${userId}</button>
                <button data-toggle="dropdown" class="btn btn-default dropdown-toggle"><span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li>
                        <a href="/servlet/UserAlterServlet?flag=alteruser&userId=${userId}">修改个人资料</a>
                    </li>
                    <li>
                        <a href="/servlet/UserAlterServlet?flag=alterpassword&userId=${userId}">修改密码</a>
                    </li>
                    <li class="divider">
                    </li>
                    <li>
                        <a href="/servlet/UserSubsServlet?action=mySubs&userId=${userId}">我的订阅</a>
                    </li>
                    <li>
                        <a href="/servlet/UserComplainServlet?flag=complain&userId=${userId}">投诉反馈</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-md-2 column">
            <%
                String wrong1 = "no";
                HttpSession session1 = request.getSession(true);
                session.setAttribute("wrong1", wrong1);
            %>
            <button type="button" class="btn btn-default btn-danger"
                    onclick="window.location.href='/servlet/UserLogoutServlet?userId=${userId}'">退出
            </button>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="btn-group">
                <button class="btn btn-default" type="button"
                        onclick="window.location.href='/servlet/UserLARServlet?userId=${userId}'"><em
                        class="glyphicon"></em>首页
                </button>
                <button class="btn btn-default" type="button"
                        onclick="window.location.href='/servlet/UserTypeServlet?flag=Type&type=1&userId=${userId}'"><em
                        class="glyphicon"></em>政策法规
                </button>
                <button class="btn btn-default" type="button"
                        onclick="window.location.href='/servlet/UserTypeServlet?flag=Type&type=2&userId=${userId}'"><em
                        class="glyphicon"></em> 便民服务
                </button>
                <button class="btn btn-default" type="button"
                        onclick="window.location.href='/servlet/UserTypeServlet?flag=Type&type=3&userId=${userId}'"><em
                        class="glyphicon"></em> 基层公开
                </button>
                <button class="btn btn-default" type="button"
                        onclick="window.location.href='/servlet/UserTypeServlet?flag=Type&type=4&userId=${userId}'"><em
                        class="glyphicon"></em> 服务发展
                </button>
            </div>
        </div>
    </div>
    <br/><br/>
</div>
