<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<div class="container">
    <div style="height:15px; width:100%; clear:both;"></div>
        <form:form modelAttribute="skillUser" method="post" action="/addSkill">
            <div class="form-row">
                <div class="form-group col-md-12">
                    <h2>Thêm kỹ năng</h2>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="name">Tên kỹ năng</label>
                    <form:input type="text" class="form-control" id="name" placeholder="Name" path="name"/>
                    <form:errors path="name" cssClass="danger"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="experience">Kinh nghiệm</label>
                    <form:input type="text" class="form-control" id="experience" placeholder="Experience" path="experience"/>
                    <form:errors path="experience"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <button type="submit" class="btn btn-primary">Xác nhận </button>
                </div>
            </div>
        </form:form>
    <div style="height:100px; width:100%; clear:both;"></div>
</div>
