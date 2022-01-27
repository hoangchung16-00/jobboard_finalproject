<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="list" required="true" type="java.util.List<com.example.job.entities.Status>" %>
<%@ attribute name="current" required="true" type="java.lang.String" %>
<%@tag pageEncoding="UTF-8"%>
<div class="customdrop">
    <button onclick="myFunction()" class="btn btn-success dropbtn">
        <c:if test="${current != 'All'}">
            ${current}
        </c:if>
        <c:if test="${current == 'All'}">
            Tất cả
        </c:if>
    </button>
    <div id="myDropdown" class="customdrop-content">
        <c:forEach items="${list}" var="item">
            <c:if test="${item.name != current}">
                <a href="/approval/${item.name}">${item.name}</a>
            </c:if>
        </c:forEach>
        <c:if test="${current != 'All'}">
            <a href="/approval/All">Tất cả</a>
        </c:if>
    </div>
</div>

