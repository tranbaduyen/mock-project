<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Title</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
<link rel="stylesheet" href="css/style.css" />

<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>


</body>
</html:html>

<style>
#breadcrumb {
    list-style: none;
    display: inline-block;
        margin: 0px 15%s;
        padding: 0px;
}
#breadcrumb li{
float: left;

}
#breadcrumb li:first-child a:before {
    border: none;
}
#breadcrumb li a {
    color: #FFF;
    display: block;
    background: rgba(0, 0, 0, 0.5);
    text-decoration: none;
    position: relative;
    height: 40px;
    line-height: 40px;
    padding: 0 10px 0 5px;
    text-align: center;
    margin-right: 27px;
}

#breadcrumb li a:before, #breadcrumb li a:after {
    content: "";
    position: absolute;
    top: 0;
    border: 0 solid rgba(0, 0, 0, 0.5);
    border-width: 20px 10px;
    width: 0;
    height: 0;
}


#breadcrumb li a:before, #breadcrumb li a:after {
    content: "";
    position: absolute;
    top: 0;
    border: 0 solid rgba(0, 0, 0, 0.5);
    border-width: 20px 10px;
    width: 0;
    height: 0;
}

#breadcrumb li a:before {
    left: -20px;
    border-left-color: transparent;
}
#breadcrumb li a:after {
    left: 100%;
    border-color: transparent;
    border-left-color: rgba(0, 0, 0, 0.5);
}

</style>

<ul id="breadcrumb">
  <li><a href="#"><span class="icon icon-home"> Home</span></a></li>
  <li><a href="#"><span class="icon icon-beaker"> </span>Trung đại</a></li>
  <li><a href="#"><span class="icon icon-double-angle-right"></span> Nhân vật</a></li>
 
</ul>


<div class="starWrapper" id="quizStarWrap">
                        <img src="css/intro_stars.png" alt="" class="homeStars quizStarAnimation">
                        <img src="css/intro_stars.png" alt="" class="homeStars quizStarAnimation-two">
                        <img src="css/intro_stars.png" alt="" class="homeStars quizStarAnimation-three">
                    </div>

