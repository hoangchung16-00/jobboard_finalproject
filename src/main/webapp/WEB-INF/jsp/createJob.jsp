<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<div class="container">
    <div style="height:15px; width:100%; clear:both;"></div>
        <form:form modelAttribute="job" method="post" action="/createJob">
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="name">Tên công việc <form:errors path="name" cssClass="danger"/></label>
                    <form:input type="text" class="form-control" id="name" path="name"/>

                </div>
                <div class="form-group col-md-4">
                    <label for="phone">Ngày hết hạn</label>
                    <form:input type="date" class="form-control" id="phone" placeholder="Ngày hết hạn" path="expiredate"/>
                </div>
                <div class="form-group col-md-4">
                    <label for="phone">Loại công việc <form:errors path="jobTypeId" cssClass="danger"/></label>
                    <form:select class="form-control" id="phone" placeholder="Expire Date" path="jobTypeId">
                        <form:options cssClass="form-control" items="${jobTypeList}" itemLabel="name" itemValue="id"/>
                    </form:select>

                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="address">Số lượng <form:errors path="number" cssClass="danger"/> </label>
                    <form:input type="text" class="form-control" id="address" placeholder="Số lượng" path="number"/>
                </div>
                <div class="form-group col-md-4">
                    <label for="address">Lương thấp nhất</label>
                    <form:input type="text" class="form-control" placeholder="Lương thấp nhất" path="minsalary"/>
                </div>
                <div class="form-group col-md-4">
                    <label for="address">Lương cao nhất</label>
                    <form:input type="text" class="form-control" placeholder="Lương cao nhất" path="maxsalary"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="address">Địa chỉ làm việc <form:errors path="address" cssClass="danger"/></label>
                    <form:input type="text" class="form-control" placeholder="Địa chỉ làm việc" path="address"/>

                </div>
            </div>
            <div class="form-row" id="row-skill">
                <input type="hidden" value="0"/>
                <div class="form-group col-md-6">
                    <label for="address">Yêu cầu kỹ năng <form:errors path="skillNameList" cssClass="danger"/></label>
                    <form:input type="text" class="form-control" id="skillName0" placeholder="Tên kỹ năng" path="skillNameList[0]"/>

                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="address">Yêu cầu kinh nghiệm <form:errors path="skillExperienceList"/></label>
                    <form:select class="form-control" path="skillExperienceList[0]" id="skillEx0">
                        <form:options cssClass="form-control" items="${levelTypeList}" itemLabel="name" itemValue="id"/>
                    </form:select>

                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <button type="button" class="btn btn-primary" onclick="SkillInput.addSKill()">Thêm  </button>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="education">Mô tả ngắn</label>
                    <form:input type="text" class="form-control" id="education" placeholder="Short Description" path="shortdescription"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="education">Mô tả chi tiết <form:errors path="description" cssClass="danger"/></label>
                    <form:textarea type="text" class="form-control" placeholder="Description" rows="4" path="description"/>

                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="address">Lợi ích</label>
                    <form:textarea rows="4" type="text" class="form-control" placeholder="Benefit" path="benefit"/>
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

