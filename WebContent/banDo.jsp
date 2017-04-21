<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="http://struts.apache.org/tags-faces" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bản đồ</title>
	<style type="text/css">
		div#map_container{
			width:100%;
			height:600px;
		}
	</style>
	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyAlocshj7BzNL_-DwMsy2-ENXC2vaxwjNQ&sensor=true"></script>
	<script type="text/javascript">
		function loadMap() {
		    var vido_kinhdo = new google.maps.LatLng(16.0599156, 108.2096297);
		    var myOptions = {
		      zoom: 15,
		      center: vido_kinhdo,
		      mapTypeId: google.maps.MapTypeId.ROADMAP
		    };
		    var map = new google.maps.Map(document.getElementById("map_container"),myOptions);
		    var marker = new google.maps.Marker({
			      position: vido_kinhdo,
			      map: map,
			      title:"Đại Học Duy Tân!"
			    });
		    
		    var infowindow = new google.maps.InfoWindow();
		    
		    <logic:iterate id="dd" name="danhSachDiaDanhGanForm" property="listDiaDanhGan">
	    	
		    <bean:define id="maDiaDanh" name="dd" property="maDiaDanh"></bean:define>
		    <bean:define id="kinhDo" name="dd" property="kinhDo"></bean:define>
			<bean:define id="viDo" name="dd" property="viDo"></bean:define>
		    <bean:define id="tenDiaDanh" name="dd" property="tenDiaDanh"></bean:define>
		    <bean:define id="hinhAnh" name="dd" property="hinhAnh"></bean:define>
		    var toado_${maDiaDanh}_LatLng = {lat: ${viDo},
    				lng: ${kinhDo}};

	        var marker_${maDiaDanh}_diadanh = new google.maps.Marker({
	            position: toado_${maDiaDanh}_LatLng,
	            map: map,
	            title: '${tenDiaDanh}'
	        });
		        
		        /// thiet lap thong tin cho tung marker
				        
		       var noidung_${maDiaDanh} = '<div >'+
		       '</br>Hình ảnh : '+'<html:img src="${hinhAnh}" height="100px" width="100px"></html:img>'+
		         '</br>Tên địa danh : '+'<bean:write name="dd" property="tenDiaDanh"/>'+
		      	'</br>Nội dung : '+'<bean:write name="dd" property="noiDung"/>'+ '</div>';
		        
		      	marker_${maDiaDanh}_diadanh.addListener('click', function() {
		        	if(!infowindow) infowindow = new google.maps.InfoWindow();
		        	infowindow.close();
		        	infowindow.setContent("<div id='thr_${maDiaDanh}_con' class='thr_con clearfix'>"+noidung_${maDiaDanh}+"</div>");
			        infowindow.open(map, marker_${maDiaDanh}_diadanh);	
				});
		        
		        
	    	</logic:iterate>
	  }
	</script>
</head>
<body onload="loadMap()">
	<div id="map_container"></div>
	
</body>
</html>