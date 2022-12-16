
window.addEventListener("load", function(){
    let login = document.querySelector(".wrap-login");
    let input = login.querySelector(".input");
    let placeholder = login.querySelector(".placeholder");

    input.onclick = function(e){
        placeholder.classList.add("placeholder-focus")
    }
});