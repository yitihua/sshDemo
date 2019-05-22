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
                   <%-- <input type="button" value="删除" id="delectall" class="btn-red">--%>
                    <%--<input type="button" value="全选" id="selectall" class="btn-white">--%>
                    <input type="button" value="新增" id ="add" class="btn-white" style="float: right">
                </td>
            </tr>
            <%--列表名：dictList
                遍历数组名：dict
            --%>
            <c:forEach var="dict" items="${dictList}">
                <tr>
                    <%--<td>--%>
                        <%--<input type="checkbox" value="signldict" class="checkbox">--%>
                    <%--</td>--%>
                    <%--<td class="sort" name = "${dict.sort}"></td>--%>
                    <td>${dict.name}</td>
                    <td>${dict.status}</td>
                    <td>${dict.code}</td>
                    <td>
                        <input type="button" value="delete" class="delete" name="${dict.id}">
                        <input type="button" value="edit" class="edit" name="${dict.id}">
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
    if("${message}"){alert("message"+"${message}")}
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
    var addBtn = document.getElementById("add")
    add.onclick = function(){
        window.location.href=' dict'
    }
//    删除单个文件
    var delBtns = document.getElementsByClassName("delete")
    for(let i = 0;i<delBtns.length;i++){
        delBtns[i].onclick = function () {
            let name = this.getAttribute("name")
            window.location.href="${ctx}"+"/dict/delete/"+name

        }
    }
    var editBtns = document.getElementsByClassName("edit")
    for(let i = 0;i<editBtns.length;i++){
        delBtns[i].onclick = function () {
            let name = this.getAttribute("name")
            window.location.href="${ctx}"+"/dict/update/"+name

        }
    }
    //sort处理
    var sort = document.getElementsByClassName("sort")
    for(let i = 0;i<sort.length;i++){
        let name = sort[i].getAttribute("name")
        sort[i].innerHTML = name.splice(-1,2)
    }
</script>
</body>
</html>
