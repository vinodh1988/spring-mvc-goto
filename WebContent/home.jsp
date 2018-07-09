<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/style.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
  <h1>Spring Annotation Config is Working!!!!</h1>
  <h3>No of requests made this session >>>  ${sessionrequest}</h3>
    <h3>No of requests made by everyone >>>  ${applicationrequest}</h3>
     <h3>Session object hashcode >>>  ${sessionhash}</h3>
     <h3>Application object hashcode >>>  ${applicationhash}</h3>
  <a href="tab.htm">Check person Data</a>
  <a href="form.htm">Add a New Person....!!!!</a>
</body>
</html>