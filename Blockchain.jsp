<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>Simple Blockchain</h1>
   <h2>Blockchain Data</h2>
   
    <ul>
        <c:forEach var="Blockchain" items="${chain}">
            <li>Block ${block.index} Hash: ${block.hash}</li>
        </c:forEach>
    </ul>
    <form action="BlockchainServlet" method="GET">
        <input type="hidden" name="action" value="mine">
        <button type="submit">Mine New Block</button>
    </form>

</body>
</html>