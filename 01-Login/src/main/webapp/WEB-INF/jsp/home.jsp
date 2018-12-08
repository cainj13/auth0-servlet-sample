<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>OIDC Sample Web App</title>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/css/jumbotron-narrow.css">
    <link rel="stylesheet" type="text/css" href="/css/home.css">
    <link rel="stylesheet" type="text/css" href="/css/jquery.growl.css"/>
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="/js/jquery.growl.js" type="text/javascript"></script>
</head>

<body>

<div class="container">
    <div class="header clearfix">
        <nav>
            <ul class="nav nav-pills pull-right">
                <li class="active" id="home"><a href="#">Home</a></li>
                <li id="qsLogoutBtn"><a href="#">Logout</a></li>
            </ul>
        </nav>
        <h3 class="text-muted">OIDC Sample Web App</h3>
    </div>
    <div class="jumbotron">
        <h3>Hello ${userId}!</h3>
    </div>
    <div class="alert alert-info">
        <h4>Last Page View (current session)</h4>
        ${lastSeen}
    </div>
    <div>
        <code>${details}</code>
    </div>
    <div class="row marketing">
        <div class="col-lg-12">
            <h4>I am a server-side web application</h4>
            <p>Written in Java, sporting servlet API support.  Sure, the kids these days aren't talking about my architecture... but I was the "serverless" before there was such a misnomer.  Look at a Lamba Handler definition, then look at the servlet API, now back at Lamba.  Seem familiar?  That's because servlets generalized the same problem that is being re-solved all over again.  You're welcome.</p>
        </div>
    </div>

    <footer class="footer">
        <div>
            Icons made by <a href="https://www.flaticon.com/authors/smashicons" title="Smashicons">Smashicons</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a>
        </div>
    </footer>

</div>

<script type="text/javascript">
    $("#qsLogoutBtn").click(function(e) {
        e.preventDefault();
        $("#home").removeClass("active");
        $("#password-login").removeClass("active");
        $("#qsLogoutBtn").addClass("active");
        // assumes we are not part of SSO so just logout of local session
        window.location = "${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, '')}/logout";
    });
</script>

</body>
</html>
