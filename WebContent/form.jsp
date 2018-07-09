<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form method="post" action="store.htm" modelAttribute="person">
   <table>
        <tr>
            <td>sno</td>
            <td><s:input path="sno"/>
            <td><s:errors path="sno"></s:errors></td>
        </tr>
        <tr>
            <td>name</td>
            <td><s:input path="name"/>
            <td><s:errors path="name"></s:errors></td>
        </tr>
        <tr>
            <td>city</td>
            <td><s:input path="city"/>
            <td><s:errors path="city"></s:errors></td>
        </tr>
       <tr>
          <td><input type="submit" value="Add Person">
       </tr>
   
   </table>
</s:form>
</body>
</html>