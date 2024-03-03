<%-- 
    Document   : newUtme
    Created on : Jun 30, 2015, 10:08:04 PM
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
        <div class="container"><!-- start Container -->
            <div class="row"> <!-- start row -->
                <div class="span2"> <!-- start left bar -->
                    <h3>Updating existing Record</h3>

                </div> <!-- end left bar -->
                <div class="span10"> <!-- start right bar -->
                    <form class="form-horizontal centeredForm" action="updateUtme" method="post">
                        <input type="hidden" placeholder="Jamb No"  name="id" value="${selectedUtme.utmePK.id}" />
                        <div class="control-group">
                            <label class="control-label">Jamb No.</label>
                            <div class="controls"><input type="text" placeholder="jamb No"  name="jambNo" value="${selectedUtme.utmePK.jambNo}"  readonly="readonly"/></div>			
                        </div>

                        <div class="control-group">
                            <label class="control-label">Names</label>
                            <div class="controls"><input type="text" placeholder="Names" name="names"  value="${selectedUtme.name}" /></div>			
                        </div>
                        <div class="control-group">
                            <label class="control-label">State</label>
                            <div class="controls"><input type="text" placeholder="State" name="state" value="${selectedUtme.state}"/></div>			
                        </div>
                        <div class="control-group">
                            <label class="control-label">LGA</label>
                            <div class="controls"><input type="text" placeholder="LGA"  name="lga" value="${selectedUtme.lga}"/></div>			
                        </div>
                        <div class="control-group">
                            <label class="control-label">SEX</label>
                            <div class="controls"><select name="sex" value="${selectedUtme.sex}">
                                    <option >M</option>
                                    <option >F</option>
                                </select>	
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Subject 2</label>
                            <div class="controls"><input type="text" placeholder="Subject 2" name="subject2" value="${selectedUtme.subject2}"/></div>			
                        </div>
                        <div class="control-group">
                            <label class="control-label">Subject 3</label>
                            <div class="controls"><input type="text" placeholder="Subject 3" name="subject3" value="${selectedUtme.subject3}" /></div>			
                        </div>
                        <div class="control-group">
                            <label class="control-label">Subject 4</label>
                            <div class="controls"><input type="text" placeholder="Subject 4"  name="subject4" value="${selectedUtme.subject4}"/></div>			
                        </div>
                        <div class="control-group">
                            <label class="control-label">Total Score</label>
                            <div class="controls"><input type="text" placeholder="Total Score"  name="totalScore" value="${selectedUtme.totalScore}" /></div>			
                        </div>
                         <div class="control-group">
                            <label class="control-label">Course Applied</label>
                            <div class="controls"><input type="text" placeholder=""  name="courseApplied" value="${selectedUtme.courseApplied}" /></div>			
                        </div>
                        <div class="control-group">
                            <label class="control-label">Course Recommended</label>
                            <div class="controls">
                                <select name="course" value="${selectedUtme.program.programName}">
                                    <option > ${selectedUtme.program.programName} </option>
                                    <c:forEach var ="program" items="${programs}">
                                        <option> ${program.programName}</option>
                                    </c:forEach>
                                </select>	
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label">Application Type</label>
                            <div class="controls">
                                <select name="applicationType" value=" ${selectedUtme.typeId.typeName}" readonly="readonly">
                                    <option >  ${selectedUtme.typeId.typeName}</option>
                                    <c:forEach var ="type" items="${types}">
                                        <option>${typeId.typeName}</option>
                                    </c:forEach>

                                </select>	
                            </div>
                        </div>

                        <label class="control-label">Department Decision</label>
                        <div class="controls">
                            <select name="status" value="${selectedUtme.status}"  >

                                <option >Not decided</option>
                                <option >Accepted</option>
                                <option >Rejected</option>
                            </select>	
                        </div>
                        <div class="control-group">
                            <label class="control-label">Post UTME Score</label>
                            <div class="controls"><input type="text" placeholder="Post UTME"  name="pume" value="${selectedUtme.pume}" /></div>			
                        </div>
                        <div class="control-group">
                            <label class="control-label">Session</label>
                            <div class="controls"><select name="session" value="${selectedUtme.session}" >
                                    <option >2014/2015</option>
                                    <option >2015/2016</option>
                                </select>	
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Email</label>
                            <div class="controls"><input type="text" placeholder="Email"  name="email" value="${selectedUtme.email}" /></div>			
                        </div>
                        <div class="control-group">
                            <label class="control-label">GSM</label>
                            <div class="controls"><input type="text" placeholder="GSM"  name="gsm" value="${selectedUtme.gsm}" /></div>			
                        </div>
                        <label class="control-label">Admitted</label>
                        <div class="controls"><input type="checkbox" name="admitted"  /></div>
                        <div class="control-group">
                            <div class="controls">
                                <button type="submit" class="btn" >Update</button>
                            </div>
                        </div>
                


                </form>
            
        </div> <!-- end right bar -->
    </div><!--        end row-->

</div><!--        </di v>ends container-->

</body>
</html>
