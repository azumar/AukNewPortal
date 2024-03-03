<%-- 
  This is the template page which displays list of UTME candidates, the list can e filtered using different criteria
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class ="container-fluid"> <!-- start Container -->

            <div class="row"> <!-- start  1st Row -->
                <!-- Form that provides selection criteria -->

                <form class="form-search" action="utme" method="post">

                    <!-- Program Selection -->
                    <div class="input-prepend input-append">
                        <span class="add-on">Select Program to filter the list:</span>
                        <select name="program">
                            <option > ALL </option>
                            <c:forEach var="program" items="${programs}">
                                <option>${program.programName}</option>
                            </c:forEach>
                        </select>


                        <!-- Session  Selection -->
                        <span class="add-on">Select Session to filter</span>
                        <select name="academicSession">
                            <option > ALL </option>
                            <c:forEach var="academicSession" items="${academicSessions}">
                                <option>${academicSession.sessionName}</option> 
                            </c:forEach>
                        </select>

                        <!-- Application Type Selection - First Choice or Sourced -->
                        <span class="add-on">Select Application Type</span>
                        <select name="applicationType">
                            <option > ALL </option>
                            <option>First Choice</option>
                            <option>Sourced</option>
                        </select>
                        <button class="btn" type="submit">Filter</button>

                    </div>
                </form>
                <!-- End form that provides selection using program Session and Application type Criteria -->

                <!-- Form that provides Search using Jamb No. -->
                <form class="form-inline"   action="utmeSearch" method="post" style="margin-left: 15em">
                    <div class="input-prepend">
                        <span class="add-on">Enter Jamb No. to  Search</span>
                    </div>
                    <input type="text" name="jNo"/>
                    <div class="input-prepend">
                        <span class="add-on">Enter GSM No. to  Search</span>
                    </div>
                    <input type="text" name="gsmNo"/>
                    <button class="btn" type="submit">Search</button>

                </form>

                <!-- End form  that provides Search using Jamb No -->

            </div><!-- end   1st Row -->

            <!-- The following form action was set to deleteUtme because multiple jambNos can be selected for deletion, UTME list table
            is embedded in the form and actionable buttons are also appended -->
            <form class="form-horizontal" action="deleteUtme" method="post">
                <table class="table table-condensed table-striped">
                    <thead>
                        <tr>
                            <td><!-- column header holds nothing-- beneath are checkboxes --></td>
                            <td>Jamb No.</td>
                            <td>Name</td>
                            <td>State</td>

                            <td>Sex</td>
                            <td>Subject 2</td>
                            <td>Subject 3</td>
                            <td>Subject 4</td>
<!--                            <td>Total Score</td>
                            <td>Program Applied</td>-->
                            <td>Program Recommended</td>
                            <td>Type</td>
                            <td>Post UTME Score</td>
                            <td>Department decision</td>
                            <td>Session</td>
                            <td>Admitted</td>
                            <td>GSM</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${!empty utmeList}"> <!--Test if the list is not empty i.e if multiple records were forwarded -->
                            <c:forEach var = "utmeCandidate" items = "${utmeList}"   > <!--iterate over the list-->
                                <tr>
                                    <td> <input type="checkbox"  name="jambNo" value ="${utmeCandidate.utmePK.jambNo}"/></td>
                                    <td> <a href="utmeDetails?${utmeCandidate.utmePK.jambNo}">${utmeCandidate.utmePK.jambNo}</td>
                                    <td> ${utmeCandidate.name}</td>
                                    <td> ${utmeCandidate.state}</td>

                                    <td> ${utmeCandidate.sex}</td>
                                    <td> ${utmeCandidate.subject2}</td>
                                    <td> ${utmeCandidate.subject3}</td>
                                    <td> ${utmeCandidate.subject4}</td>
<!--                                    <td> ${utmeCandidate.totalScore}</td>
                                    <td> ${utmeCandidate.courseApplied}</td>-->
                                    <td> ${utmeCandidate.program.programName}</td>
                                    <td> ${utmeCandidate.typeId.typeName}</td>
                                    <td> ${utmeCandidate.pume}</td>
                                    <td> ${utmeCandidate.status}</td>
                                    <td> ${utmeCandidate.session}</td>
                                    <td> ${utmeCandidate.admitted}</td>
                                    <td> ${utmeCandidate.gsm}</td>
                                </tr>

                            </c:forEach>
                        </c:if>

                        <c:if test="${!empty singleCandidate}"> <!--Test if the list is empty i.e if single record was forwarded -->

                            <tr>
                                <td> <input type="checkbox"  name="jambNo" value ="${singleCandidate.utmePK.jambNo}"/></td>
                                <td> <a href="utmeDetails?${singleCandidate.utmePK.jambNo}">${singleCandidate.utmePK.jambNo}</td>
                                <td> ${singleCandidate.name}</td>
                                <td> ${singleCandidate.state}</td>
<!--                                <td> ${singleCandidate.lga}</td>-->
                                <td> ${singleCandidate.sex}</td>
                                <td> ${singleCandidate.subject2}</td>
                                <td> ${singleCandidate.subject3}</td>
                                <td> ${singleCandidate.subject4}</td>
<!--                                <td> ${singleCandidate.totalScore}</td>-->
                                <td> ${singleCandidate.program.programName}</td>
                                <td> ${singleCandidate.typeId.typeName}</td>
                                <td> ${singleCandidate.pume}</td>
                                <td> ${singleCandidate.status}</td>
                                <td> ${singleCandidate.session}</td>
                                <td> ${singleCandidate.admitted}</td>
                            </tr>

                        </c:if>
                    </tbody>

                </table>
                <!-- List of actionable buttons -->
                <button class="btn" type="submit" name="delete">DELETE</a></button>


            </form>
            <hr/>
            <form class="" action="" method="">
                <button class="btn" type="" name="add" > <a href="newUtme">ADD NEW</a></button>
                <button class="btn" type="" name="t"> <a href="departmentDesicion">DEPARTMENT  DECISION</a></button>
                <button class="btn" type="" name="export"> <a href="editPostUtme">EDIT POST UTME</a></button>
                <button class="btn" type="" name="export"> <a href="finalApproval">FINAL APROVAL</a></button>
                <button class="btn" type="" name="export"> <a href="">EXPORT</a></button>
            </form>
        </div> <!-- end Container -->

    </body>
</html>
