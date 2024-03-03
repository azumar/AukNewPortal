<%-- 
    Document   : feeone
    Created on : Dec 5, 2015, 2:50:57 PM
    Author     : Philip.Webmaster
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  
    <body>
        <div class="wrapper">

        <div class="content">
            <div class="container">
         <div class="wrap">
      
<!--        <img src="resources/images/auk.jpg" width="350"> -->

        <form role="form" action="https://portal.auk.edu.ng/alqalamfees/transactions/dopayment" method="POST">
	<div class="form-group">
			<label for="name">Fullname</label> <input type="text" required="required"
				class="form-control" id="name" name="name" >
		</div>
		<div class="form-group">
			<label for="email">Email </label>
			 <input type="email" required="required"
				class="form-control" id="email" name="email" >
		</div>
		<div>
			<input type="hidden" name="callback" value="https://portal.auk.edu.ng/alqalamfees/feeone/">
			<input type="hidden" name="payitemid" value="101" />
			<input type="hidden" name="feename" value="stanbic demo" />
		</div>


		<div class="form-group">
			<label for="usermac">GSM </label>
			<input required="required"
				maxlength="20" type="text" class="form-control" id="mobile" name="mobile">
		</div>

		<div class="form-group">
			<label for="studentid">Student ID </label> <input type="text" required="required"
				class="form-control" id="studentid" name="studentid">
		</div>

		<div class="form-group">
			<label for="Amount">Amount</label>
                        <input type="text" required="required" class="form-control" id="amount" name="amount" value="100000">
		</div>	
            <div>
                <input name="amt1" type="hidden" value="2492500" />
                <input name="amt2" type="hidden" value="2492500" />
                <input name="amt3" type="hidden" value="2492500" />
                <input name="amt4" type="hidden" value="2492500" />
                <input name="bankcode1" type="hidden" value="117" />
                <input name="bankcode2" type="hidden" value="117" />
                <input name="bankcode3" type="hidden" value="117" />
                <input name="bankcode4" type="hidden" value="121" />
                <input name="acct1" type="hidden" value="1010817125" />
                <input name="acct2" type="hidden" value="1010817125" />
                <input name="acct3" type="hidden" value="1010817125" />
                <input name="acct4" type="hidden" value="0010135766" />
            </div>

		<button type="submit" class="btn btn-default">Submit</button>
	</form>
  		
  	</div> 
            </div></div></div>
    </body>
</html>
