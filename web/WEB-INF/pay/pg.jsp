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
                $("#widthraw").hide();
                $("#otherinst").hide();
                $("#expl").change(function() {
                    $("#widthraw").show();
                });
                $("#noexpl").change(function() {
                    $("#widthraw").hide();
                });
                $("#yatd").change(function() {
                    $("#otherinst").show();
                });
                $("#noatd").change(function() {
                    $("#otherinst").hide();
                });
                $("#res1").hide();
                $("#res2").hide();
                $("#s2").hide();
                $("#addschool1").click(function() {
                    $("#res1").show();
                    $("#s1").hide();
                    $("#s2").show();
                });
                $("#addschool2").click(function() {
                    $("#res2").show();
                    $("#addschool2").hide();
                    //  $("#s2").show();
                });

                $("#pgform").validate({
                    rules: {
                        name: "required",
                        nationality: "required",
                        state: "required",
                        lga: "required",
                        gsm: "required",
                        pbirth: "required",
                        htown: "required",
                        hqualification: "required",
                        email: "required",
                        paddress: "required",
                        spname: "required",
                        nok: "required",
                        nokrelation: "required",
                        nokphone: "required",
                        nokaddress: "required",
                        dob: {
                            required: true


                        }


                    }
                });
                $("#schattd").validate({
                    rules: {
                        ref: "required",
                        rank: "required",
                        refemail: "required",
                        refgsm: "required"


                    }
                });
            });

        </script>
        <div class="container"> <!-- start Container -->
            <div class="row"> <!-- start row -->

                <div class="span3"> <!-- start left bar-->
 <h4>Al-Qalam University, Katsina</h4>
                    <a href="http://www.auk.edu.ng"><img src="img/Logo.png" alt="Logo" class="img-polaroid" /></a>
                    <h4><a href="http://www.auk.edu.ng">About Al-Qalam University</a></h4>
                    <p style="text-align: justify">Al-Qalam  University stands unique among others due to our resolve to produce not only students with academic excellence
                        but also with Islamic moral values and conduct to positively fit into the larger society.</p>

                    <a href="http://www.auk.edu.ng" cla    ss="btn">Learn More <span class="icon-chevron-right"></span></a>
                </div>  <!-- end left bar-->
                <div class="span8"> <!-- start right bar-->
                    <section>
                        <c:choose>
                            <c:when test="${(empty pgdetails) &&(empty pginfo)}">

                                <hr/>
                                <form  id="pgform" class="form-horizontal centeredForm" action="save_pg" method="post">
                                    <div class="control-group">
                                        <label class="control-label">Applying for</label>
                                        <div class="controls"><select name="program">
                                                <option >M.A Arabic</option>
                                                <option >M.A Islamic Studies</option>

                                            </select>	
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" >Name</label>
                                        <div class="controls"><input type="text" placeholder="Full Name"  name="name" id="name"/></div>			
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" >Date of Birth</label>
                                        <div class="controls"><input type="text" placeholder="dd/mm/yyyy"  name="dob" /></div>			
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">Gender</label>
                                        <div class="controls"><select name="gender">
                                                <option >M</option>
                                                <option >F</option>
                                            </select>	
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">Marital Status</label>
                                        <div class="controls"><select name="mstatus">
                                                <option >Single</option>
                                                <option >Married</option>
                                                <option >Widow</option>
                                                <option >Divorced</option>
                                            </select>	
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">Nationality</label>
                                        <div class="controls"><input type="text" placeholder="Nationality" name="nationality" /></div>			
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
                                        <label class="control-label">Place of Birth</label>
                                        <div class="controls"><input type="text" placeholder="Place of Birth" name="pbirth" /></div>			
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">Home Town</label>
                                        <div class="controls"><input type="text" placeholder="Home Town" name="htown"  /></div>			
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">Highest Qualification</label>
                                        <div class="controls"><input type="text" placeholder="Highest Qualification"  name="hqualification" /></div>			
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">Phone No.</label>
                                        <div class="controls"><input type="text" placeholder="Phone Number"  name="gsm" /></div>			
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label">Email</label>
                                        <div class="controls"><input type="text" placeholder="Email"  name="email"  /></div>			
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label">Postal Address</label>
                                        <div class="controls"><textarea   name="paddress"> Postal Address </textarea></div>			
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">Sponsor Name</label>
                                        <div class="controls"><input type="text" placeholder="Sponsor"  name="spname"  /></div>			
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label">Sponsor Address</label>
                                        <div class="controls"><textarea   name="spaddress"> Sponsor Address </textarea></div>			
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label">Next of Kin</label>
                                        <div class="controls"><input type="text" placeholder="Next of Kin"  name="nok"  /></div>			
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label">Next of Kin Address</label>
                                        <div class="controls"><textarea   name="nokaddress"> Next of Kin Address </textarea></div>			
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">Next of Kin Relationship</label>
                                        <div class="controls"><input type="text" placeholder="Next of Kin Relationship"  name="nokrelation"  /></div>			
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">Next of Kin Phone Number</label>
                                        <div class="controls"><input type="text" placeholder="Next of Kin Phone Number"  name="nokphone"  /></div>			
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">Next of Kin  Email</label>
                                        <div class="controls"><input type="text" placeholder="Next of Kin Email"  name="nokemail"  /></div>			
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" style="width: 20em"> Have ever been expelled or withdrawn from Al-Qalam or any other University?</label>
                                        <input type="radio" name="exp" value="no" id="noexpl" checked>No<br>
                                        <input type="radio" name="exp" value="yes" id="expl"> Yes<br>

                                    </div>  
                                    <div class="control-group" id ="widthraw">
                                        <label class="control-label">State the University</label>
                                        <div class="controls"><input type="text" placeholder="University Expelled or Widthrawn"  name="expuni"  /></div>
                                        <label class="control-label">Expelled Date</label>
                                        <div class="controls"><input type="text" placeholder=""  name="expdate"  /></div>
                                        <label class="control-label">Expelled Reason</label>
                                        <div class="controls"><input type="text" placeholder="Expelled Reason"  name="expreason"  /></div>
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" style="width: 20em"> Are you attending any educational institution or undergoing any côurse at present? </label>
                                        <input type="radio" name="attd" value="noattd" id="noatd" checked>No<br>
                                        <input type="radio" name="attd" value="yesattd" id="yatd"> Yes<br>		
                                    </div>
                                    <div class="control-group" id ="otherinst">
                                        <label class="control-label">State the Institution and Course</label>
                                        <div class="controls"><input type="text" placeholder="Institution and Course"  name="oherinst"  /></div>

                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">State research experience with dates and institution(s)</label>
                                        <div class="controls"><textarea   name="rcexp">  </textarea></div>			
                                    </div>
                                    <div class="control-group">
                                        <div class="controls">
                                            <button type="submit" class="btn" >Save and Continue</button>
                                            <button type="reset" class="btn" >Clear</button>
                                        </div>
                                    </div>
                                </form> <!--            end form-->

                            </c:when>

                            <c:when test="${!empty pginfo}">


                                <fieldset>SCHOOLS ATTENDED


                                    <form id="schattd"    action="save_all" method="post" >
                                        <input type="hidden" name ="refNum" value="${pginfo.appref}" />
                                        <table  class="table table-condensed table-bordered table-striped" >
                                            <tbody>

                                                <tr>

                                                    <th >SCHOOL/COLLEGE</th>
                                                    <th >FROM</th>
                                                    <th>TO</th>
                                                    <th >CERTIFICATE OBTAINED</th>
                                                </tr>
                                                <c:forEach begin="0" end="2" varStatus="loop">
                                                    <tr>

                                                        <td><input type="text" name="school"></td>
                                                        <td><input type="text" name="from"></td>
                                                        <td><input type="text" name="to"></td>
                                                        <td><input type="text" name="cert"></td>
                                                    </tr>
                                                </c:forEach>


                                                <tr id ="res1">

                                                    <td><input type="text" name="school"></td>
                                                    <td><input type="text" name="from"></td>
                                                    <td><input type="text" name="to"></td>
                                                    <td><input type="text" name="cert"></td>
                                                </tr>
                                                <tr id ="res2">

                                                    <td><input type="text" name="school"></td>
                                                    <td><input type="text" name="from"></td>
                                                    <td><input type="text" name="to"></td>
                                                    <td><input type="text" name="cert"></td>
                                                </tr>
                                                <tr id ="s1">
                                                    <td colspan="3">
                                                        <button type="button"  class="btn" id="addschool1" >Add School</button>
                                                    </td>

                                                </tr>
                                                <tr id ="s2">
                                                    <td colspan="3">
                                                        <button type="button"  class="btn" id="addschool2" >Add School</button>
                                                    </td>
                                                    <td><button type="submit" class="btn" >Save and Continue  </button></td>
                                                </tr>
                                            </tbody>
                                        </table>

                                        EMPLOYMENT RECORD

                                        <table  class="table table-condensed table-bordered table-striped" >
                                            <tbody>

                                                <tr>

                                                    <th >EMPLOYMENT</th>
                                                    <th >POST HELD</th>
                                                    <th>TO</th>

                                                </tr>
                                                <c:forEach begin="0" end="2" varStatus="loop">
                                                    <tr>


                                                        <td><input type="text" name="employment"></td>
                                                        <td><input type="text" name="posth"></td>
                                                        <td><input type="text" name="toe"></td>
                                                    </tr>
                                                </c:forEach>





                                            </tbody>
                                        </table>
                                        PUBLICATION
                                        <table  class="table table-condensed table-bordered table-striped" >
                                            <tbody>

                                                <tr>

                                                    <td colspan="4"><textarea style="width: 95%" name="pub" maxlength="330" > Postal Address </textarea></td>

                                                </tr>




                                            </tbody>
                                        </table>

                                        REFEREE INFORMATION

                                        <table  class="table table-condensed table-bordered table-striped" >
                                            <tbody>

                                                <tr>

                                                    <th >REFEREE'S NAME</th>
                                                    <th >RANK</th>
                                                    <th>EMAIL</th>
                                                    <th>PHONE</th>

                                                </tr>
                                                
                                                    <tr>

                                                        <td><input type="text" name="ref"></td>
                                                        <td><input type="text" name="rank"></td>
                                                        <td><input type="text" name="refemail"></td>
                                                        <td><input type="text" name="refgsm"></td>
                                                    </tr>
                                                 <tr>

                                                        <td><input type="text" name="ref"></td>
                                                        <td><input type="text" name="rank"></td>
                                                        <td><input type="text" name="refemail"></td>
                                                        <td><input type="text" name="refgsm"></td>
                                                    </tr>
                                                       <tr>

                                                        <td><input type="text" name="ref"></td>
                                                        <td><input type="text" name="rank"></td>
                                                        <td><input type="text" name="refemail"></td>
                                                        <td><input type="text" name="refgsm"></td>
                                                    </tr>




                                                <tr >
                                                    <td colspan="3">

                                                    </td>
                                                    <td><button type="submit" class="btn" >Save and Continue  </button></td>
                                                </tr>

                                            </tbody>
                                        </table>
                                    </form>





                                </fieldset>


                            </c:when>
                            <c:when test="${(!empty pgdetails) &&(empty pginfo)}">

                                <form   class="form-horizontal centeredForm" action="save_pgimage" method="post" enctype="multipart/form-data">


                                    <table>
                                        <tr>

                                            <td colspan ="2">Upload Your Passport</td>
                                            <td><input type="file" name="result1" size="50"/></td>
                                        </tr>
                                        <tr >
                                            <td colspan="2">

                                            </td>
                                            <td> <button type="submit" class="btn" >Submit </button></td>
                                        </tr>
                                    </table>
                                </form>

                            </c:when>
                        </c:choose>
                    </section>

                </div> <!-- end right bar-->
            </div> <!-- end row-->


        </div> <!--end container-->


        <!--
        -->            </body>
</html>
