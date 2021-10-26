<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="money" required="true" type="java.math.BigDecimal" %>
$<fmt:formatNumber value="${money}" currencySymbol="$" currencyCode="$"/>