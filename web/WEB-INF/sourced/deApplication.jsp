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
        <title> DE Application  Page</title>
    </head>
    <body>
        <script type="text/javascript">

            $(document).ready(function() {

                $("#newSourcedDe").validate({
                    rules: {
                        jambNo: "required",
                        state: "required",
                        lga: "required",
                        courseStudied: "required",
                        gradeObtained: "required",
                        email: "required",
                        names: "required",
                        gsm: "required",


                    }
                });
            });
        </script>
        <div class="container"> <!-- start Container -->
            <!-- PAGE CONTENT -->
            <div class="row">
                <h3>WELCOME ${user.name} Your Access Code is Genuine! </h3>
            </div>
            <section>
                <div class="row c-product-showcase">
                    <div class="span3"">
                        <a href="http://www.auk.edu.ng"><img src="img/Logo.png" alt="Logo" class="img-polaroid" /></a>
                        <h4><a href="http://www.auk.edu.ng">About Al-Qalam University</a></h4>
                        <p style="text-align: justify">Al-Qalam  University stands unique among others due to our resolve to produce not only students with academic excellence
                            but also with Islamic moral values and conduct to positively fit into the larger society.</p>

                        <a href="http://www.auk.edu.ng" class="btn">Learn More <span class="icon-chevron-right"></span></a>
                    </div>
                    <div class="span6">
                        <h4> Enter  your information in the form provided below:</h4>

                        <hr/>
                        <section>
                            <form  id="newSourcedDe" class="form-horizontal centeredForm" action="sourcedDe" method="post">
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
                                    <label class="control-label">Qualification</label>
                                    <div class="controls"><select name="qualification">
                                            <option >HND</option>
                                            <option >ND</option>
                                            <option >IJMB</option>
                                            <option >Others</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">Course Studied</label>
                                    <div class="controls"><input type="text" placeholder="Course Studied" name="courseStudied"  /></div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">Grade Obtained</label>
                                    <div class="controls"><input type="text" placeholder="Grade Obtained"  name="gradeObtained" /></div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">Course Applied</label>
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
                                    <label class="control-label">EMAIL</label>
                                    <div class="controls"><input type="text" placeholder="Email"  name="email"/></div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label">GSM</label>
                                    <div class="controls"><input type="text" placeholder="GSM"  name="gsm"/></div>
                                </div>




                                <div class="control-group">
                                    <div class="controls">
                                        <button type="submit" class="btn" >Submit</button>
                                        <button type="reset" class="btn" >Reset</button>
                                    </div>
                                </div>
                            </form> <!--            end form-->
                        </section>
                    </div>

                    <div class="span3">   <!--Right bar begins-->
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
                                            <li> B.A. Arabic</li>
                                            <li> B.A. English</li>
                                            <li> B.A. Hausa</li>

                                            <li> B.A. Islamic Studies</li>


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


                    </div> <!--end right bar-->
                </div>


            </section>

        </div> <!-- end Container -->
        <!--
        -->            </body>
</html>
