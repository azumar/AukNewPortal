<%-- 
    This  is  form for creating new UTME record
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <link rel="stylesheet" type="text/css" href="css/rawStyle.css">
        <link rel="stylesheet" href="css/bootstrap.css" />
        <link rel="stylesheet" href="css/bootstrap-responsive.css" />
        <link rel="stylesheet" href="css/custom.css" />
        <script src="js/jquery-1.11.0.js"></script>
        <script src="js/jquery.validate.js"></script>
        <title>Application Home Page</title>
    </head>
    <body>
        <div class="container"> <!-- start Container -->
            <!-- PAGE CONTENT 
            <div class="row"> --> 
            <h3></h3> 

            <section>
                <div class="row c-product-showcase">
                    <div class="span3"">
                        <a href="http://www.auk.edu.ng"><img src="img/Logo.png" alt="Logo" class="img-polaroid" /></a>
                        <h4><a href="http://www.auk.edu.ng">About Al-Qalam University</a></h4>
                        <p style="text-align: justify">Al-Qalam  University stands unique among others due to our resolve to produce not only students with academic excellence
                            but also with Islamic moral values and conduct to positively fit into the larger society.</p>

                        <a href="http://www.auk.edu.ng" cla    ss="btn">Learn More <span class="icon-chevron-right"></span></a>
                    </div>
                    <div class="span8">
                        <table class="table table-striped">

                            <c:forEach var="service" items="${services}">

                                <tr>
                                    
                                    <td>
                                        ${service.itemname}
                                       
                                    </td>

                                    <td>NGN ${service.itemamount}</td>

                                    <td>
                                        <form action="addToCart" method="post">
                                            <input type="hidden"
                                                   name="productId"
                                                   value="${product.id}">
                                            <input type="submit"
                                                   name="submit"
                                                   value="Add">
                                        </form>
                                    </td>
                                </tr>

                            </c:forEach>

                        </table>
                    </div>

                   
                </div>


            </section>

        </div> <!-- end Container -->
        <!--
        -->            </body>
</html>
