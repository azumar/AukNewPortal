function validateRegForm()
{
    var regNo = document.forms["regForm"]["regNo"].value;
    var jambNo = document.forms["regForm"]["jambNo"].value;
    var firstName = document.forms["regForm"]["firstName"].value;
    var lastName = document.forms["regForm"]["lastName"].value;
    var dob = document.forms["regForm"]["dob"];
    // var dateformat = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;  
    /^([0-9]{2})\/([0-9]{2})\/([0-9]{4})$/
    if (regNo === null || regNo === "")
    {
        alert("Registration Number cannot be blank");

        document.regForm.regNo.focus();
        return false;
    }
    else if (jambNo === null || jambNo === "")
    {
        alert("Jamb Number cannot be blank");

        document.regForm.jambNo.focus();
        return false;
    }

    else if (firstName === null || firstName === "")
    {
        alert("First Name cannot be blank");

        document.regForm.firstName.focus();
        return false;
    }
    else if (lastName === null || lastName === "")
    {
        alert("Last Name cannot be blank");

        //document.regForm.lastName.focus();
        return false;
    }

    $.get('studentExist', {regNo: regNo}, function(r)
    {
        alert(r);
 return false;

    });


}
