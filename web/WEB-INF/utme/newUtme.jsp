<%-- 
    This  is  form for creating new UTME record
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
        <script type="text/javascript" src="js/jquery.validate.js"></script>
         <script type="text/javascript" src="js/script.js"></script>
        <title>new Utme</title>
    </head>
    <body>
        <script type="text/javascript">
             
            $(document).ready(function() {
               
                $("#newUtm").validate({
                    rules: {
                        jambNo: "required",
                        names: {
                            required: true
                        }

                    }
                });
            });
        </script>
        <div class="container"> <!-- start Container -->
            <div class="row"> <!-- start row -->

                <div class="span2"> <!-- start left bar-->
                    <h3>Adding new Record</h3>
                </div>  <!-- end left bar-->
                <div class="span10"> <!-- start right bar-->
                    <section>
                        <h4> New UTME Candidate</h4>
                        <c:if test="${!empty validationErrorFlag}">
                            <h4 class="error"> Candidate Already Exist, Check The Jamb No and Try Again. </h4>
                                
                        </c:if>

                        <hr/>
                        <form  id="newUtm" class="form-horizontal centeredForm" action="addUtme" method="post">
                            <div class="control-group">
                                <label class="control-label">Jamb No.</label>
                                <div class="controls"><input type="text" placeholder="Jamb No"  name="jambNo" id="jambNo"/></div>			
                            </div>

                            <div class="control-group">
                                <label class="control-label">Names</label>
                                <div class="controls"><input type="text" placeholder="Names" name="names" id="name" /></div>			
                            </div>
                            <div class="control-group">
                                <label class="control-label">State</label>
                                <div class="controls"><input type="text" placeholder="State" name="state" /></div>			
                            </div>
                            <div class="control-group">
                                <label class="control-label">LGA</label>
                                <div class="controls"><input type="text" placeholder="LGA"  name="lga"/></div>			
                            </div>
                            <div class="control-group">
                                <label class="control-label">SEX</label>
                                <div class="controls"><select name="sex">
                                        <option >M</option>
                                        <option >F</option>
                                    </select>	
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Subject 2</label>
                                <div class="controls"><input type="text" placeholder="Subject 2" name="subject2" /></div>			
                            </div>
                            <div class="control-group">
                                <label class="control-label">Subject 3</label>
                                <div class="controls"><input type="text" placeholder="Subject 3" name="subject3"  /></div>			
                            </div>
                            <div class="control-group">
                                <label class="control-label">Subject 4</label>
                                <div class="controls"><input type="text" placeholder="Subject 4"  name="subject4" /></div>			
                            </div>
                            <div class="control-group">
                                <label class="control-label">Total Score</label>
                                <div class="controls"><input type="text" placeholder="Total Score"  name="totalScore" /></div>			
                            </div>

                            <div class="control-group">
                                <label class="control-label">Course</label>
                                <div class="controls">
                                    <select name="course">
                                        <option > SELECT </option>
                                        <c:forEach var="program" items="${programs}">
                                            <option>${program.programName}</option>
                                        </c:forEach>


                                    </select>	
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label">Department Decision</label>
                                <div class="controls">
                                    <select name="status">

                                        <option >Not decided</option>
                                        <option >Accepted</option>
                                        <option >Rejected</option>
                                    </select>	
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Application Type</label>
                                <div class="controls">
                                    <select name="applicationType"  >
                                        <option > SELECT</option>
                                        <c:forEach var="type" items="${types}">
                                            <option>${type.typeName}</option>
                                        </c:forEach>

                                    </select>	
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Post UTME Score</label>
                                <div class="controls"><input type="text" placeholder="Post UTME"  name="pume"/></div>			
                            </div>
                            <div class="control-group">
                                <label class="control-label">Session</label>
                                <div class="controls"><select name="session">
                                        <option >20014/2015</option>
                                        <option >2015/2016</option>
                                    </select>	
                                </div>
                            </div>
                            <div class="control-group">
                            <label class="control-label">Email</label>
                            <div class="controls"><input type="text" placeholder="Email"  name="email"  /></div>			
                        </div>
                        <div class="control-group">
                            <label class="control-label">GSM</label>
                            <div class="controls"><input type="text" placeholder="GSM"  name="gsm" value="" /></div>			
                        </div>
                            <div class="control-group">
                                <label class="control-label">Admitted</label>
                                <div class="controls"><input type="checkbox" name="admitted"  /></div>			
                            </div>

                            <div class="control-group">
                                <div class="controls">
                                    <button type="submit" class="btn" >Insert</button>
                                    <button type="reset" class="btn" >Clear</button>
                                </div>
                            </div>
                        </form> <!--            end form-->
                    </section>

                </div> <!-- end right bar-->
            </div> <!-- end row-->


        </div> <!--end container-->


        <!--
-->            </body>
        </html>
