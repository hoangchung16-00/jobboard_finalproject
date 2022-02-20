<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="date" required="true" type="java.util.Date" %>
<fmt:formatDate value="${date}" type="date" pattern="dd/MM/yyyy"/>