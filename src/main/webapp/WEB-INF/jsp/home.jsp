<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="tag-job" tagdir="/WEB-INF/tags"%>

<section class="jobs">
    <div class="container">
        <div class="row heading">
            <h2>Find Popular Jobs</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do</p>
        </div>
        <div class="companies">
            <c:forEach items="${jobs}" var="job">
                <tag-job:job job="${job}"/>
            </c:forEach>
        </div>
        <div class="row">
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <li class="page-item <c:if test="${currentPage==1}">disabled</c:if>" >
                        <a class="page-link" href="/home?page=${currentPage-1}" tabindex="-1">Previous</a>
                    </li>
                    <c:forEach begin="1" end="${totalPage}" varStatus="index">
                        <li class="page-item <c:if test="${currentPage==index.index}">active</c:if>"><a class="page-link" href="/home?page=${index.index}">${index.index}</a></li>
                    </c:forEach>
                    <li class="page-item <c:if test="${currentPage==(totalPage)}">disabled</c:if>" >
                        <a class="page-link" href="/home?page=${currentPage+1}">Next</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</section>

