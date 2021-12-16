<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div style="height:15px; width:100%; clear:both;"></div>
    <form:form modelAttribute="company" method="post" action="/editCompanyInfor" enctype="multipart/form-data">
        <form:hidden path="id"/>
        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="name">Company Name</label>
                <form:input type="text" class="form-control" placeholder="Name" path="name"/>
            </div>
            <div class="form-group col-md-4">
                <label for="education">Website</label>
                <form:input type="text" class="form-control" placeholder="Website" path="website"/>
            </div>
            <div class="form-group col-md-4">
                <label for="education">Image</label>
                <img src="/image/${company.image}" width="30" height="30">
                <input class="form-control" name="imageCompany" id="files" type="file">
                <form:errors path="image"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-12">
                <label for="education">Address</label>
                <form:input type="text" class="form-control" placeholder="Address" path="address"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-12">
                <label for="education">Short Description</label>
                <form:input type="text" class="form-control" id="education" placeholder="Short Description" path="shortdescription"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="address">Foundation Year</label>
                <form:input type="text" class="form-control" placeholder="Foundation Year" path="foundationyear"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="education">Employee Number</label>
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
                <label for="education">Phonenumber</label>
                <form:input type="text" class="form-control"  placeholder="Phone Number" path="phonenumber"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-12">
                <label for="education">Description</label>
                <form:textarea type="text" class="form-control" placeholder="Description" rows="4" path="description"></form:textarea>
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