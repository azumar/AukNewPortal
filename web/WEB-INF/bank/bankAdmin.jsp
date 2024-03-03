<%-- 
    Document   : bank
    Created on : Jul 12, 2015, 6:58:34 AM
    Author     : Armayau
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/rawStyle.css">
        <link rel="stylesheet" href="css/bootstrap.css" />
        <link rel="stylesheet" href="css/bootstrap-responsive.css" />
        <link rel="stylesheet" href="css/custom.css" />
        <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
        <script type="text/javascript" src="js/jquery.validate.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
        <title>Bank Administrator Interface</title>
    </head>
    <body>
<script type="text/javascript">
             
            $(document).ready(function() {
               
                $("#bankUser").validate({
                    rules: {
                        names: "required",
                        password:"required",
                        branch: "required",
                       username: {
                            required: true
                        }

                    }
                });
            });
        </script>
        
        <section>
            <div class="row-image">   <img src="img/Logo.png" width="100px" height="50px" f/>

            </div>
        </section>

        <section>
            <div class="container">
                <div class="row">
                    <div class="span3">
                           <h4>Bank Admin Interface</h4>
                            <h6> Admin: ${"   "}${name} </h6>
                        <ul>
                            <li><div class="btn" type="" name="" > <a href="bankUsers">Show Users</a></div></li>
                            <li>   <div class="btn" type="" name="" > <a href="">Add User</a></div></li>
                            <li>   <div class="btn" type="" name="" > <a href="changePassword">change Password</a></div></li>
                             <div class="btn" type="" name="" > <a href="logout">Logout</a></div>
                        </ul>
                    </div>
                    <div class="span9"><!-- Right Side where which holds form -->
                        <section>
                         

                            <div class="row c-product-cta">
                            </div>
                            <div >
                                <form id="bankUser" class="form-horizontal" action="addBankUser" method="post" >
                                    <div class="control-group">
                                        <label class="control-label">Name.</label>
                                        <div class="controls"><input type="text" id="names" placeholder="Names" name="names" /></div>			
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">User Name</label>
                                        <div class="controls"><input type="text" placeholder="user Name"  name="username"/></div>			
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">Password </label>
                                        <div class="controls"><input type="password"  placeholder="password" name="password"/></div>			
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">Branch </label>
                                        <div class="controls"><input type="text"  placeholder="Bank Branch" name="branch"/></div>			
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">GSM </label>
                                        <div class="controls"><input type="text"  placeholder="Mobile No." name="gsm"/></div>			
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">User Type</label>
                                        <div class="controls"><select name="userType">
                                                <option >User</option>
                                                <option >Admin</option>
                                            </select>	
                                        </div>
                                        <div class="control-group">
                                            <div class="controls">
                                                <button type="submit" class="btn" >Submit</button>
                                                <button type="reset" class="btn" >Reset</button>
                                            </div>
                                        </div>
                                    </div>
                                </form>

                            </div>
                        </section>

                    </div> 

                </div>

                <hr />
            </div> <!-- end container -->
        </section>
    </body>
</html>

