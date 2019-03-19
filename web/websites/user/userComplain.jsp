<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <title>用户反馈</title>
    <!-- js -->
</head>
<body>
<%@ include file="head.jsp" %>


<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                用户反馈
            </h3>
        </div>
    </div>
    <form class="form-horizontal" action="/servlet/UserComplainServlet" method="post">
        <input type="hidden" name="flag" value="adduserComplain"/>
        <input type="hidden" name="complainuserId" value="${userId}"/>
        <div class="row clearfix">
            <div class="col-md-2 column">
            </div>
            <div class="col-md-8 column">
                <div class="form-group">
                    <label class="col-sm-2 control-label">标题</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" name="complainTitle" title="标题"/>
                    </div>
                </div>
            </div>
            <div class="col-md-2 column">
            </div>
        </div>
        <div class="row clearfix">
            <div class="col-md-12 column">

                <div class="form-group">
                    <div class="col-sm-10">
                        <!-- 加载编辑器的容器 -->
                        <script id="container" name="complainContent" type="text/plain" style="width:1024px;height:500px">
                        </script>
                        <!-- 配置文件 -->
                        <script type="text/javascript" src="/ueditor.config.js"></script>
                        <!-- 编辑器源码文件 -->
                        <script type="text/javascript" src="/ueditor.all.js"></script>
                        <!-- 实例化编辑器 -->
                        <script type="text/javascript">
                            var editor = UE.getEditor('container');
                        </script>
                    </div>
                </div>
            </div>
        </div>
        <div class="row clearfix">
            <div class="col-md-4 column"></div>
            <div class="col-md-4 column">
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default form-control">确认提交</button>
                    </div>
                </div>
            </div>
            <div class="col-md-4 column"></div>
        </div>

    </form>
</div>
</body>
</html>