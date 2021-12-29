<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="currentPage" required="true" type="java.lang.Integer" %>
<%@ attribute name="totalPage" required="true" type="java.lang.Integer" %>
<div class="row">
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <c:if test="${totalPage > 1}">
                <li class="page-item <c:if test="${currentPage==1}">disabled</c:if>" >
                    <a class="page-link" href="?page=${currentPage-1}" tabindex="-1">Previous</a>
                </li>
            </c:if>
            <c:forEach begin="1" end="${totalPage}" varStatus="index">
                <li class="page-item <c:if test="${currentPage==index.index}">active </c:if>">
                    <a class="page-link" href="?page=${index.index}">${index.index}</a>
                </li>
            </c:forEach>
            <c:if test="${totalPage > 1}">
                <li class="page-item <c:if test="${currentPage==(totalPage)}">disabled</c:if>" >
                    <a class="page-link" href="?page=${currentPage+1}">Next</a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>