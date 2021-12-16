<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div style="height:15px; width:100%; clear:both;"></div>
        <form:form modelAttribute="job" method="post" action="/createJob">
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="name">Job Name</label>
                    <form:input type="text" class="form-control" id="name" placeholder="Name" path="name"/>
                </div>
                <div class="form-group col-md-4">
                    <label for="phone">Expire Date</label>
                    <form:input type="date" class="form-control" id="phone" placeholder="Expire Date" path="expiredate"/>
                </div>
                <div class="form-group col-md-4">
                    <label for="phone">Job Type</label>
                    <form:select class="form-control" id="phone" placeholder="Expire Date" path="jobTypeId">
                        <form:options cssClass="form-control" items="${jobTypeList}" itemLabel="name" itemValue="id"/>
                    </form:select>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="address">Number</label>
                    <form:input type="text" class="form-control" id="address" placeholder="Number" path="number"/>
                </div>
                <div class="form-group col-md-4">
                    <label for="address">Min salary</label>
                    <form:input type="text" class="form-control" placeholder="Salary" path="minsalary"/>
                </div>
                <div class="form-group col-md-4">
                    <label for="address">Max Salary</label>
                    <form:input type="text" class="form-control" placeholder="Salary" path="maxsalary"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="address">Work Address</label>
                    <form:input type="text" class="form-control" placeholder="Work Address" path="address"/>
                </div>
            </div>
            <div class="form-row" id="row-skill">
                <input type="hidden" value="0"/>
                <div class="form-group col-md-6">
                    <label for="address">Skill Required</label>
                    <form:input type="text" class="form-control" id="skillName0" placeholder="Skill Name" path="skillNameList[0]"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="address">Experience</label>
                    <form:select class="form-control" path="skillExperienceList[0]" id="skillEx0">
                        <form:options cssClass="form-control" items="${levelTypeList}" itemLabel="name" itemValue="id"/>
                    </form:select>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <button type="button" class="btn btn-primary" onclick="SkillInput.addSKill()">Add  </button>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="education">Short Description</label>
                    <form:input type="text" class="form-control" id="education" placeholder="Short Description" path="shortdescription"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="education">Description</label>
                    <form:textarea type="text" class="form-control" placeholder="Description" rows="4" path="description"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="address">Benefit</label>
                    <form:textarea rows="4" type="text" class="form-control" placeholder="Benefit" path="benefit"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <button type="submit" class="btn btn-primary">Submit </button>
                </div>
            </div>
        </form:form>
    <div style="height:15px; width:100%; clear:both;"></div>
</div>

