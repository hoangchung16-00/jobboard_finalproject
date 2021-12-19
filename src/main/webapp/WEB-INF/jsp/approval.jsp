<%@ taglib  prefix="tag-dropdown" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">

    <div style="height:1000px; width:100%; clear:both;">
        <table class="table table-striped">
            <div style="height:10px; width:100%; clear:both;"></div>
            <tag-dropdown:dropdown list="${statusList}" current="${currentFilter}"/>
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Job</th>
                    <th scope="col"><button class="btn-title">Apply time  <i class="fa fa-angle-down" style="font-size:24px"></i></button> </th>
                    <th scope="col">Status</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${recruitList}" var="request" varStatus="index">
                <tr>
                    <th scope="row">${index.index+1}</th>
                    <td>${request.user.name}</td>
                    <td>${request.user.phonenumber}</td>
                    <td>${request.job.name}</td>
                    <td>${request.applytime}</td>
                    <td id="status${request.id}">${request.status.name}</td>
                    <td>
                        <a href="/profile/${request.user.id}" type="button" class="btn btn-info">View Profile</a>
                        <a href="#" type="button" class="btn btn-success <c:if test="${request.status.id == 1 || request.status.id == 2}">disabled</c:if>" onclick="accept(${request.id})">Accept</a>
                        <a href="#" type="button" class="btn btn-danger <c:if test="${request.status.id == 2 || request.status.id == 1}">disabled</c:if>"  onclick="deny(${request.id})">Deny</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="row">
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
        </div>
    </div>
</div>

<!-- Modal -->

<div class="modal fade" id="denyModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">

                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>

                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="message"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button id="approveButton" type="button" class="btn btn-success" >Yes</button>
            </div>
        </div>
    </div>
</div>