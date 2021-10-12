<%@ taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Jober Desk | Responsive Job Portal Template</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- All Plugin Css -->
    <link rel="stylesheet" href="/css/plugins.css">

    <!-- Style & Common Css -->
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/main.css">

</head>

<body>

<tiles:insertAttribute name="navigation"/>
<tiles:insertAttribute name="banner"/>
<tiles:insertAttribute name="feature"/>



<tiles:insertAttribute name="body"/>



<tiles:insertAttribute name="subscribe"/>


<tiles:insertAttribute name="footer"/>

<script type="text/javascript" src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/owl.carousel.min.js"></script>
<script src="/js/bootsnav.js"></script>
<script src="/js/main.js"></script>
</body>
</html>
