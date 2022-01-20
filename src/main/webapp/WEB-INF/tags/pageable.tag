<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="currentPage" required="true" type="java.lang.Integer" %>
<%@ attribute name="totalPage" required="true" type="java.lang.Integer" %>

<div class="row">
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <c:if test="${totalPage > 1}">
                <li class="page-item <c:if test="${currentPage==1}">disabled</c:if>" >
                    <a class="page-link"
                        <c:if test="${empty param.get('order')}">
                           href="?page=${currentPage-1}"
                        </c:if>
                        <c:if test="${not empty param.get('order')}">
                            href="?order=${param.get('order')}page=${currentPage-1}"
                        </c:if>
                       tabindex="-1">Previous
                    </a>
                </li>
            </c:if>
            <c:forEach begin="1" end="${totalPage}" varStatus="index">
                <li class="page-item <c:if test="${currentPage==index.index}">active </c:if>">
                    <a class="page-link"
                        <c:if test="${empty param.get('order')}">
                            href="?page=${index.index}">${index.index}
                        </c:if>
                        <c:if test="${not empty param.get('order')}">
                            href="?order=${param.get('order')}&page=${index.index}">${index.index}
                        </c:if>
                    </a>
                </li>
            </c:forEach>
            <c:if test="${totalPage > 1}">
                <li class="page-item <c:if test="${currentPage==(totalPage)}">disabled</c:if>" >
                    <a class="page-link"
                        <c:if test="${empty param.get('order')}">
                           href="?page=${currentPage+1}"
                        </c:if>
                        <c:if test="${empty param.get('order')}">
                            href="?order=${param.get('order')}page=${currentPage+1}"
                        </c:if>
                        >Next
                    </a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>