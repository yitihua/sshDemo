<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
    <link rel="stylesheet" href="${ctx}/static/css/index.css"/>
    <script src="${ctx}/static/js/indexStart.js" ></script>
</head>
<body>
<div class="container">
    <div class="forms">
        <h1>数字字典管理</h1>
        </div>
        <table cellspacing="0" cellpadding="0">
            <tr><td colspan="5">数据字典表</td></tr>
            <tr>
                <td colspan="5">
                    <input type="button" value="删除" id="delectall" class="btn-red">
                    <input type="button" value="全选" id="selectall" class="btn-white">
                </td>
            </tr>
            <%--列表名：dictList
                遍历数组名：dict
            --%>
            <c:forEach var="dict" items="${dictList}" varStatus="thedict">
                <tr>
                    <td>
                        <input type="checkbox" value="signldict" class="checkbox">
                    </td>
                    <td>${thedict.name}</td>
                    <td>${thedict.status}</td>
                    <td>${thedict.code}</td>
                    <td>
                        <input type="button" value="delect" class="delect" flag = ${thedic.id}>
                        <input type="button" value="edit" class="edit" flag = ${thedic.id}>
                    </td>
                </tr>
            </c:forEach>
            <!-- <tr>
                    <td>
                        <input type="checkbox" value="signldict" class="checkbox">
                    </td>
                    <td>${dict.name}</td>
                    <td>${dict.status}</td>
                    <td>${dict.code}</td>
                    <td>
                        <input type="button" value="delect" class="delect">
                        <input type="button" value="edit" class="edit">
                    </td>
                </tr> -->
        </table>
    </div>


<script>
    <%--全选功能--%>
    var selFlag = true;
    var selAllBtn = document.querySelector("#selectall")
    selAllBtn.onclick=function () {
        let selectlist = document.getElementsByClassName("checkbox")
        if(selFlag){
            for(let i = 0;i<selectlist.length;i++){
                selectlist[i].checked = true
                selAllBtn.value  = "取消"
                selFlag = false
            }
        }
        else{
            for(let i = 0;i<selectlist.length;i++){
                selectlist[i].checked = false
                selAllBtn.value  = "全选"
                selFlag = true
            }
        }
    }

</script>
</body>
</html>
