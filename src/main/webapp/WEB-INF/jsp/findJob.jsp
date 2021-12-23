<%@ taglib  prefix="tag-job" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<section class="jobs">

    <div class="container">
        <div class="row heading">
            <h2>Tìm kiếm việc làm IT phù hợp</h2>
            <p>Hàng ngàn công việc IT đang chờ đợi bạn, ứng tuyển ngay hôm nay</p>
        </div>
        <div class="row top-pad">
            <div class="col">
                <div class="row">
                    <input type="text" id="keyword" class="form-search" placeholder="Tìm kiếm..."/>
                    <button type="submit" class="form-button" onclick="searchJob(${currentPage})">Search</button>
                </div>
            </div>
            <%--<div class="filter">
                <div class="col-md-2 col-sm-3">
                    <p>Find By:</p>
                </div>
                <div class="col-md-10 col-sm-9">
                    <ul class="filter-list">
                        <c:forEach items="${jobTypes}" var="item">
                            <li>
                                <input id="checkbox-${item.id}" class="checkbox-custom" name="checkbox-${item.id}" type="checkbox">
                                <label for="checkbox-${item.id}" class="${item.name} checkbox-custom-label">${item.name}</label>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>--%>
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
                        <a class="page-link" href="?page=${currentPage-1}" tabindex="-1">Previous</a>
                    </li>
                    <c:forEach begin="1" end="${totalPage}" varStatus="index">
                        <li class="page-item <c:if test="${currentPage==index.index}">active </c:if>"><a class="page-link" href="?page=${index.index}">${index.index}</a></li>
                    </c:forEach>
                    <li class="page-item <c:if test="${currentPage==(totalPage)}">disabled</c:if>" >
                        <a class="page-link" href="?page=${currentPage+1}">Next</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</section>

