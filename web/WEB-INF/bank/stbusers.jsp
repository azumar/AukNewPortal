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
        <title>Bank Users</title>
    </head>
    <body>
        <section>
            <div class="row-image">   <img src="img/Logo.png" width="100px" height="50px" />

            </div>
        </section>

        <section>

            <div class="container">

                <div class="row">
                    <div class="span3">
                        <h3>Al-Qalam University Katsina</h3>
                        <ul>

                            <li>   <div class="btn" type="" name="" > <a href="sterlingAdmin">Add User</a></div></li>

                            <li>   <div class="btn" type="" name="" > <a href="changePassword">change Password</a></div></li>
                            <div class="btn" type="" name="" > <a href="logout">Logout</a></div>
                        </ul>

                    </div>

                    <div class="span9"><!-- Right Side where which holds form -->

                        <section>


                            <div class="row c-product-cta">



                            </div>

                            <div >
                                <form action="deleteBankUsers" method="post">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <td></td>
                                            <td>Name</td>
                                            <td>user Name</td>
                                            <td>Branch</td>
                                            <td>Mobile No.</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="user" items="${stbusers}">
                                            <tr>
                                                
                                                   <td>
                                                       <input type="checkbox"  name="username" value ="${user.username} "/>
                                                </td>
                                             
                                                <td>
                                                    ${user.name}    
                                                </td>
                                                <td>
                                                    ${user.username}    
                                                </td> 
                                                <td>
                                                    ${user.branch}
                                                </td>
                                                <td>
                                                    ${user.gsm}
                                                </td>
                                            </tr>

                                        </c:forEach>
                                    </tbody>
                                </table>
                                    <button class="btn" type="submit" name="delete">DELETE</a></button>
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
