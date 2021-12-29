<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="tag-job" tagdir="/WEB-INF/tags"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib  prefix="tag-pageable" tagdir="/WEB-INF/tags"%>
<section class="jobs">
    <div class="container">
        <div class="row heading">
            <h2>Tìm kiếm việc làm IT phù hợp</h2>
            <p>Hàng ngàn công việc IT đang chờ đợi bạn, ứng tuyển ngay hôm nay</p>
        </div>
        <div class="companies">
            <c:forEach items="${jobs}" var="job">
                <tag-job:job job="${job}"/>
            </c:forEach>
        </div>
        <tag-pageable:pageable currentPage="${currentPage}" totalPage="${totalPage}"/>
    </div>
</section>

