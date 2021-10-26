<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="tag-money" tagdir="/WEB-INF/tags"%>
<%@ attribute name="job" required="true" type="com.example.jobboard_final.entities.Job" %>
<div class="company-list">
    <div class="row">
        <div class="col-md-2 col-sm-2">
            <div class="company-logo">
                <img src="${pageContext.request.contextPath}/image/${job.company.image}" class="img-responsive" alt="" />
            </div>
        </div>
        <div class="col-md-10 col-sm-10">
            <div class="company-content">
                <h3>${job.name}<span class="<c:if test="${job.jobType.name=='fulltime'}">full-time</c:if><c:if test="${job.jobType.name=='partime'}">part-time</c:if><c:if test="${job.jobType.name=='freelance'}">freelance</c:if>">${job.jobType.name}</span></h3>
                <p><span class="company-name"><i class="fa fa-briefcase"></i>${job.company.name}</span><span class="company-location"><i class="fa fa-map-marker"></i> ${job.address}</span><span class="package"><i class="fa fa-money"></i><tag-money:money money="${job.minsalary}"/> - <tag-money:money money="${job.maxsalary}"/></span></p>
            </div>
        </div>
    </div>
</div>