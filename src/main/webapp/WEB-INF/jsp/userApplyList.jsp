<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib  prefix="tag-dropdown" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="tag-date" tagdir="/WEB-INF/tags"%>
<div class="container">

    <div style="height:1000px; width:100%; clear:both;">
        <table class="table table-striped">
            <div style="height:10px; width:100%; clear:both;"></div>
           <%-- <tag-dropdown:dropdown list="${statusList}" current="${currentFilter}"/>--%>
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Công việc ứng tuyển</th>
                <th scope="col">Tên nhà tuyển dụng</th>
                <th scope="col"><button class="btn-title">Thời gian ứng tuyển<i class="fa fa-angle-down" style="font-size:24px"></i></button> </th>
                <th scope="col">Thời gian hết hạn</th>
                <th scope="col">Trạng thái</th>
                <th scope="col"></th>

            </tr>
            </thead>
            <tbody>
                <c:forEach items="${applyList}" varStatus="index" var="request">
                <tr>
                    <th scope="row">${index.index+1}</th>
                    <td>${request.job.name}</td>
                    <td>${request.job.company.name}</td>
                    <td> <tag-date:date date="${request.applytime}"/></td>
                    <td><tag-date:date date="${request.job.expiredate}"/></td>
                    <td>${request.status.name}</td>
                    <td><button class="btn btn-success">Xem thông tin nhà tuyển dụng</button></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <%--<div class="row">
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <li class="page-item <c:if test="${currentPage==1}">disabled</c:if>" >
                        <a class="page-link" href="/approval/${currentFilter}?page=${currentPage-1}" tabindex="-1">Previous</a>
                    </li>
                    <c:forEach begin="1" end="${totalPage}" varStatus="index">
                        <li class="page-item <c:if test="${currentPage==index.index}">active </c:if>"><a class="page-link" href="/approval/${currentFilter}?page=${index.index}">${index.index}</a></li>
                    </c:forEach>
                    <li class="page-item <c:if test="${currentPage==(totalPage)}">disabled</c:if>" >
                        <a class="page-link" href="/approval/${currentFilter}?page=${currentPage+1}">Next</a>
                    </li>
                </ul>
            </nav>
        </div>--%>
    </div>
</div>