const registerButton = document.querySelector(".rgs-btn");

registerButton.onclick = () => {
    const accountInputs = document.querySelectorAll(".rgs-input");

    let user = {
        id: accountInputs[0].value,
        username: accountInputs[1].value,
        nickname: accountInputs[2].value,
        email: accountInputs[3].value,
        password: accountInputs[4].value
    }

    $.ajax({
            async: false,                       //필수
            type: "post",                       //필수
            url: "/api/account/register",       //필수
            contentType: "application/json",    //전송할 데이터가 json인 경우
            data: JSON.stringify(user),         //전송할 데이터가 있으면
            dataType: "json",                   //json외 text 등을 사용할 수 있지만 json 사용함
            success: (response) => {              //성공시에 실행될 메소드
                alert("회원가입 요청 성공");
                console.log(response);
            },
            error: (error) => {                 //실패시에 실행될 메소드
                alert("회원가입 요청 실패");
                console.log(error.responseJSON);

            }
    });

}