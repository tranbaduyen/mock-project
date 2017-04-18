<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0" />
	<script src="jquery-1.11.3.min.js"></script>
	<script src="ailatrieuphu.js"></script>
	<link rel="stylesheet" href="bootstrap.min.css"/>
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type='text/css'>
	<link rel="stylesheet" href="style.css" type='text/css'>
	<title>Ai Là Sử Gia</title>
</head>
<body>

<div id="main">
<%@ include file="/header.jsp" %>

<div id="game">
   
    <div class="c-novela-header">
			<h2 class="c-novela-header__title" title="Ai Là Sử Gia ?">Ai Là Sử Gia ?</h2>
		</div>
    <div id="each-question" class="row">
        <table>
            <thead>
                <tr>
                    <div id="question"> <span id="question-number"></span>
					<span id="display-question"></span>
                    </div>
                <tr>
            </thead>
            <tbody id="sellector">
                <tr>
                    <td>
                        <div id="boxA" class="box"></div>
                    </td>
                    <td>
                        <div id="boxB" class="box"></div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div id="boxC" class="box"></div>
                    </td>
                    <td>
                        <div id="boxD" class="box"></div>
                    </td>
                </tr>
            </tbody>
        </table>
        <div class="form-group" id="board-button">
            <button class="btn btn-info" id="submit-answer">Xác Nhận</button>
            <button class="btn btn-default" id="withdraw-button">Dừng Cuộc Chơi</button>
            <button class="btn btn-info" id="help5050-button">50 : 50</button>
            <button class="btn btn-primary" id="helpSurvey-button">Ý Kiến Từ Khán Giả</button>
        </div>
        <div class="form-group" id="result-button">
            <button class="btn btn-success" id="next-question">Câu Tiếp Theo</button>
            <button class="btn btn-danger" id="restart-game">Bắt Đầu Lại</button>
        </div>
        <div class="notice">
            <div class="alert" id="alert"></div>
        </div>
    </div>
    <br>
    <div id="container" class="row">
  
        <div style="display: none" class="row" id="button">
            <button  id="prev-button">Lưu & Quay Lại</button>
            <button id="next-button">Lưu & Tiếp Tục</button>
            <button  id="reset-button">Làm Mới</button>
        </div>
    </div>
    <button class="btn btn-success" id="create-game-button">Bắt đầu</button>
    <div class="raw" id="reward"></div>
    <div class="raw" id="survey-region">
        <div class="surveyBoard">
            <div class="raw" id="chartA"></div>
            <div class="raw" id="chartB"></div>
            <div class="raw" id="chartC"></div>
            <div class="raw" id="chartD"></div>
        </div>
    </div>
    </div>
  </div>  
</body>
</html>