window.addEventListener("load", function(){
    const password = document.querySelector(".password");
    const passwordConfirm = document.querySelector(".password-confirm");
    
    function validatePassword(){
        if(password.value != passwordConfirm.value) { 
        passwordConfirm.setCustomValidity("Passwords Don't Match"); 
    } 
        else {
        passwordConfirm.setCustomValidity(''); 
    }
    }
    
    password.onchange = validatePassword;
    passwordConfirm.onkeyup = validatePassword;

});
