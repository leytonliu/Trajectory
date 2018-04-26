<%@ page import="top.leyton.util.CheckinUtil" %>
<%@ page import="top.leyton.model.CheckinTable" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: leyton
  Date: 2018/4/21
  Time: 下午1:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CheckinTable</title>
    <!-- Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<form action="index.jsp">

    <table class="table table-striped">
        <tr>
            <td>check</td>
            <td>id</td>
            <td>user_id</td>
            <td>latitude</td>
            <td>longitude</td>
            <td>location_id</td>
            <td>date</td>
            <td>time</td>
        </tr>
        <%
            CheckinUtil checkinUtil = new CheckinUtil();
            List<CheckinTable> checkinTableList = checkinUtil.getCheckinByUserId(2);
            Iterator<CheckinTable> iterator = checkinTableList.iterator();
        %>
        <tr>
            <%
                while (iterator.hasNext()) {
                    CheckinTable checkinTable = iterator.next();
            %>

            <td><input type="checkbox"></td>
            <td><%=checkinTable.getId()%>
            </td>
            <td><%=checkinTable.getUser_id()%>
            </td>
            <td><%=checkinTable.getLatitude()%>
            </td>
            <td><%=checkinTable.getLongitude()%>
            </td>
            <td><%=checkinTable.getLocation_id()%>
            </td>
            <td><%=checkinTable.getDate()%>
            </td>
            <td><%=checkinTable.getTime()%>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</form>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
