<%-- 
    This  is  form for creating new UTME record
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width">
        <link rel="stylesheet" type="text/css" href="css/rawStyle.css">
        <link rel="stylesheet" href="css/bootstrap.css" />
        <link rel="stylesheet" href="css/bootstrap-responsive.css" />
        <link rel="stylesheet" href="css/custom.css" />
        <script src="js/jquery-1.11.0.js"></script>
        <script src="js/jquery.validate.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
        <title>pre degree application</title>
    </head>
    <body>
        <script type="text/javascript">

            $(document).ready(function() {

                $("#predegree").validate({
                    rules: {
                        surname: "required",
                        firstName: "required",
                        state: "required",
                        lga: "required",
                        gsm: "required",
                        address: "required",
                        lschool: "required",
                        dob: {
                            required: true


                        }


                    }
                });
                $("#res1").hide();
                $("#res2").hide();
                $("#s2").hide();
                $("#addresult1").click(function() {
                    $("#res1").show();
                    $("#s1").hide();
                    $("#s2").show();
                });
                $("#addresult2").click(function() {
                    $("#res2").show();
                     $("#addresult2").hide();
                    //  $("#s2").show();
                });

            });


        </script>
        <div class="container"> <!-- start Container -->
            <div class="row"> <!-- start row -->

                <hr/>

                <div class="span3"> <!-- start left bar-->
                    <h4>Al-Qalam University, Katsina</h4>
                    <a href="http://www.auk.edu.ng"><img src="img/Logo.png" alt="Logo" class="img-polaroid" /></a>
                    <h4><a href="http://www.auk.edu.ng">About Al-Qalam University</a></h4>
                    <p style="text-align: justify">Al-Qalam  University stands unique among others due to our resolve to produce not only students with academic excellence
                        but also with Islamic moral values and conduct to positively fit into the larger society.</p>

                    <a href="http://www.auk.edu.ng" cla    ss="btn">Learn More <span class="icon-chevron-right"></span></a>
                </div>  <!-- end left bar-->
                <div class="span5"> <!-- start right bar-->
                    <section>
                        <c:if test="${empty ijmbCandidate}">
                            <form  id="predegree" name="predegree" class="form-horizontal centeredForm" action="save_ijmb" method="post">
                                <h5></h5>

                                <div class="control-group">
                                    <label class="control-label">Sur name</label>
                                    <div class="controls"><input type="text" placeholder="Sur Name"  name="surname" id="surname"/></div>			
                                </div>

                                <div class="control-group">
                                    <label class="control-label">First Name</label>
                                    <div class="controls"><input type="text" placeholder="First Name" name="firstName" id="firstName" /></div>			
                                </div>
                                <div class="control-group">
                                    <label class="control-label">Other Name</label>
                                    <div class="controls"><input type="text" placeholder="Other Name" name="oName" /></div>			
                                </div>
                                <div class="control-group">
                                    <label class="control-label">Date of Birth</label>
                                    <div class="controls"><input type="text" placeholder="DD/MM/YYYY"  name="dob"/></div>			
                                </div>
                                <div class="control-group">
                                    <label class="control-label">State of Origin</label>
                                    <div class="controls"><input type="text" placeholder="State of Origin"  name="state"/></div>			
                                </div>
                                <div class="control-group">
                                    <label class="control-label">Local Government Area</label>
                                    <div class="controls"><input type="text" placeholder="Local Government Area"  name="lga"/></div>			
                                </div>
                                <div class="control-group">
                                    <label class="control-label">Permanent Home Address</label>
                                    <div class="controls"><textarea   name="address"> Permanent Home Address </textarea></div>			
                                </div>
                                <div class="control-group">
                                    <label class="control-label">Last School Attended</label>
                                    <div class="controls"><textarea   name="lschool"> Last School Attended </textarea></div>			
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
                                    <label class="control-label">Course Combination</label>
                                    <div class="controls">
                                        <select name="comb">
                                            <c:forEach var="combination" items="${combinations}">
                                                <option>${combination.subjects} </option>
                                            </c:forEach>

                                        </select>	
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">EMAIL</label>
                                    <div class="controls"><input type="text" placeholder="Email"  name="email"/></div>			
                                </div>
                                <div class="control-group">
                                    <label class="control-label">GSM</label>
                                    <div class="controls"><input type="text" placeholder="GSM"  name="gsm"/></div>			
                                </div>




                                <div class="control-group">
                                    <div class="controls">
                                        <button type="submit" class="btn" >Save and Continue</button>
                                        <button type="reset" class="btn" >Reset</button>
                                    </div>
                                </div>
                            </form> <!--            end form-->
                        </c:if>
                        <c:if test="${!empty ijmbCandidate}">

                            <h4>       One Step more...  ${ijmbCandidate.firstName}   ${ijmbCandidate.surName} ${ijmbCandidate.otherName}</h4>
                            <form action="ijmb_ol" method="post">
                                 <input type="hidden" name ="refNum" value="${ijmbCandidate.appref}" />
                                  <input type="hidden" name ="gsm" value="${ijmbCandidate.gsm}" />
                                <table>
                                    <thead>
                                    <th>Subject</th>
                                    <th>Grade</th>
                                    <th>Examination</th>

                                    </thead>
                                    <tr>
                                        <td>
                                            <select name ="subject" >
                                                <option>SELECT</option>
                                                <c:forEach var="subject" items="${subjects}">
                                                    <option>${subject.subject}</option>

                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td>
                                            <select name ="grade" >
                                                <option>SELECT</option>
                                                <c:forEach var="grade" items="${grades}">

                                                    <option>${grade.gname}</option>
                                                </c:forEach>
                                            </select>
                                        <td>
                                            <select name ="exam" >
                                                <c:forEach var="exam"  items="${exams}">
                                                    <option>${exam.exam}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <select name ="subject" >
                                                <option>SELECT</option>
                                                <c:forEach var="subject" items="${subjects}">
                                                    <option>${subject.subject}</option>

                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td>
                                            <select name ="grade" >
                                                <option>SELECT</option>
                                                <c:forEach var="grade" items="${grades}">

                                                    <option>${grade.gname}</option>
                                                </c:forEach>
                                            </select>
                                        <td>
                                            <select name ="exam" >
                                                <c:forEach var="exam"  items="${exams}">
                                                    <option>${exam.exam}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <select name ="subject" >
                                                <option>SELECT</option>
                                                <c:forEach var="subject" items="${subjects}">
                                                    <option>${subject.subject}</option>

                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td>
                                            <select name ="grade" >
                                                <option>SELECT</option>
                                                <c:forEach var="grade" items="${grades}">

                                                    <option>${grade.gname}</option>
                                                </c:forEach>
                                            </select>
                                        <td>
                                            <select name ="exam" >
                                                <c:forEach var="exam"  items="${exams}">
                                                    <option>${exam.exam}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <select name ="subject" >
                                                <option>SELECT</option>
                                                <c:forEach var="subject" items="${subjects}">
                                                    <option>${subject.subject}</option>

                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td>
                                            <select name ="grade" >
                                                <option>SELECT</option>
                                                <c:forEach var="grade" items="${grades}">

                                                    <option>${grade.gname}</option>
                                                </c:forEach>
                                            </select>
                                        <td>
                                            <select name ="exam" >
                                                <c:forEach var="exam"  items="${exams}">
                                                    <option>${exam.exam}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <select name ="subject" >
                                                <option>SELECT</option>
                                                <c:forEach var="subject" items="${subjects}">
                                                    <option>${subject.subject}</option>

                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td>
                                            <select name ="grade" >
                                                <option>SELECT</option>
                                                <c:forEach var="grade" items="${grades}">

                                                    <option>${grade.gname}</option>
                                                </c:forEach>
                                            </select>
                                        <td>
                                            <select name ="exam" >
                                                <c:forEach var="exam"  items="${exams}">
                                                    <option>${exam.exam}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        </td>
                                    </tr>
                                    <tr id ="res1">
                                        <td>
                                            <select name ="subject" >
                                                <option>SELECT</option>
                                                <c:forEach var="subject" items="${subjects}">
                                                    <option>${subject.subject}</option>

                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td>
                                            <select name ="grade" >
                                                <option>SELECT</option>
                                                <c:forEach var="grade" items="${grades}">

                                                    <option>${grade.gname}</option>
                                                </c:forEach>
                                            </select>
                                        <td>
                                            <select name ="exam" >
                                                <c:forEach var="exam"  items="${exams}">
                                                    <option>${exam.exam}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        </td>
                                    </tr>
                                    <tr id ="res2">
                                        <td>
                                            <select name ="subject" >
                                                <option>SELECT</option>
                                                <c:forEach var="subject" items="${subjects}">
                                                    <option>${subject.subject}</option>

                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td>
                                            <select name ="grade" >
                                                <option>SELECT</option>
                                                <c:forEach var="grade" items="${grades}">

                                                    <option>${grade.gname}</option>
                                                </c:forEach>
                                            </select>
                                        <td>
                                            <select name ="exam" >
                                                <c:forEach var="exam"  items="${exams}">
                                                    <option>${exam.exam}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        </td>
                                    </tr>
                                    <tr id ="s1">
                                        <td colspan="2">
                                            <button type="button"  class="btn" id="addresult1" >Add result</button>
                                        </td>
                                        <td><button type="submit" class="btn" >Submit </button></td>
                                    </tr>
                                    <tr id ="s2">
                                        <td colspan="2">
                                            <button type="button"  class="btn" id="addresult2" >Add result</button>
                                        </td>
                                        <td><button type="submit" class="btn" >Submit </button></td>
                                    </tr>
                                </table>
                            </form>
                        </c:if>

                </div> <!-- end right bar-->

                <div class="span4"> <!-- start left bar-->
                    <h5></h5>

                </div>  <!-- end left bar-->
            </div> <!-- end row-->


        </div> <!--end container-->


        <!--
        -->            </body>
</html>
