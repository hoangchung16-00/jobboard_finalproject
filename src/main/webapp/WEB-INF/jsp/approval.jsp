<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib  prefix="tag-dropdown" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="tag-date" tagdir="/WEB-INF/tags"%>
<%@ taglib  prefix="tag-pageable" tagdir="/WEB-INF/tags"%>
<div class="container">

    <div style="height:1000px; width:100%; clear:both;">
        <table class="table table-striped">
            <div style="height:10px; width:100%; clear:both;"></div>
            <tag-dropdown:dropdown list="${statusList}" current="${currentFilter}"/>
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Họ tên</th>
                    <th scope="col">Số điện thoại</th>
                    <th scope="col">Công việc ứng tuyển</th>
                    <th scope="col"><button class="btn-title">Thời gian ứng tuyển<i class="fa fa-angle-down" style="font-size:24px"></i></button> </th>
                    <th scope="col">Trạng thái</th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${recruitList}" var="request" varStatus="index">
                <tr>
                    <th scope="row">${index.index+1}</th>
                    <td>${request.user.name}</td>
                    <td>${request.user.phonenumber}</td>
                    <td>${request.job.name}</td>
                    <td><tag-date:date date="${request.applytime}"/></td>
                    <td id="status${request.id}">${request.status.name}</td>
                    <td>
                        <a href="/profile/${request.user.id}" type="button" class="btn btn-info">Xem hồ sơ</a>
                        <a href="#" type="button" class="btn btn-success <c:if test="${request.status.id == 1 || request.status.id == 2}">disabled</c:if>" onclick="accept(${request.id})">Đồng ý</a>
                        <a href="#" type="button" class="btn btn-danger <c:if test="${request.status.id == 2 || request.status.id == 1}">disabled</c:if>"  onclick="deny(${request.id})">Từ chối</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <tag-pageable:pageable currentPage="${currentPage}" totalPage="${totalPage}"/>
    </div>
</div>

<!-- Modal -->

<div class="modal fade" id="denyModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="exampleModalLabel">Duyệt hồ sơ ứng viên</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="message"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                <button id="approveButton" type="button" class="btn btn-success" >Đồng ý</button>
            </div>
        </div>
    </div>
</div>