<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html> -->

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- button custon css -->
        <link href="css/app.css" rel="stylesheet">
        <!-- button hover css -->
        <link href="css/hover.css" rel="stylesheet">
        <!-- button hover css -->
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <!-- Releway font -->
        <link href='https://fonts.googleapis.com/css?family=Helvetica:400,100italic,200,200italic,300,300italic,400italic,500,500italic,600,600italic,700,800italic,900,900italic' rel='stylesheet' type='text/css'>
      

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript">
 
    $(function () {
        $("#password").bind("keyup", function () {
            //TextBox left blank.
            var value ='<?php echo $valu ?>';
            if ($(this).val().length == 0) {
                $("#password_strength").html("");
                return;
            }
 
            var passed=0;
            //Validate for length of Password.
            if ($(this).val().length >= 6) {
                passed++;
            }
            else if($(this).val().length < 6){
                passed=0;
            }
 
            var color = "";
            var strength = "";
            if(passed==0){
                    strength = "Minimum length to be 8";
                    color = "white";
                    document.getElementById("mySubmit").disabled = true;
                    document.getElementById("password_strength").innerHTML=strength;
                }
                else{
                 strength=""
                    document.getElementById("mySubmit").disabled = false;
                }
            $("#password_strength").html(strength);
            $("#password_strength").css("color", color);
   
        });
      });
      </script>
    </head>
    <body >
        <%
            /* String email = request.getParameter("email");
            try {
                Statement statement = getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet resultSet = statement.executeQuery("select * from signup where email = '" + email + "'");
                if (resultSet.next()) { */
                
        %>
        <center> 
        <div class="modal-dialog" style="width: 320px; margin-top:100px;">

            <div class="modal-content" style="background-image: url('images/bg.png')">
                <div class="modal-header">

                    <center><img class="modal-title" src="images/logos.png" style="margin-top: 30px; width: 70%; height: 100px; "/></center>
                </div>
                <div class="modal-body">
                    <span id="password_strength"></span>
                    <form method="post" action='change_password.jsp' name="login_form" class="loginmodal-container">
                        <input type="hidden"  name="email" id="email" value="<%=/* email */%>">
                        <center> 
                        <p>                    
                            <input type="text"  name="password" id="password" placeholder="Password" required>
                        </p> 
                        <p>
                            <input type="password" name="conpassword" placeholder="Confirm Password" required>
                        </p> 
                       
                        <p><button type="submit" id="mySubmit" class="btn btn-default">Change Password</button>
                            <button type="reset" class="btn btn-default" data-dismiss="modal" onclick="javascript:window.close()">Cancel</button>
                        </p>
                        </center>
                    </form>
                </div>
               
            </div>
        </div>
         </center>                
                        <%
               /*              } else {
                    out.print("<h1>Invalid Email id</h1>");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } */
%>

    </body>
</html>