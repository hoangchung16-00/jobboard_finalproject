<%@tag pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="tag-money" tagdir="/WEB-INF/tags"%>

<%@ attribute name="job" required="true" type="com.example.job.entities.Job" %>
<div class="company-list">
    <div class="row">
        <div class="col-md-2 col-sm-2">
            <div class="company-logo">
                <img src="${pageContext.request.contextPath}/image/${job.company.image}" class="img-responsive" alt="" />
            </div>
        </div>
        <div class="col-md-8 col-sm-8">
            <div class="company-content">
                <a href="/jobdetail/${job.id}"><h3>${job.name}<span class="${job.jobType.name}">${job.jobType.name}</span></h3></a>
                <p><span class="company-name"><i class="fa fa-briefcase"></i>${job.company.name}</span><span class="company-location"><i class="fa fa-map-marker"></i> ${job.address}</span><span class="package"><i class="fa fa-money"></i><tag-money:money money="${job.minsalary}"/> - <tag-money:money money="${job.maxsalary}"/></span></p>
                <p>Yêu cầu kỹ năng:
                    <c:forEach items="${job.skillJobList}" var="skill">
                        ${skill.name}  |
                    </c:forEach>
                </p>

            </div>
        </div>
        <div class="col-md-2 col-sm-2">
            <div class="company-content">
                <a href="/jobdetail/${job.id}" class="btn view-job" name="View Job">Xem chi tiết</a>
            </div>
        </div>

    </div>
</div>