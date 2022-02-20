<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="tag-date" tagdir="/WEB-INF/tags"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<section class="profile-detail">
    <div class="container">
        <div class="col-md-12">
            <div class="row">
                <div class="basic-information">
                    <div class="col-md-3 col-sm-3">
                        <img src="/image/${company.image}" alt="" class="img-responsive">
                    </div>
                    <div class="col-md-9 col-sm-9">
                        <div class="profile-content">
                            <h2>${company.name}<span>${company.shortdescription}</span></h2>
                            <ul class="information">
                                <li><span>Địa chỉ:</span>${company.address}</li>
                                <li><span>Số diện thoại:</span>${company.phonenumber}</li>
                                <li><span>Số lượng nhân viên:</span>${company.employee}</li>
                                <li><span>Mail:</span>${company.email}</li>
                                <li><span>Website:</span><a href="${company.website}" target="_blank">${company.website}</a></li>
                         </ul>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-user fa-fw"></i> Giới thiệu về nhà tuyển dụng:
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <p>${company.description}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>