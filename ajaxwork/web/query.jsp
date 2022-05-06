<%--
  Created by IntelliJ IDEA.
  User: AzI
  Date: 2022/05/06
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询页面</title>
</head>
<body>
<script>
    function query(){
        var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange=function (){
           if (xmlHttp.readyState==4 && xmlHttp.status==200)
           {
               var responseText = xmlHttp.responseText;
               var jsonObj = eval("("+responseText+")");
               document.getElementById("name").value=jsonObj.name;
               document.getElementById("loc").value=jsonObj.loc;
               document.getElementById("num").value=jsonObj.num;
           }

        }
        var no = document.getElementById("no").value;
        xmlHttp.open("get","query?no="+no,true);
        xmlHttp.send();
    }

</script>
<h3>根据编号查询部门</h3>
<%--部门编号<input type="" id="no"><br>--%>
部门编号<select id="no">
    <option>请选择</option>
    <c:forEach items="${deptList}"  var="dept">
    <option value="${dept.no}">${dept.no}</option>
    </c:forEach>
</select><br>
部门名称<input type="text" id="name"><br>
部门位置<input type="text" id="loc"><br>
部门人数<input type="text" id="num"><br>
<input type="button" id="button" onclick="query()" value="按部门编号查询">
</body>
</html>
