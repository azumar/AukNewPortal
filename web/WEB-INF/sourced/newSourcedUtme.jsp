<%-- 
    This  is  form for creating new UTME record
--%>

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
        <title>UTME Application</title>
    </head>
    <body>
        <script type="text/javascript">

            $(document).ready(function() {

                $("#newSourcedUtm").validate({
                    rules: {
                        jambNo: "required",
                        state: "required",
                        lga: "required",
                        subject2: "required",
                        subject3: "required",
                        subject4: "required",
                          names: "required",
                        gsm: "required",
                        totalScore : {
                            required: true,
                            number: true
                        }

                    }
                });
            });
        </script>
        <div class="container"> <!-- start Container -->
            <div class="row"> <!-- start row -->

                <div class="span3"> <!-- start left bar-->
                    <a href="http://www.auk.edu.ng"><img src="img/Logo.png" alt="Logo" class="img-polaroid" /></a>

                    <h4><a href="http://www.auk.edu.ng">About Al-Qalam University</a></h4>
                    <p style="text-align: justify">Al-Qalam  University stands unique among others due to our resolve to produce not only students with academic excellence
                        but also with Islamic moral values and conduct to positively fit into the larger society.</p>

                    <a href="http://www.auk.edu.ng" cla    ss="btn">Learn More <span class="icon-chevron-right"></span></a>
                </div>  <!-- end left bar-->
                <div class="span6"> <!-- start right bar-->
                    <section>
                        <h4> Enter  your information in the form provided below:</h4>

                        <hr/>
                        <form  id="newSourcedUtm" class="form-horizontal centeredForm" action="newSourcedUtme" method="post">
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
                                <label class="control-label">Email</label>
                                <div class="controls"><input type="text" placeholder="Email"  name="email"  /></div>			
                            </div>
                            <div class="control-group">
                                <label class="control-label">GSM</label>
                                <div class="controls"><input type="text" placeholder="GSM"  name="gsm" value="" /></div>			
                            </div>

                            <div class="control-group">
                                <div class="controls">
                                    <button type="submit" class="btn" >Submit</button>
                                    <button type="reset" class="btn" >Clear</button>
                                </div>
                            </div>
                        </form> <!--            end form-->
                    </section>

                </div> <!-- end right bar-->


                <div class="span3">


                     <h4><a href="">Our Programmes</a></h4>
                        <div class="accordion" id="my-accordion">
                            <div class="accordion-group">
                                <div class="accordion-heading">
                                    <a href="#collapse-1" data-toggle="collapse" data-parent="#my-accordion" class="accordion-toggle">College of Education</a>
                                </div>
                                <div class="accordion-body collapse in" id="collapse-1">
                                    <div class="accordion-inner">
                                        <ul>
                                            <li> B.A. Ed. Arabic</li>
                                            <li> B.Sc. Ed. Biology</li>
                                            <li> B.Sc. Ed. Chemistry</li>
                                            <li> B.A Ed. English</li>
                                            <li> B.A Ed. Hausa</li>
                                            <li> B.A Ed. Islamic Studies</li>
                                            <li> B.Sc. Ed. Mathematics</li>
                                               <li> B.Sc. Ed. Physics</li>
                                            
                                            </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="accordion-group">
                                <div class="accordion-heading">
                                    <a href="#collapse-2" data-toggle="collapse" data-parent="#my-accordion" class="accordion-toggle">College of Humanities</a>
                                </div>
                                <div class="accordion-body collapse" id="collapse-2">
                                    <div class="accordion-inner">
                                          <ul>
                                             <li> B.A Arabic</li>
                                              <li> B.A English</li>
                                            <li> B.AHausa</li>
                                                                                       
                                            <li> B.A Islamic Studies</li>
                                           
                                                                                        
                                            </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="accordion-group">
                                <div class="accordion-heading">
                                    <a href="#collapse-3" data-toggle="collapse" data-parent="#my-accordion" class="accordion-toggle">College of Natural and Applied Sciences</a>
                                </div>
                                <div class="accordion-body collapse" id="collapse-3">
                                    <div class="accordion-inner">
                                       <ul>
                                             <li> B.Sc. Biology</li>
                                            <li> B.Sc. Chemistry</li>
                                            <li> B.Sc. Computer Science </li>
                                            <li> B.Sc. Mathematics</li>
                                            <li> B.Sc. Physics</li>
                                          
                                            
                                            </ul>
                                    </div>
                                </div>
                            </div>
                             <div class="accordion-group">
                                <div class="accordion-heading">
                                    <a href="#collapse-4" data-toggle="collapse" data-parent="#my-accordion" class="accordion-toggle">College of Social and Management Sciences</a>
                                </div>
                                <div class="accordion-body collapse" id="collapse-4">
                                    <div class="accordion-inner">
                                        <ul>
                                             <li> B.Sc. Accounting</li>
                                            <li> B.Sc. Business Administration</li>
                                            <li> Bsc. Economics</li>
                                                                                       
                                            <li> B.Sc. Political Science</li>
                                            <li> B.Sc. Sociology</li>
                                            
                                            
                                            </ul>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <hr />



                </div><!--end right bar-->
            </div> <!-- end row-->


        </div> <!--end container-->


        <!--
        -->            </body>
</html>
