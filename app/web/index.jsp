<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>24点小游戏</h1>
<form action="index.jsp">
    <input type="text" name="A">
    <input type="text" name="B">
    <input type="text" name="C">
    <input type="text" name="D">
    <input type="submit">
    <input type="reset">
</form>

A:<%=request.getParameter("A")%><br/>
B:<%=request.getParameter("B")%><br/>
C:<%=request.getParameter("C")%><br/>
D:<%=request.getParameter("D")%><br/>
<%
    int a=0;
    int b=0;
    int c=0;
    int d=0;
    try{
        a=Integer.parseInt(request.getParameter("A"));
        b=Integer.parseInt(request.getParameter("B"));
        c=Integer.parseInt(request.getParameter("C"));
        d=Integer.parseInt(request.getParameter("D"));

    }catch(Exception e){

    }
    String result=ai.Engine.solve24(a,b,c,d);
    out.println(result);

%>
</body>
</html>
