<%--
  Created by IntelliJ IDEA.
  User: ankur
  Date: 10/9/17
  Time: 12:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/welcomepage.css"/>
</head>
<body class="body" style="background:url('${pageContext.request.contextPath}/resources/backgroundimages/mybag.jpg');height:100vh;background-position: center;
        background-repeat: no-repeat;background-size:cover;width:100%;">
<div class="form-gap" style="padding-top: 70px;"></div>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="text-center">
                        <h1 class="text-center">${errorMsg}</h1>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
