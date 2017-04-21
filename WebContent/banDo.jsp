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
		    
		   
		    
		    <logic:iterate id="dd" name="danhSachDiaDanhGanForm" property="listDiaDanhGan">
	    	
			    var toado_diadanh = {lat: <bean:write name="dd" property="viDo"/>,
	    				lng: <bean:write name="dd" property="kinhDo"/>};
	
		        var marker = new google.maps.Marker({
		            position: toado_diadanh,
		            map: map,
		            title: '<bean:write name="dd" property="tenDiaDanh"/>'
		        });
		        
		        /// thiet lap thong tin cho tung marker
				        
		       var noidung='<div >'+
		         '</br>Tên địa danh : '+'<bean:write name="dd" property="tenDiaDanh"/>'+
		      	'</br>Nội dung : '+'<bean:write name="dd" property="noiDung"/>'+ '</div>';
		        var infor_diadanh = new google.maps.InfoWindow({
		            content: noidung
		          });
		        marker.addListener('click', function() {
		        	infor_diadanh.open(map, marker);
				});
	    	</logic:iterate>
	  }
	</script>
</head>
<body onload="loadMap()">
	<div id="map_container"></div>
	
</body>
</html>