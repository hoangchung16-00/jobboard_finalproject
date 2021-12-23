<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<div class="container">
    <div style="height:15px; width:100%; clear:both;"></div>
    <form:form modelAttribute="company" method="post" action="/editCompanyInfor" enctype="multipart/form-data">
        <form:hidden path="id"/>
        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="name">Tên nhà tuyển dụng</label>
                <form:input type="text" class="form-control" placeholder="Tên nhà tuyển dụng" path="name"/>
            </div>
            <div class="form-group col-md-4">
                <label for="education">Website</label>
                <form:input type="text" class="form-control" placeholder="Website" path="website"/>
            </div>
            <div class="form-group col-md-4">
                <label for="education">Ảnh</label>
                <img src="/image/${company.image}" width="30" height="30">
                <input class="form-control" name="imageCompany" id="files" type="file">
                <form:errors path="image"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-12">
                <label for="education">Địa chỉ</label>
                <form:input type="text" class="form-control" placeholder="Địa chỉ" path="address"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-12">
                <label for="education">Mô tả ngắn</label>
                <form:input type="text" class="form-control" id="education" placeholder="Mô tả ngắn" path="shortdescription"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="address">Năm thành lập</label>
                <form:input type="text" class="form-control" placeholder="Năm thành lập" path="foundationyear"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="education">Số lượng nhân viên</label>
                <form:input type="text" class="form-control"  placeholder="Employee Number" path="employee"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="address">Email</label>
                <form:input type="text" class="form-control" placeholder="Email" path="email"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="education">Số diện thoại</label>
                <form:input type="text" class="form-control"  placeholder="Phone Number" path="Số diện thoại"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-12">
                <label for="education">Mô tả chi tiết</label>
                <form:textarea type="text" class="form-control" placeholder="Mô tả" rows="4" path="description"></form:textarea>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-12">
                <button type="submit" class="btn btn-primary">Xác nhận</button>
            </div>
        </div>
    </form:form>
    <div style="height:15px; width:100%; clear:both;"></div>
</div>