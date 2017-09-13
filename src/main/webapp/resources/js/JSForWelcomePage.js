/*$(document).ready(function () {
    $("#username").keyup(function () {
        $.ajax({
            url: "/checkUniqueUserName?name=" + $("#username").val(),
            method: "Post",
            success: function (response) {
                if (response == "Username available") {
                    // $("#usernameAvailability").css("color", "green");
                    $("#usernameAvailability").text(response).css("color", "green");
                    $('#register').attr('disabled', false);
                }
                else {
                    // $("#usernameAvailability").css("color", "red");
                    $("#usernameAvailability").text(response).css("color", "red");
                    $('#register').attr('disabled', true);
                }
            }
        })
    });
});

$(document).ready(function () {
    $("#email").keyup(function () {
        $.ajax({
            url: "/checkUniqueEmail?mail=" + $("#email").val(),
            method: "Post",
            success: function (response) {
                if (response == "Username available") {
                    // $("#emailAvailability").css("color", "green");
                    $("#emailAvailability").text(response).css("color", "green");
                    $('#register').attr('disabled', false);
                }
                else {
                    // $("#emailAvailability").css("color", "red");
                    $("#emailAvailability").text(response).css("color", "red");
                    $('#register').attr('disabled', true);
                }
            }
        })
    });
});*/
$(document).ready(function () {
    jQuery("span#myspan").hide();
    jQuery("p#invalidUserNotify").hide();
});

function checkusername()
{
    var v=document.getElementById("username").value;

    var url="uniqueusername?val="+v;
    if(window.XMLHttpRequest){
        request=new XMLHttpRequest();
    }
    else if(window.ActiveXObject){
        request=new ActiveXObject("Microsoft.XMLHTTP");
    }
    try{
        request.onreadystatechange=getInf;
        request.open("POST",url,true);
        request.send();
    }catch(e){alert("Unable to connect to server");}
}

var request;
function getInf(){
    if(request.readyState==4){
        var val=request.responseText;
        document.getElementById("usernameAvailability").innerHTML=val;
        if(val=="user name not available")
        {
            document.getElementById("updateProfileData").disabled=true;
            document.getElementById("register").disabled=true;
        }
        else
        {
            document.getElementById("updateProfileData").disabled=false;
            document.getElementById("register").disabled=false;
        }
    }
}

function passwordMatch() {
    var password = jQuery("#password").val();
    var confirmPassword = jQuery("#confirm_password").val();
    console.log(password, confirmPassword, password == confirmPassword);
    if (password == confirmPassword) {
        jQuery("span#myspan").hide();
        document.getElementById("updateUserPassword").disabled=false;
        return true
    } else {
        jQuery("span#myspan").show();
        document.getElementById("updateUserPassword").disabled=true;
        return false
    }
};

jQuery(document).on("focus", "#password", passwordMatch);
jQuery(document).on("focus", "#confirm_password", passwordMatch);
jQuery(document).on("change", "#confirm_password", passwordMatch);

