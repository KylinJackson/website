<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="javax.servlet.http.HttpSession" %>
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
                <button class="btn btn-default">${manageid}</button>
                <button data-toggle="dropdown" class="btn btn-default dropdown-toggle"><span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li>
                        <a href="/servlet/ManagerServlet?flag=showAllManagers&manageid=${manageid}">修改个人资料</a>
                    </li>
                    <li>
                        <a href="/servlet/ManagerServlet?flag=alterPassword&manageid=${manageid}">修改密码</a>
                    </li>
                    <li class="divider">
                    </li>
                    <li>
                        <a href="/websites/manager/publish.jsp?manageid=${manageid}">发布信息</a>
                    </li>
                    <li>
                        <a href="/servlet/UserServlet?flag=showAllUsers">用户档案</a>
                    </li>
                    <li>
                        <a href="/websites/manager/managerReply.jsp">投诉反馈</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-md-2 column">
            <button type="button" class="btn btn-default btn-danger"
                    <%
                        String loginwrong = "nologinwrong";
                        HttpSession session1 = request.getSession(true);
                        session.setAttribute("wrongmanager1", loginwrong);
                    %>
                    onclick="window.location.href='/websites/manager/managerLogin.jsp'">退出
            </button>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-2 column">
        </div>

        <div class="col-md-8 column">
            <div class="btn-group">
                <button class="btn btn-default" type="button"
                        onclick="window.location.href='/websites/manager/managerWelcome.jsp'"><em
                        class="glyphicon"></em>首页
                </button>
                <button class="btn btn-default" type="button"
                        onclick="window.location.href='/servlet/InformationServlet?flag=1'"><em class="glyphicon"></em>政策法规
                </button>
                <button class="btn btn-default" type="button"
                        onclick="window.location.href='/servlet/InformationServlet?flag=3'"><em class="glyphicon"></em>
                    便民服务
                </button>
                <button class="btn btn-default" type="button"
                        onclick="window.location.href='/servlet/InformationServlet?flag=2'"><em class="glyphicon"></em>
                    基层公开
                </button>
                <button class="btn btn-default" type="button"
                        onclick="window.location.href='/servlet/InformationServlet?flag=4'"><em class="glyphicon"></em>
                    服务发展
                </button>
            </div>
        </div>
    </div>
    <br/><br/>
</div>