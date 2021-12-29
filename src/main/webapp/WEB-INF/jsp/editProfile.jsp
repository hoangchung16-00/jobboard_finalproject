<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<div class="container">
    <div style="height:15px; width:100%; clear:both;"></div>
        <form:form method="post" modelAttribute="editProfileForm" action="/editProfile" enctype="multipart/form-data">
            <div class="form-row">
                <div class="form-group col-md-12">
                    <h2>Edit profile</h2>
                </div>
            </div>
            <form:hidden path="id"/>
            <form:hidden path="image"/>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="name">Họ tên <form:errors path="name" cssClass="danger"/></label>
                    <form:input type="text" class="form-control" id="name"  path="name"/>
                </div>
                <div class="form-group col-md-4">
                    <label for="phone">Số diện thoại <form:errors path="phonenumber" cssClass="danger"/></label>
                    <form:input type="text" class="form-control" path="phonenumber" id="phone"/>
                </div>
                <div class="form-group col-md-4">
                    <label for="education">Image</label>
                    <img src="/image/${editProfileForm.image}" width="30" height="30">
                    <input class="form-control" name="imageUser" id="files" type="file">
                    <form:errors path="image"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="email">Email <form:errors path="email" cssClass="danger"/></label>
                    <form:input type="email" class="form-control" path="email" id="email"/>
                </div>
                <div class="form-group col-md-3">
                    <label for="datepicker">Ngày sinh <form:errors path="dob" cssClass="danger"/></label>
                    <form:input type="date"  cssClass="form-control" id="datepicker" path="dob"/>
                </div>
                <div class="form-group col-md-3">
                    <label for="gender">Giới tính </label>
                    <form:select id="gender" class="form-control" path="gender">
                        <form:option value="Male" label="Male"/>
                        <form:option value="Female" label="Female"/>
                        <form:option value="Other" label="Other"/>
                    </form:select>
                </div>

            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="address">Địa chỉ <form:errors path="address" cssClass="danger"/></label>
                    <form:input type="text" class="form-control" id="address" path="address"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="education">Học vấn</label>
                    <form:input type="text" class="form-control" id="education" path="education"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="education">Kỹ năng</label>
                    <c:forEach items="${editProfileForm.skillIdList}" varStatus="index">
                        <form:hidden path="skillIdList[${index.index}]"/>
                    </c:forEach>
                    <c:forEach items="${editProfileForm.skillNameList}" varStatus="index">
                        <form:input type="text" class="form-control" placeholder="Name" path="skillNameList[${index.index}]"/>
                    </c:forEach>
                </div>
                <div class="form-group col-md-4">
                    <label for="education">Kinh nghiệm</label>
                    <c:forEach items="${editProfileForm.skillExperienceList}" varStatus="index">
                        <form:input type="text" class="form-control" placeholder="Name" path="skillExperienceList[${index.index}]"/>
                    </c:forEach>
                </div>
                <div class="form-group col-md-2">
                    <label for="education"></label>
                    <c:forEach items="${editProfileForm.skillIdList}" var="id">
                        <a type="Button" class="btn btn-primary form-control" href="/removeSkill/${id}">Xóa </a>
                    </c:forEach>
                </div>
                <div class="form-group col-md-4">
                    <a type="Button" class="btn btn-primary" href="/addSkill">Thêm kỹ năng </a>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="description">Mô tả <form:errors path="description" cssClass="danger"/></label>
                    <form:textarea class="form-control" id="description" rows="4" path="description"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="hobby">Sở thích</label>
                    <form:textarea class="form-control" id="hobby" rows="3" path="hobby"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <button type="submit" class="btn btn-primary">Lưu </button>
                </div>
            </div>
        </form:form>
    <div style="height:15px; width:100%; clear:both;"></div>
</div>
