<%@ taglib  prefix="tag-job" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib  prefix="tag-pageable" tagdir="/WEB-INF/tags"%>
<section class="jobs">

    <div class="container">
        <div class="row heading">
            <h2>Tìm kiếm việc làm IT phù hợp</h2>
            <p>Hàng ngàn công việc IT đang chờ đợi bạn, ứng tuyển ngay hôm nay</p>
        </div>
        <div class="row top-pad">
            <div class="col">
                <div class="row">
                    <input type="text" id="keyword" class="form-search" placeholder="Tìm kiếm..."
                        <c:if test="${not search.toString().equalsIgnoreCase('all')}">
                            value="${search}"
                        </c:if>
                    />
                    <button type="submit" class="form-button" onclick="searchJob(${currentPage})">Tìm kiếm</button>
                </div>
            </div>
            <div class="filter">
                <div class="col-md-2 col-sm-3">
                </div>
                <div class="col-md-10 col-sm-9">
                    <ul class="filter-list">
                        <c:forEach items="${jobTypes}" var="item">
                            <li>
                                <input
                                    <c:if test="${empty param.get('filter')}">
                                        onclick="window.location.href='?filter=${item.id}'"
                                    </c:if>
                                    <c:if test="${not empty param.get('filter')}">
                                        <c:if test="${param.get('filter').toString().contains(item.id.toString())}">
                                            onclick="window.location.href='?filter=${param.get('filter').replace(item.id.toString(),'')}'"
                                        </c:if>
                                        <c:if test="${not param.get('filter').toString().contains(item.id.toString())}">
                                            onclick="window.location.href='?filter=${param.get('filter').concat(item.id)}'"
                                        </c:if>
                                    </c:if>
                                    id="checkbox-${item.id}" class="checkbox-custom" name="checkbox-${item.id}" type="checkbox"
                                    <c:if test="${param.get('filter').toString().contains(item.id.toString())}">
                                        checked="checked"
                                    </c:if>
                                />
                                <label for="checkbox-${item.id}" class="${item.name} checkbox-custom-label">${item.name}</label>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <div class="companies">
            <c:forEach items="${jobs}" var="job">
                <tag-job:job job="${job}"/>
            </c:forEach>
        </div>
        <tag-pageable:pageable currentPage="${currentPage}" totalPage="${totalPage}"/>
    </div>
</section>

