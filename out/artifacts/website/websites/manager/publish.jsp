<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>发布信息</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet"/>
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <script>
        function isEmpty(str) {
            return str === null || str === '' || str === '0';
        }
        function formCheck() {
            var content = document.forms['publish']['content'].value;
            var type = document.forms['publish']['type'].value;
            var title = document.forms['publish']['title'].value;
            if (isEmpty(title)) {
                document.getElementById('form').setAttribute('class', 'list-group-item list-group-item-danger');
                document.getElementById('form').innerHTML = '请填写标题';
                return false;
            }
            if (isEmpty(content)) {
                document.getElementById('form').setAttribute('class', 'list-group-item list-group-item-danger');
                document.getElementById('form').innerHTML = '请填写要发布的信息';
                return false;
            }
            if (isEmpty(type)) {
                document.getElementById('form').setAttribute('class', 'list-group-item list-group-item-danger');
                document.getElementById('form').innerHTML = '请选择发布信息的类别';
                return false;
            }
        }
    </script>
</head>
<body>
<%@ include file="head.jsp" %>
<%String manageid = request.getParameter("manageid");%>


<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                发布信息
            </h3>
        </div>
    </div>
    <form class="form-horizontal" name="publish" action="/servlet/MServlet?manageid=<%=manageid%>" method="post"
          onsubmit="return formCheck();">
        <div class="row clearfix">
            <div class="col-md-2 column">
            </div>
            <div class="col-md-8 column">

                <div class="form-group">
                    <label class="col-sm-2 control-label">标题</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="title" title="标题"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">类别</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="type" title="类别">
                            <option value="0">请选择类别</option>
                            <option value="1">政策法规</option>
                            <option value="2">基层公开</option>
                            <option value="3">便民服务</option>
                            <option value="4">服务发展</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-md-2 column">
            </div>
        </div>
        <div class="row clearfix">
            <div class="col-md-12">
                <div class="form-group">
                    <!--
                    <textarea rows="20" class="form-control" name="content" title="编写信息"></textarea>
                    -->
                    <!-- 加载编辑器的容器 -->
                    <script id="container" name="content" type="text/plain" style="width:1024px;height:500px">
                    </script>
                    <!-- 配置文件 -->
                    <script type = "text/javascript" src = "/ueditor.config.js" ></script>
                    <!-- 编辑器源码文件 -->
                    <script type="text/javascript" src="/ueditor.all.js"></script>
                    <!-- 实例化编辑器 -->
                    <script type="text/javascript">
                        var editor = UE.getEditor('container');
                    </script>
                </div>
            </div>
        </div>
        <div class="row clearfix">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default form-control">发布</button>
                        <br/><br/>
                        <span id="form"></span>
                    </div>
                </div>
            </div>
            <div class="col-md-4"></div>
        </div>
    </form>
</div>
</body>
</html>