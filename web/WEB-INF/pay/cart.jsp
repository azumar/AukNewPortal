<%--
    This  is  form for creating new UTME record
--%>

<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="helper.PaymentHashedGenerator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title> Post UTME Application</title>
    </head>
    <body>
        <div class="row">
            <div class="span3" >
                <a href="http://www.auk.edu.ng"><img src="img/custom/Logo.png" alt="Logo" class="img-polaroid" /></a>
                <h5> Al-Qalam University, Katsina</h5>
            </div>
            <div class ="span8">
                
                    <div class="">
                        <c:choose>
                            <c:when test="${cart.numberOfItems > 1}">
                                <p>  ${studentDetails.firstname}   (${studentDetails.studentid})Your Registration cart contains ${cart.numberOfItems} items.</p>
                            </c:when>
                            <c:when test="${cart.numberOfItems == 1}">
                                <p> ${studentDetails.firstname} ${studentDetails.firstname}  (${studentDetails.studentid})Your Registration cart contains ${cart.numberOfItems} item.</p>
                            </c:when>
                            <c:otherwise>
                                <p>Your Registration cart is empty.</p>
                            </c:otherwise>
                        </c:choose>

                        <div id="actionBar">
                            <%-- clear cart widget --%>
                            <c:if test="${!empty cart && cart.numberOfItems != 0}">
                                <p>    <a href="viewCart?clear=true" class="bubble hMargin">Restart Registration</a> </p>
                            </c:if>

                            <%-- continue shopping widget --%>
                            <c:set var="value">
                                <c:choose>
                                    <%-- if 'selectedCategory' session object exists, send user to previously viewed category --%>
                                    <c:when test="${!empty selectedCategory}">
                                        pay
                                    </c:when>
                                    <%-- otherwise send user to welcome page --%>
                                    <c:otherwise>
                                        pay
                                    </c:otherwise>
                                </c:choose>
                            </c:set>

                            <a href="${value}" class="bubble hMargin">continue registration</a>

                            <%-- checkout widget --%>

                        </div>
                    </div>

                    <c:if test="${!empty cart && cart.numberOfItems != 0}">
                        <form>

                            <h4 id="subtotal">subtotal:  &#x20A6; ${cart.subtotal}</h4>
                            <div>
                                <input type="hidden" name="studentid" value="  ${studentDetails.studentid}" />
                        <input type="hidden" name="name" value=" ${studentDetails.firstname} ${studentDetails.firstname}" />
                        <input type="hidden" name="email" value=" ${studentDetails.email}" />
                        <input type="hidden" name="mobile" value=" ${studentDetails.phone}" />
                         <input type="hidden" name="mobile" value="  ${cart.subtotal}" />
                            </div>
                                                        
                            <table class="table table-bordered table-striped">

                                <tr class="header">
                                    <th>Service</th>

                                    <th>Fees</th>

                                </tr>

                                <c:forEach var="cartItem" items="${cart.items}" varStatus="iter">

                                    <c:set var="product" value="${cartItem.payitem}"/>

                                    <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">


                                        <td>${product.itemname}</td>

                                        <td>
                                            &#x20A6; ${cartItem.total}

                                        </td>


                                    </tr>


                                </c:forEach>
                                <tr>
                                    <td></td>
                                    <td>  <button type="submit" class="btn btn-default">Process Payment</button></td>
                                </tr>
                            </table>
                        </form>
                    </c:if>
<!--                </div>-->
            </div>
        </div>
    </body>
    <!--
    -->
</html>
