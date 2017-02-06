<%--
  Created by IntelliJ IDEA.
  User: Natasha
  Date: 14/12/2016
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Frequently asked questions</title>

    <link rel="icon" type="image/png" href="paperkit/assets/paper_img/favicon.ico">
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    <link href="paperkit/bootstrap3/css/bootstrap.css" rel="stylesheet" />
    <link href="paperkit/assets/css/ct-paper.css" rel="stylesheet"/>
    <link href="paperkit/assets/css/demo.css" rel="stylesheet" />
    <link href="paperkit/assets/css/main.css" rel="stylesheet" />

    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>

    <style>
        /* Buttons that open and close the accordion panel */
        button.accordion {
            background-color: orange;
            color: #444;
            cursor: pointer;
            padding: 18px;
            width: 80%;
            text-align: left;
            border: none;
            outline: none;
            transition: 0.4s;
        }

        /* Background color of button(question) when onclicked and mouse-over */
        button.accordion.active, button.accordion:hover {
            background-color: deepskyblue;
        }

        div.panel {
            padding: 0 18px;
            background-color: white;
            display: none;
        }

        /* When user selects button(question), this function shows what user see in the content(answer)*/
        div.panel.show {
            display: block;
        }
    </style>
</head>

<%@ page import="natasha.* , java.util.*"%>
<%
    List<FaqDetails> faqs = (List<FaqDetails>)request.getAttribute("faqs");
%>

<body>
<!--    navbar come here          -->
<nav class="navbar navbar-ct-primary">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="#">HealthHub</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navigation-example-2">
            <ul class="nav navbar-nav">
                <li>
                    <a href="home.html" class="btn">Home</a>
                </li>
                <li>
                    <a href="selectmap.html" class="btn">Map</a>
                </li>
                <li>
                    <a href="faq.html" class="btn">FAQ</a>
                </li>
                <!--Need to amend href link to login.html-->
                <li>
                    <a href="#" class="btn">Login</a>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-->
</nav>
<!-- end navbar  -->
<div class = "wrapper">
    <div class="main">
        <div class ="container">
            <div class="row">
                <div class="col-md-3">
                    <button class="btn btn-primary btn-fill btn-block" onClick="location.href='/faq.html'">Select another topic</button>
                </div>
                <div class="col-md-12">
                    <div class="col-md-10">
                        <% for (FaqDetails faq : faqs) { %>
                            <h5>Category: <%=faq.getCategory()%></h5>
                            <button class="accordion">
                                <p>Qn:<%= faq.getQuestion()%></p>
                            </button>
                            <div class ="panel">
                                <p><%=faq.getAnswer()%></p>
                            </div>
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    var acc = document.getElementsByClassName("accordion");
    var i;

    for (i = 0; i < acc.length; i++) {
        acc[i].onclick = function(){
            this.classList.toggle("active");
            this.nextElementSibling.classList.toggle("show");
        }
    }
</script>
<script src="paperkit/assets/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="paperkit/assets/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="paperkit/bootstrap3/js/bootstrap.js" type="text/javascript"></script>
<script src="paperkit/assets/js/ct-paper.js"></script>
</html>
