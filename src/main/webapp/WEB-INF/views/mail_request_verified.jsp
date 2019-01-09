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
    <title> Verification </title>
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
        
    </head>
    <body >
 
        <center> 
        <div class="modal-dialog" style="width: 320px; margin-top:100px;">

            <div class="modal-content" style="background-image: url('resources/images/grey_gradient_bg.png')">
                <div class="modal-header">

                    <center><img class="modal-title" src="resources/images/quotabase.png" style="margin-top: 30px; width: 70%; height: 100px; "/></center>
                </div>
                <div class="modal-body">
                    <span id="password_strength"></span>
                    <form method="post" action='change_password.jsp' name="login_form" class="loginmodal-container">
                        <input type="hidden"  name="email" id="email" value="">
                        <center> 
                        <p>                    
                            <input type="text" name="verified_by" id="verified_by" placeholder="Verified by" required>
                        </p> 
                        <p>
                            <input type="text" name="quota_attainment_verified" id="quota_attainment_verified" placeholder="Quota Attainment Verified" required>
                        </p> 
                        
                        <p>                    
                            <input type="text"  name="tracked" id="tracked" placeholder="Tracked" required>
                        </p> 
                        <p>
                            <input type="text" name="average_deal_size_verified" id="average_deal_size_verified" placeholder="Average Deal Size Verified" required>
                        </p> 
                        
                        <p>                    
                            <input type="text"  name="average_sales_cycle_verified" id="average_sales_cycle_verified" placeholder="Average Sales Cycle Verified" required>
                        </p> 
                        <p>
                            <input type="text" name="year_of_experiance_verified" id="year_of_experiance_verified" placeholder="Year of Experiance Verified" required>
                        </p> 
                        
                        <p>                    
                            <input type="text"  name="target_market_verified" id="target_market_verified" placeholder="Target Market Verified" required>
                        </p> 
                        <p>                    
                            <input type="text"  name="total_sales_2018_verified" id="total_sales_2018_verified" placeholder="Total Sales in 2018 Verified" required>
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

    </body>
</html>