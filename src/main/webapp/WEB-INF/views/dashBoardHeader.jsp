<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="row well" >
    <div>
        <div class="col-md-6 col-sm-6">
            <a class="a1 rowheader" style="text-decoration: none">Link Sharing</a>
        </div>
        <div class="col-md-6 col-sm-6">
            <div class="col-md-4 col-sm-4 searchbox">
                <div class="input-group ">
                    <span class="input-group-addon glyphicon glyphicon-search"></span>
                    <input id="headersearchtag" type="search" class="form-control" placeholder="search"></input>
                    <span class="input-group-addon glyphicon glyphicon-remove-sign"></span>
                </div>
            </div>
            <div class="col-md-4 col-sm-4" style="padding-right: 0">
                <a href="#" data-toggle="modal" data-target="#createTopicModel" style="outline-style: none;"><span class="glyphicon glyphicon-comment spanicons"></span></a>
                <a href="#" data-toggle="modal" data-target="#SendInvitationModel" style="outline-style: none;"><span class="glyphicon glyphicon-envelope spanicons"></span></a>
                <a href="#" data-toggle="modal" data-target="#linkedresourcemodel" style="outline-style: none;"><span class="glyphicon glyphicon-link spanicons"></span></a>
                <a href="#" data-toggle="modal" data-target="#documentresourcemodel" style="outline-style: none;"><span class="glyphicon glyphicon-copy spanicons"></span></a>
            </div>
            <div class="col-md-4 col-sm-4">
                <div class="col-md-3 col-sm-4">
                    <a href="userProfilePage" class="pull-right"><img class="media-object" src="/UserProfilePic?uname=${username}" style="background-size: 100% 100%;  width:37px; height: 37px"></a>
                </div>
                <div class="col-md-9 col-sm-4 pull-right" style="padding: 0;margin-right: 0">
                    <span class="dropdown" style="float: right">
                        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">${username}
                        <span class="caret"></span></button>
                            <ul class="dropdown-menu">
                                <li><a href="/userProfilePage">Profile</a></li>
                               <c:if test="${admin}">
                                <li><a href="logOut">Users</a></li>
                                <li><a href="logOut">Topics</a></li>
                                <li><a href="logOut">Posts</a></li>
                               </c:if>
                                <li><a href="/logout">Logout</a></li>
                            </ul>
                    </span>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
