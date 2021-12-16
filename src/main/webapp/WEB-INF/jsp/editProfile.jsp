<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div style="height:15px; width:100%; clear:both;"></div>
        <form:form method="post" modelAttribute="editProfileForm" action="/editprofile" enctype="multipart/form-data">
            <div class="form-row">
                <div class="form-group col-md-12">
                    <h2>Edit profile</h2>
                </div>
            </div>
            <form:hidden path="id"/>
            <form:hidden path="image"/>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="name">Name</label>
                    <form:input type="text" class="form-control" id="name" placeholder="Name" path="name"/>
                </div>
                <div class="form-group col-md-4">
                    <label for="phone">Phone number</label>
                    <form:input type="text" class="form-control" path="phonenumber" id="phone" placeholder="Phone number"/>
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
                    <label for="email">Email</label>
                    <form:input type="email" class="form-control" path="email" id="email" placeholder="Email"/>
                </div>
                <div class="form-group col-md-3">
                    <label for="datepicker">Date of birth</label>
                    <form:input type="date"  cssClass="form-control" id="datepicker" path="dob"/>
                </div>
                <div class="form-group col-md-3">
                    <label for="gender">Gender</label>
                    <form:select id="gender" class="form-control" path="gender">
                        <form:option value="Male" label="Male"/>
                        <form:option value="Female" label="Female"/>
                        <form:option value="Other" label="Other"/>
                    </form:select>
                </div>

            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="address">Address</label>
                    <form:input type="text" class="form-control" id="address" placeholder="1234 Main St" path="address"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="education">Education</label>
                    <form:input type="text" class="form-control" id="education" placeholder="Education" path="education"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="education">Skill</label>
                    <c:forEach items="${editProfileForm.skillIdList}" varStatus="index">
                        <form:hidden path="skillIdList[${index.index}]"/>
                    </c:forEach>
                    <c:forEach items="${editProfileForm.skillNameList}" varStatus="index">
                        <form:input type="text" class="form-control" placeholder="Name" path="skillNameList[${index.index}]"/>
                    </c:forEach>
                </div>
                <div class="form-group col-md-4">
                    <label for="education">Experience</label>
                    <c:forEach items="${editProfileForm.skillExperienceList}" varStatus="index">
                        <form:input type="text" class="form-control" placeholder="Name" path="skillExperienceList[${index.index}]"/>
                    </c:forEach>
                </div>
                <div class="form-group col-md-2">
                    <label for="education">Action</label>
                    <c:forEach items="${editProfileForm.skillIdList}" var="id">
                        <a type="Button" class="btn btn-primary form-control" href="/removeSkill/${id}">Remove </a>
                    </c:forEach>
                </div>
                <div class="form-group col-md-4">
                    <a type="Button" class="btn btn-primary" href="/addSkill">Add Skill </a>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="description">Description</label>
                    <form:textarea class="form-control" id="description" rows="4" path="description"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="hobby">Hobby</label>
                    <form:textarea class="form-control" id="hobby" rows="3" path="hobby"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <button type="submit" class="btn btn-primary">Save </button>
                </div>
            </div>
        </form:form>
    <div style="height:15px; width:100%; clear:both;"></div>
</div>
