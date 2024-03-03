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
        <div class ="container">
            <div class="row">
                <div class="span2">  <h4>UTME List</h4> </div>
                <section class="">
                <div class="span10">
                <!-- Form that provides selection of program -->
                <form class="form-search" action="departmentDesicion" method="post">
                    <div class="input-prepend input-append">
                        <span class="add-on">Enter Program to filter the list:</span>
                        <select name="program">
                            <option > ALL </option>
                            <c:forEach var = "program"  items = "${programs}">
                                <option>${program.programName}</option>

                            </c:forEach>
                        </select>
                        <span class="add-on">Enter Session to filter</span>
                        <select name="academicSession">
                            <option > ALL </option>
                            <c:forEach var="academicSession" items="${academicSessions}">
                                <option>${academicSession.sessionName}</option>
                            </c:forEach>
                        </select>
                        <button class="btn" type="submit">Filter</button>

                    </div>
                </form>
                 <hr/>
                  <form class="form-horizontal" action="departmentDesicion" method="post">
                <table    class="table table-condensed table-bordered table-striped tabs-stacked" >
                    <thead>
                        <tr>

                            <td>Jamb No.</td>
                            <td>Name</td>
                            <td>Status</td>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var = "utmeCandidate" items = "${utmeList}"  >
                            <tr>
                                <td><input type="text" value="${utmeCandidate.utmePK.jambNo}" name="jambNo" readonly="readonly"/></td>
                                <td> ${utmeCandidate.name}</td>

                                <td> <select name="${utmeCandidate.utmePK.jambNo}" value ="" >
                                        <option >${utmeCandidate.status}</option>
                                        <option >Not decided</option>
                                        <option >Accepted</option>
                                        <option >Rejected</option>
                                    </select>
                                </td>

                            </tr>
                        </c:forEach>

                    </tbody>

                </table>

                <button class="btn" type="" name="sumit"> EDIT DECISION</button>

            </form>
                </div> <!-- end rightbar -->
                   
                </section>
                <!-- End form that provides selection of program -->



            </div>
           
        </div>
    </body>
</html>
