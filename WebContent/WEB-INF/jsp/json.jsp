<%@page import="org.stringtree.json.JSONWriter" %>
<%
    response.setHeader("Accept-Ranges", "bytes");
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    JSONWriter writer = new JSONWriter(false);
    
    out.print(writer.write(request.getAttribute("json")));
%>