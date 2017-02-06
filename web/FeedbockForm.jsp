<%--
  Created by IntelliJ IDEA.
  User: Jervis
  Date: 5/2/2017
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Feeedback Form</title>

    <link rel="icon" type="image/png" href="paperkit/assets/paper_img/favicon.ico">
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    <link href="paperkit/bootstrap3/css/bootstrap.css" rel="stylesheet" />
    <link href="paperkit/assets/css/ct-paper.css" rel="stylesheet"/>
    <link href="paperkit/assets/css/demo.css" rel="stylesheet" />


    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>

    <link href="css/bootstrap.css" rel="stylesheet"/>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/datepicker3.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">


    <%
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String feedback = request.getParameter("feedback");

        if (name != null){
            session.setAttribute("name", name);
            session.setAttribute("email", email);
            session.setAttribute("mobile", mobile);
            session.setAttribute("feedback", feedback);
        }
        else
        {
            name = (String)session.getAttribute("name");
            email = (String)session.getAttribute("email");
            mobile = (String)session.getAttribute("mobile");
            feedback = (String)session.getAttribute("feedback");
        }
    %>

</head>

<body>
<!--    navbar come here          -->
<nav class="navbar navbar-ct-primary">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                <span class="sr-only">Toggle navigation</span>
            </button>
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
                    <a href="#" class="btn">FAQ</a>
                </li>
                <!--Need to amend href link to login.html-->
                <li>
                    <a href="FeedbockForm.jsp" class="btn">Feedback</a>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-->

</nav>
<!-- end navbar  -->


        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">Add Feedback</div>
                <div class="panel-body">
                    <div class="col-md-6">
                        <form role="form" action="/feedbackform">

                            <div class="form-group">
                                <label>Name:</label>
                                <input class="form-control" id="name" name="name" placeholder="Full Name">
                            </div>

                            <div class="form-group">
                                <label>Email:</label>
                                <input class="form-control" id="email" name="email" type="email" placeholder="Email">
                            </div>

                            <div class="form-group">
                                <label>Mobile Number:</label>
                                <input class="form-control" id="mobile" name="mobile" placeholder="Mobile No.">
                            </div>

                            <div class="form-group">
                                <label>Feedback</label>
                                <textarea class="form-control" rows="5" name="feedback" id="feedback">
									</textarea>

                                <button type="submit" class="btn btn-primary" id="add">Submit Button</button>
                                <button type="reset" class="btn btn-default">Reset Button</button>
                            </div>
                        </form>
                    </div>
                </div>
                </div><!-- /.col-->
        </div><!-- /.row -->
    </div>


</body>
</html>
