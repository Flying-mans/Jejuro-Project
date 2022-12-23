
window.addEventListener("load", function () {
    let login = document.querySelector("body");
    let userInput = login.querySelector(".input.username");
    let passwdInput = login.querySelector(".input.password");
    let username = login.querySelector(".placeholder.username");
    let password = login.querySelector(".placeholder.password");

    // 로그인 input 클릭시 placeholder가 위로 올라가는 기능
    login.onclick = function (e) {
        const el = e.target;
        const focusEle = document.activeElement;

        // input 클릭하면 placeholder 위로 올라가게 focus클래스 추가
        if (el.classList.contains("username")) {
            userInput.focus();
            username.classList.add("placeholder-focus");
        }
        if (el.classList.contains("password")) {
            passwdInput.focus();
            password.classList.add("placeholder-focus");
        }

        // focus가 없고 input.value가 공백일때 다시 내려오게
        // focus 클래스 삭제하고 눈모양 아이콘 가리기
        if (el != username && userInput != focusEle && userInput.value.trim() === "")
            username.classList.remove("placeholder-focus");
        if (el != password && passwdInput != focusEle && passwdInput.value.trim() === "") {
            password.classList.remove("placeholder-focus");
        }

        // 비밀번호 클릭시 눈 모양 아이콘 보이게 
        // d-none클래스 삭제
        if (passwdInput === focusEle)

        // 비밀번호 눈모양 아이콘 클릭시 
        // eye 가리고 eyeSlash 표시 
        // 패스워드타입 txt로 변경
        if (el.classList.contains("fa-eye")) {
            el.classList.add("d-none");
            passwdInput.type = 'text';
        }

        // 패스워드 타입 password로 변경
        if (el.classList.contains("fa-eye-slash")) {
            el.classList.add("d-none");
            passwdInput.type = 'password';
        }
    };

});