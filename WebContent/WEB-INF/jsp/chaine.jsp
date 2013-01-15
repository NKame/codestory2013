<%@page session="false" %>
<%
    response.setHeader("Accept-Ranges", "bytes");
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");
	out.print(request.getAttribute("chaine"));
%>