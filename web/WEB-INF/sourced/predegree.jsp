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
                $("#res2").hide();
                $("#addresult").click(function() {
                    $("#res2").show();
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
                        <c:if test="${empty predegreeCandidate}">
                            <form  id="predegree" name="predegree" class="form-horizontal centeredForm" action="savePreDegree" method="post">
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
                                    <label class="control-label">Course Applied</label>
                                    <div class="controls">
                                        <select name="course">

                                            <c:forEach var="program" items="${preprograms}">
                                                <option>${program.programName}</option>
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
                        <c:if test="${!empty predegreeCandidate}">

                            <h4>       One Step more...  ${predegreeCandidate.firstName}   ${predegreeCandidate.surName} ${predegreeCandidate.otherName}</h4>
                            <form   class="form-horizontal centeredForm" action="saveolevel" method="post" enctype="multipart/form-data">
                                <input type="hidden" name ="gsm" value="${predegreeCandidate.gsm}" />

                                <table class="table-bordered table-striped">                                                        

                                    </thead>
                                    <thead>
                                    <th colspan="3">O-Level Record</th>

                                    </thead>
                                    <thead>
                                    <th>Subject</th>
                                    <th>Grade</th>
                                    <th>Examination</th>
                                    </thead>


                                    <tr>
                                        <td><input type="text" name="subject" value="English"  readonly="readonly" /></td>
                                        <td>
                                            <select name="grade" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >A1</option>
                                                <option >A2</option>
                                                <option >B3</option>
                                                <option >C4</option>
                                                <option >C5</option>
                                                <option >C6</option>
                                                <option >D7</option>
                                                <option >E8</option>
                                                <option >F9</option>
                                            </select>	
                                        </td>
                                        <td>  <td>
                                            <select name="examType" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >WASSCE</option>
                                                <option >NECO</option>
                                                <option >NABTEB</option>
                                                <option >Other</option>

                                            </select>	
                                        </td></td>
                                    </tr>
                                    <tr>
                                        <td><input type="text" name ="subject" value="Mathematics" readonly="readonly"/></td>
                                        <td>
                                            <select name="grade" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >A1</option>
                                                <option >A2</option>
                                                <option >B3</option>
                                                <option >C4</option>
                                                <option >C5</option>
                                                <option >C6</option>
                                                <option >D7</option>
                                                <option >E8</option>
                                                <option >F9</option>
                                            </select>	
                                        </td>
                                        <td>  <td>
                                            <select name="examType" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >WASSCE</option>
                                                <option >NECO</option>
                                                <option >NABTEB</option>
                                                <option >Other</option>

                                            </select>	
                                        </td></td>
                                    </tr>
                                    <tr>
                                        <td><select name="subject" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >Agriculture </option>
                                                <option >Arabic</option>
                                                <option >Biology</option>
                                                <option >Book Keeping</option>
                                                <option >Chemistry</option>
                                                <option >Commerce</option>
                                                <option >Economics</option>
                                                <option >Financial Accounts</option>
                                                <option >Further Maths</option>
                                                <option >Geography</option>
                                                <option >Government</option>
                                                <option >Government</option>
                                                <option >Hausa</option>
                                                <option >History</option>
                                                <option >IRK</option>
                                                <option >Physics</option>


                                            </select></td>
                                        <td>
                                            <select name="grade" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >A1</option>
                                                <option >A2</option>
                                                <option >B3</option>
                                                <option >C4</option>
                                                <option >C5</option>
                                                <option >C6</option>
                                                <option >D7</option>
                                                <option >E8</option>
                                                <option >F9</option>
                                            </select>	
                                        </td>
                                        <td>  <td>
                                            <select name="examType" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >WASSCE</option>
                                                <option >NECO</option>
                                                <option >NABTEB</option>
                                                <option >Other</option>

                                            </select>	
                                        </td></td>
                                    </tr>
                                    <tr>
                                        <td><select name="subject" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >Agriculture </option>
                                                <option >Arabic</option>
                                                <option >Biology</option>
                                                <option >Book Keeping</option>
                                                <option >Chemistry</option>
                                                <option >Commerce</option>
                                                <option >Economics</option>
                                                <option >Financial Accounts</option>
                                                <option >Further Maths</option>
                                                <option >Geography</option>
                                                <option >Government</option>
                                                <option >Government</option>
                                                <option >Hausa</option>
                                                <option >History</option>
                                                <option >IRK</option>
                                                <option >Physics</option>


                                            </select></td>
                                        <td>
                                            <select name="grade" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >A1</option>
                                                <option >A2</option>
                                                <option >B3</option>
                                                <option >C4</option>
                                                <option >C5</option>
                                                <option >C6</option>
                                                <option >D7</option>
                                                <option >E8</option>
                                                <option >F9</option>
                                            </select>	
                                        </td>
                                        <td>  <td>
                                            <select name="examType" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >WASSCE</option>
                                                <option >NECO</option>
                                                <option >NABTEB</option>
                                                <option >Other</option>

                                            </select>	
                                        </td></td>
                                    </tr>
                                    <tr>
                                        <td><select name="subject" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >Agriculture </option>
                                                <option >Arabic</option>
                                                <option >Biology</option>
                                                <option >Book Keeping</option>
                                                <option >Chemistry</option>
                                                <option >Commerce</option>
                                                <option >Economics</option>
                                                <option >Financial Accounts</option>
                                                <option >Further Maths</option>
                                                <option >Geography</option>
                                                <option >Government</option>
                                                <option >Government</option>
                                                <option >Hausa</option>
                                                <option >History</option>
                                                <option >IRK</option>
                                                <option >Physics</option>


                                            </select></td>
                                        <td>
                                            <select name="grade" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >A1</option>
                                                <option >A2</option>
                                                <option >B3</option>
                                                <option >C4</option>
                                                <option >C5</option>
                                                <option >C6</option>
                                                <option >D7</option>
                                                <option >E8</option>
                                                <option >F9</option>
                                            </select>	
                                        </td>
                                        <td>  <td>
                                            <select name="examType" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >WASSCE</option>
                                                <option >NECO</option>
                                                <option >NABTEB</option>
                                                <option >Other</option>

                                            </select>	
                                        </td></td>
                                    </tr>
                                    <tr>
                                        <td><select name="subject" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >Agriculture </option>
                                                <option >Arabic</option>
                                                <option >Biology</option>
                                                <option >Book Keeping</option>
                                                <option >Chemistry</option>
                                                <option >Commerce</option>
                                                <option >Economics</option>
                                                <option >Financial Accounts</option>
                                                <option >Further Maths</option>
                                                <option >Geography</option>
                                                <option >Government</option>
                                                <option >Government</option>
                                                <option >Hausa</option>
                                                <option >History</option>
                                                <option >IRK</option>
                                                <option >Physics</option>


                                            </select></td>
                                        <td>
                                            <select name="grade" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >A1</option>
                                                <option >A2</option>
                                                <option >B3</option>
                                                <option >C4</option>
                                                <option >C5</option>
                                                <option >C6</option>
                                                <option >D7</option>
                                                <option >E8</option>
                                                <option >F9</option>
                                            </select>	
                                        </td>
                                        <td>  <td>
                                            <select name="examType" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >WASSCE</option>
                                                <option >NECO</option>
                                                <option >NABTEB</option>
                                                <option >Other</option>

                                            </select>	
                                        </td></td>
                                    </tr>
                                    <tr>
                                        <td><select name="subject" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >Agriculture </option>
                                                <option >Arabic</option>
                                                <option >Biology</option>
                                                <option >Book Keeping</option>
                                                <option >Chemistry</option>
                                                <option >Commerce</option>
                                                <option >Economics</option>
                                                <option >Financial Accounts</option>
                                                <option >Further Maths</option>
                                                <option >Geography</option>
                                                <option >Government</option>
                                                <option >Government</option>
                                                <option >Hausa</option>
                                                <option >History</option>
                                                <option >IRK</option>
                                                <option >Physics</option>


                                            </select></td>
                                        <td>
                                            <select name="grade" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >A1</option>
                                                <option >A2</option>
                                                <option >B3</option>
                                                <option >C4</option>
                                                <option >C5</option>
                                                <option >C6</option>
                                                <option >D7</option>
                                                <option >E8</option>
                                                <option >F9</option>
                                            </select>	
                                        </td>
                                        <td>  <td>
                                            <select name="examType" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >WASSCE</option>
                                                <option >NECO</option>
                                                <option >NABTEB</option>
                                                <option >Other</option>

                                            </select>	
                                        </td></td>
                                    </tr>
                                    <tr>
                                        <td><select name="subject" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >Agriculture </option>
                                                <option >Arabic</option>
                                                <option >Biology</option>
                                                <option >Book Keeping</option>
                                                <option >Chemistry</option>
                                                <option >Commerce</option>
                                                <option >Economics</option>
                                                <option >Financial Accounts</option>
                                                <option >Further Maths</option>
                                                <option >Geography</option>
                                                <option >Government</option>
                                                <option >Government</option>
                                                <option >Hausa</option>
                                                <option >History</option>
                                                <option >IRK</option>
                                                <option >Physics</option>


                                            </select></td>
                                        <td>
                                            <select name="grade" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >A1</option>
                                                <option >A2</option>
                                                <option >B3</option>
                                                <option >C4</option>
                                                <option >C5</option>
                                                <option >C6</option>
                                                <option >D7</option>
                                                <option >E8</option>
                                                <option >F9</option>
                                            </select>	
                                        </td>
                                        <td>  <td>
                                            <select name="examType" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >WASSCE</option>
                                                <option >NECO</option>
                                                <option >NABTEB</option>
                                                <option >Other</option>

                                            </select>	
                                        </td></td>
                                    </tr>
                                    <tr>
                                        <td><select name="subject" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >Agriculture </option>
                                                <option >Arabic</option>
                                                <option >Biology</option>
                                                <option >Book Keeping</option>
                                                <option >Chemistry</option>
                                                <option >Commerce</option>
                                                <option >Economics</option>
                                                <option >Financial Accounts</option>
                                                <option >Further Maths</option>
                                                <option >Geography</option>
                                                <option >Government</option>
                                                <option >Government</option>
                                                <option >Hausa</option>
                                                <option >History</option>
                                                <option >IRK</option>
                                                <option >Physics</option>


                                            </select></td>
                                        <td>
                                            <select name="grade" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >A1</option>
                                                <option >A2</option>
                                                <option >B3</option>
                                                <option >C4</option>
                                                <option >C5</option>
                                                <option >C6</option>
                                                <option >D7</option>
                                                <option >E8</option>
                                                <option >F9</option>
                                            </select>	
                                        </td>
                                        <td>  <td>
                                            <select name="examType" style="max-width:50%;">
                                                <option >SELECT</option>
                                                <option >WASSCE</option>
                                                <option >NECO</option>
                                                <option >NABTEB</option>
                                                <option >Other</option>

                                            </select>	
                                        </td></td>
                                    </tr>
                                    <hr/>
                                </table>

                                <table class="table-bordered">
                                    <thead>
                                    <th colspan="3"> UPLOAD O-LEVEL RESULT</th>
                                    </thead>
                                    <tr>
                                        <td colspan="3"></td>
                                    </tr>
                                    <tr>
                                        <td colspan="3"></td>
                                    </tr>

                                    <tr>
                                        <td colspan ="2">Upload Your Result</td>
                                        <td><input type="file" name="result1" size="50"/></td>
                                    </tr>

                                    <tr id="res2">
                                        <td colspan="2">Upload Your Result</td>
                                        <td><input type="file" name="result2" size="50"/></td>
                                    </tr>
                                    <tr>
                                        <td colspan="2"><button type="button"  class="btn" id="addresult" >Add result</button></td>
                                        <td> <button type="submit" class="btn" >Submit </button></td>


                                    </tr>
                                </table>
                                <h5></h5>
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
