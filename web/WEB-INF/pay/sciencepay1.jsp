<%--
    Document   : index
    Created on : Jun 9, 2010, 3:59:32 PM
    Author     : tgiunipero
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
<div id="span3">
    <div id="welcomeText">
        <p style="font-size: larger">Welcome to AUK.</p>

        <p>Science Payment.</p>
    </div>
</div>

<div id="span6">
    
   
    <table id="productTable">

        <c:forEach var="service" items="${services}" varStatus="iter">

            <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                <td>
                   
                         alt="${service.itemname}">
                </td>

                <td>
                    ${service.itemname}
                    <br>
                    <span class="smallText">$</span>
                </td>

                <td>&euro; ${service.itemamount}</td>

                <td>
                    <form action="addToCart" method="post">
                        <input type="hidden"
                               name="productId"
                               value="${product.id}">
                        <input type="submit"
                               name="submit"
                               value="add to cart">
                    </form>
                </td>
            </tr>

        </c:forEach>

    </table>
</div>
</div>