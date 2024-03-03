<%-- 
    Document   : utme
    Created on : Jun 26, 2015, 3:20:33 PM
    Author     : Armayau
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
        <div class ="container-fluid">
            <div class="row">



                <!-- Form that provides selection of program -->
                <form class="form-search" action="utme" method="post">
                    <div class="input-prepend input-append">
                        <span class="add-on">Select Program to filter the list:</span>
                        <select name="program">
                            <option > ALL </option>
                            <c:forEach var="program" items="${programs}">
                                <option>${program.programName}</option>
                            </c:forEach>
                        </select>
                        <span class="add-on">Select Session to filter</span>
                        <select name="academicSession">
                            <option > ALL </option>

                            <c:forEach var="academicSession" items="${academicSessions}">
                                <option>${academicSession.sessionName}</option> 
                            </c:forEach>
                        </select>

                        <span class="add-on">Select Application Type</span>
                        <select name="applicationType">
                            <option > ALL </option>

                            <option>First Choice</option>
                            <option>Sourced</option>

                        </select>
                        <button class="btn" type="submit">Filter</button>

                    </div>
                </form>
                <!-- End form that provides selection of program -->

                <!-- Form that provides Search using Jamb No. -->
                <form class="form-inline"   action="utmeSearch" method="post" style="margin-left: 15em">
                    <div class="input-prepend">
                        <span class="add-on">Enter Jamb No. to  Search</span>
                    </div>
                    <input type="text" name="jNo"/>
                    <button class="btn" type="submit">Search</button>

                </form>
                <!-- End form  that provides Search using Jamb No -->

            </div>
            <form class="form-horizontal" action="deleteDe" method="post">
                <table class="table table-condensed table-striped">
                    <thead>
                        <tr>

                            <td></td>
                            <td>Jamb No.</td>
                            <td>Name</td>
                            <td>SEX</td>
                            <td>Qualification</td>
                            <td>Course Studied</td>
                            <td>Grade</td>
                            <td>State</td>
                            <td>LGA</td>
                            <td>Dept. Decision</td>
                            <td>Programme Applied</td>
                            <td>Programme Recommended</td>
                            <td>Session</td>
                            <td>Application Type</td>
                            
                            <td>Admitted</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${!empty des}">
                            <c:forEach var = "deCandidate" items = "${des}"   >
                                <tr>
                                    <td> <input type="checkbox"  name="jambNo" value ="${deCandidate.dePK .jambNo}"/></td>
                                    <td> <a href="utmeDetails?${deCandidate.dePK .jambNo}">${deCandidate.dePK .jambNo}</td>
                                    <td> ${deCandidate.name}</td>
                                    <td> ${deCandidate.sex}</td>
                                    <td> ${deCandidate.programme}</td>
                                    <td> ${deCandidate.course}</td>
                                    <td> ${deCandidate.grade}</td>
                                    <td> ${deCandidate.state}</td>
                                    <td> ${deCandidate.lga}</td>
                                    <td> ${deCandidate.status}</td>
                                    <td> ${deCandidate.courseApplied}</td>
                                    <td> ${deCandidate.program.programName}</td>
                                    <td> ${deCandidate.session}</td>
                                    <td> ${deCandidate. typeId.typeName}</td>
                                    <td> ${deCandidate.admitted}</td>
                                    



                                </tr>

                            </c:forEach>
                        </c:if>

                        <c:if test="${!empty singleCandidate}">

                            <tr>
                                <td> <input type="checkbox"  name="jambNo" value ="${singleCandidate.utmePK.jambNo}"/></td>
                                <td> <a href="utmeDetails?${singleCandidate.utmePK.jambNo}">${singleCandidate.utmePK.jambNo}</td>
                                <td> ${singleCandidate.name}</td>
                                <td> ${singleCandidate.state}</td>
                                <td> ${singleCandidate.lga}</td>
                                <td> ${singleCandidate.sex}</td>
                                <td> ${singleCandidate.subject2}</td>
                                <td> ${singleCandidate.subject3}</td>
                                <td> ${singleCandidate.subject4}</td>
                                <td> ${singleCandidate.totalScore}</td>
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
                <button class="btn" type="submit" name="delete">DELETE</a></button>
                <button class="btn" type="" name="add" > <a href="newDe">ADD NEW</a></button>
                <button class="btn" type="" name="t"> <a href="deDeptDesicion">DEPARTMENT  DECISION</a></button>
                                <button class="btn" type="" name="export"> <a href="">FINAL APROVAL</a></button>
                <button class="btn" type="" name="export"> <a href="">EXPORT</a></button>

            </form>
        </div>
    </body>
</html>
