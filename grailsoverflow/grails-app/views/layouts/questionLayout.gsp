<!DOCTYPE html>

<%@page import="fr.isima.grailsoverflow.User" %> 

<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> 
<html lang="en" class="no-js"><!--<![endif]-->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title><g:layoutTitle default="Grails"/></title>

        <link type="text/css" href="${resource(dir: 'css/bootstrap', file: 'bootstrap.min.css')}" rel="stylesheet">
        <g:javascript src="jquery.min.js"/>
        <g:javascript src="jquery-ui.min.js"/>
        <g:javascript src="bootstrap/bootstrap.min.js" />
        
        <g:layoutHead/>
    <r:layoutResources />
</head>
<body>
    <div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
        <div class="container">
            <!-- Navigation bar -->
            <div class="navbar-header">
                <g:link class="navbar-brand" controller="question" action="index">
                    GrailsOverflow
                </g:link>

                <!-- Left side  -->
                <ul class="nav navbar-nav">
                    <li><g:link controller="question" action="index">Latest</g:link></li>
                    <li><g:link controller="unaccepted" action="index">Unaccepted</g:link></li>
                    </ul>
                </div>
                <!-- Right side -->
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                    <g:if test="${User.isUserAuthenticated() == true}">
                        <li>
                            <g:link controller="question" action="add">
                                New question
                            </g:link>
                        </li>
                        <li>
                            <a>${User.getCurrentUserFromDB().displayName} (${User.getCurrentUserFromDB().score} pts)</a>
                        </li>
                        <li>
                            <g:set var="targetUri" value="${request.forwardURI - request.contextPath}" scope="session" />
                            <g:link controller="authenticate" action="logout">
                                logout
                            </g:link>
                        </li>
                    </g:if>
                    <g:else>
                        <li>
                            <g:set var="targetUri" value="${request.forwardURI - request.contextPath}" scope="session" />
                            <oauth:connect provider="google" id="google-connect-link">Google Connection</oauth:connect>
                        </li>
                    </g:else>
                </ul>
            </div>
        </div>
    </div>

    <div class="container">
        <g:layoutBody/>

        <hr>

        <footer>
            <p>© GrailsOverflow 2013</p>
        </footer>
    </div>
    <g:javascript library="application"/>
<r:layoutResources />
</body>
</html>
