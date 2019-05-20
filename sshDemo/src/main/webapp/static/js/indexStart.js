var ctx = pageContext.request.contextPath
//用一个json形式的data变量储存你要传输的数据
var data ={
    name: "buza",
    age: "3",
}
//json转换方法
function join(data){
    let str = ""
    for(let i in data){
    str+= i+"="+data[i]+"&"
     }
    return str.replace(/&$/, "")
}
//删除某项
//获取删除按钮,并操作删除操作
var delBtns = document.getElementsByClassName("delect")
for(let i = 0,l = delBtns.length;i<l;i++){
    let newsid = delBtns[i].getAttribute("flag")
    delBtns[i].onclick = function delectNews() {
        let xhr = new XMLHttpRequest()
        //post方法如下
        //删除操作的地址↓↓↓↓
        xhr.open("post", "http://localhost:8080?", true)
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
        xhr.send(newsid)
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                if (xhr.status >= 200 && xhr.status < 300 || xhr.status === 304) {
                    console.log("sussees")
                }
            }
        }
    }
}
//编辑某项
var editBtns = document.getElementsByClassName("edit")
for(let i = 0,l = editBtns.length;i<l;i++){
    let newsid = editBtns[i].getAttribute("flag")
    editBtns[i].onclick = function editNews() {
        let xhr = new XMLHttpRequest()
        //post方法如下
        //删除操作的地址↓↓↓↓
        xhr.open("post", "http://localhost:8080?", true)
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
        xhr.send(newsid)
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                if (xhr.status >= 200 && xhr.status < 300 || xhr.status === 304) {
                    console.log("sussees")
                }
            }
        }
    }
}
//新增项
var addBtn = document.getElementById("add")

addBtn.onclick = function addNews(){
    let xhr =new XMLHttpRequest()
    //get方法如下
                        //增加操作的地址↓↓↓↓
       xhr.open("get","http://localhost:8080?"+join(data),true)
       xhr.send()
       xhr.onreadystatechange = function(){
            if(xhr.readyState === 4){
                if(xhr.status>=200 && xhr.status<300 || xhr.status===304){
                    console.log("sussees")
                }
            }            
        }
}
//批量删除
var delAll = document.getElementById("delectall")
delAll.onclick = function delAllNews(){
    let checkedBox = document.getElementsByClassName("checkbox")
    var a = []
    for(let i = 0,l = checkedBox.length;i<l;i++){
        if(checkedBox[i].checked){
            a.push(checkedBox[i].getAttribute("flag"))
        }
    }
    let xhr =new XMLHttpRequest()
    //                ↓↓删除地址
    xhr.open("post", "http://localhost:8080?", true)
       xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
       xhr.send(a)
       xhr.onreadystatechange = function(){
            if(xhr.readyState === 4){
                if(xhr.status>=200 && xhr.status<300 || xhr.status===304){
                    console.log("sussees")
                }
            }            
        }
}
//这个方法将数据转化为para1=val1&para2=val2....的形式
// function ajax1(){
//     let xhr =new XMLHttpRequest()
// //post方法如下
//                     //删除操作的地址↓↓↓↓
//    xhr.open("post", "http://localhost:8080?", true)
//    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
//    xhr.send(join(data))
// get方法如下
//                删除操作的地址↓↓↓↓
//     xhr.open("get","http://localhost:8080?"+join(data),true)
//     xhr.send()
//     xhr.onreadystatechange = function(){
//         if(xhr.readyState === 4){
//             if(xhr.status>=200 && xhr.status<300 || xhr.status===304){
//                 document.body.innerHTML+=xhr.responseText
//             }
//         }            
//     }
// }