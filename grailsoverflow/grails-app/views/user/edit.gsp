<%@ page contentType="text/html;charset=UTF-8" %>

<%@page import="fr.isima.grailsoverflow.AppConfig; fr.isima.grailsoverflow.User" %>

<html>
<head>
    <meta name="layout" content="questionLayout"/>
    <title>GrailsOverflow - User</title>

    <link type="text/css" href="${resource(dir: 'css', file: 'question.css')}" rel="stylesheet">
    <link type="text/css" href="${resource(dir: 'css', file: 'user.css')}" rel="stylesheet">
</head>

<body>
<div class="row row-offcanvas row-offcanvas-right">
    <div class="col-xs-18 col-sm-12">
        <div class="page-header">
            <div class="row">
                <div class="col-xs-10 col-sm-11">
                    <h1>User <small>${user.displayName}</small></h1>
                </div>
                <div class="col-xs-3 col-sm-1">
                    <g:link controller="user" action="show" params='[id: "${user.id}"]'>
                        <button type="button" class="btn btn-default rightButton">
                            <span class="glyphicon glyphicon-user"></span>
                            Show
                        </button>
                    </g:link>
                </div>
            </div>
        </div>

        <div class="row">
            <g:form action="editInfo">

                <input name="id" type="hidden" class="form-control" id="id" value="${user.id}">

                <div class="form-group">
                    <label for="displayName">Display name</label>
                    <input name="displayName" type="text" class="form-control" id="displayName" value="${user.displayName}" placeholder="Your display name ...">
                </div>
                <div class="form-group">
                    <label for="website">Website</label>
                    <input name="website" type="text" class="form-control" id="website" value="${user.website}" placeholder="Your website ...">
                </div>
                <div class="form-group">
                    <label for="location">Location</label>
                    <input name="location" type="text" class="form-control" id="location" value="${user.location}" placeholder="Your location ...">
                </div>

                <button type="submit" class="btn btn-default btn-lg">
                    <span class="glyphicon glyphicon-ok"></span> Save profile
                </button>
            </g:form>
        </div>
    </div>
</div>
</body>
</html>