<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%! 
	public void jspInit() {
		System.out.println("jsp init....");
	}
%>
   
<%! 
	public void jspDestroy() {
		System.out.println("jsp destroy...");
	}
%>

<% System.out.println("service...."); %>

<%!int globalVar=100; %>
<% int localVar=100; %>

<%for(int i=1;i<=6;i++){%>
<h<%=i%>> hello </h<%=i%>>
<% } %>

 <%=(++globalVar) %> accessed
 <%=(++localVar) %> accessed
 
 <% ArrayList mylist = new ArrayList(); %>
 Session created on <%=session.getCreationTime() %>
 Session id <%=session.getId() %>
 
 </body>
</html>