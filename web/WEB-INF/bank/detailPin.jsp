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
        <title>Print Slip</title>
    </head>
    <body>

        <script type="text/javascript">

            function printDiv(divName) {
                //alert('s');
//                var printContents = document.getElementById(divName).innerHTML;
//                w = window.open();
//                w.document.write(printContents);
//                w.print();
//                w.close();
window.print();

            }
        </script>
        <section>
            <div class="row-image">   <img src="img/Logo.png" width="100px" height="50px" f/>

            </div>
        </section>

        <section>

            <div class="container">

                <div class="row">
                    <div class="span3">
                                                 

                    </div>

                    <div class="span9"><!-- Right Side where which holds form -->

                        <section>
                            <!--                            printable area-->

                            <div id="print-content">
                                  <h4>Al-Qalam University, Katsina</h4>   
                                <h5>  Use the Access Code to login  to  http://portal.auk.edu.ng/AukNewPortal/sourcedUtme </h5>
                                <h6> Need help? call  07067699020/08081094680 </h6>
                                <div class="row c-product-cta">

                                </div>

                                <form class="form-horizontal" action="bank" method="post">
                                    <div class="control-group">
                                        <label class="control-label">Pin Serial No.</label>
                                        <div class="controls"><input type="text" value="4353535353-${selectedPin.pinPK.pinId}" readonly="readonly" /></div>			
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">User Id</label>
                                        <div class="controls"><input type="text" value="${selectedPin.userName}" readonly="readonly"  /></div>			
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">Access Code. /Password</label>
                                        <div class="controls"><input type="text" value="${selectedPin.pinPK.accessCode}" readonly="readonly" /></div>			
                                    </div>


                                    <div class="control-group">
                                        <label class="control-label">Other Names</label>
                                        <div class="controls"><input type="text" value="${selectedPin.otherNames}" readonly="readonly"  /></div>			
                                    </div>
                                    <input class="btn" type="button" onclick="printDiv('print-content')" value="print Slip"/>
                            </div> <!--            end                printable area-->


                            <div class="btn" type="" name="" > <a href="bank" >Back</a></div>

                            </form>


                        </section>

                    </div> 

                </div>

                <hr />
            </div> <!-- end container -->
        </section>
    </body>
</html>
