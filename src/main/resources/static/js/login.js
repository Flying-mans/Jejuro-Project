

function popUp() {

    let width = 500;
    let height = 1500;

    let left = (window.screen.width / 2) - (width / 2);
    let top = (window.screen.height / 4);

    let status = 'width=' + width + ', height=' + height + ', left=' + left + ', top=' + top + ', scrollbars=yes, status=no, resizable=yes, titlebar=no';

    const url = "http://localhost:8081/member/password";

    window.open(url, "popup", status);
};

window.addEventListener("load", function () {
    let login = document.querySelector("body");
    let userInput = login.querySelector(".input.username");
    let passwdInput = login.querySelector(".input.password");
    let username = login.querySelector(".placeholder.username");
    let password = login.querySelector(".placeholder.password");
    let eye = login.querySelector(".fa-eye");
    let eyeSlash = login.querySelector(".fa-eye-slash");

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
        if (el != username && userInput != focusEle && userInput.value.trim() === '')
            username.classList.remove("placeholder-focus");
        if (el != password && passwdInput != focusEle && passwdInput.value.trim() === "") {
            password.classList.remove("placeholder-focus");
            eye.classList.add("d-none");
            eyeSlash.classList.add("d-none");
        }

        // 비밀번호 클릭시 눈 모양 아이콘 보이게 
        // d-none클래스 삭제
        if (passwdInput === focusEle)
            eye.classList.remove("d-none");

        // 비밀번호 눈모양 아이콘 클릭시 
        // eye 가리고 eyeSlash 표시 
        // 패스워드타입 txt로 변경
        if (el.classList.contains("fa-eye")) {
            el.classList.add("d-none");
            eyeSlash.classList.remove("d-none");
            passwdInput.type = 'text';
        }

        // eyeSlash 아이콘 클릭시
        // eyeSlash 가리고 eye 표시
        // 패스워드 타입 password로 변경
        if (el.classList.contains("fa-eye-slash")) {
            el.classList.add("d-none");
            eye.classList.remove("d-none");
            passwdInput.type = 'password';
        }
    }
    /** 
     * 탭을 이용해서 placeholder가 올라갈 수 있게 추가
     */
    userInput.onfocus = function () {
        username.classList.add("placeholder-focus");
    }
    passwdInput.onfocus = function () {
        password.classList.add("placeholder-focus");
        eye.classList.remove("d-none");
    }
});