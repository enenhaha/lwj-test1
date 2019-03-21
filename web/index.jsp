<%--
  Created by IntelliJ IDEA.
  User: lwj
  Date: 2018/6/8
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://www.qijicloud.cn/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<form  method="post"> <%--action="/web/demo"--%>
    用户名：<input type="text" name="userName"><br/>
    密码：<input type="text" name="pwd"><br/>
    性别：<input type="radio" name="sex" value="男" checked="checked">男
    <input type="radio" name="sex" value="女">女<br/>
    爱好：<input type="checkbox" name="hobby" value="足球">足球
    <input type="checkbox" name="hobby" value="篮球">篮球
    <input type="checkbox" name="hobby" value="排球">排球
    <input type="checkbox" name="hobby" value="羽毛球">羽毛球<br/>
    所在城市：<select name="city">
    <option>---请选择---</option>
    <option value="bj">北京</option>
    <option value="sh">上海</option>
    <option value="sy">沈阳</option>
</select>
    <br/>
    <input type="button" value="点击注册" id="submit">
</form>

<script>
    $.ajax({
        type:"post",
        url:"/web/test",
        data:{"aa":11,"bb":22},
        dataType:"json",
        success:function(data) {
            console.log(data)
        },
        error:function(msg) {
            console.log(msg);
        }
    });
document.querySelector("#submit").onclick=function(){
    var userName = document.querySelector("[name=userName]").value;
    var pwd = document.querySelector("[name=pwd]").value;
    var sex = document.querySelector("[name=sex]").value;
    var city = document.querySelector("[name=city]").value;
    
    $.ajax({
        type:"post",
        url:"/web/demo",
        data:{userName:userName,pwd:pwd,sex:sex,city:city},
        dataType:"json",
        success:function(data) {
            console.log(data)
        },
        error:function(msg) {
            console.log(msg);
        }
    });
    
}
</script>
</body>
</html>
