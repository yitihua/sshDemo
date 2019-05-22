<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加新闻</title>
    <style type="text/css">
        .container{
            margin: 60px 200px;
        }
    </style>
<body>

<div class="container">
    <h1>数据字典编辑</h1>

    <form action="${ctx}/dict/create" method="post">
        <table border="0" id="table">

            <table>
                <tr>
                <td >编号</td> <td><input type="text" name="code" value=""></td>
                </tr>
                <tr>
                    <td>名称</td> <td><input type="text" name="name" value=""></td>
                </tr>
                <tr>
                    <td>类型</td> <td><input type="text" name="type" value=""></td>
                </tr>
            </table>

            <input type="submit" value="发 布">

        </table>
    </form>
<script>
    if("${message}"){alert("message"+"${message}")}



</script>
</div>
</body>
</html>