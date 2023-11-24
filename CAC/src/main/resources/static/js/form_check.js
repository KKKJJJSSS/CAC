function form_check() {
    var title = document.getElementById("title").value
    var location = document.getElementById("location").value
    var age = document.getElementById("age").value
    var relationship = document.getElementById("relationship").value
    var money_spent = document.getElementById("money_spent").value
    var received_money = document.getElementById("received_money").value


    if (title == "") {
        alert("건물명을 입력해 주세요.");
        return false;
    }

    if (location == "") {
        alert("지역을 입력해 주세요.");
        return false;
    }

    if (age == "") {
        alert("나이를 입력해 주세요.");
        return false;
    }

    if (relationship == "") {
        alert("관계를 입력해 주세요.");
        return false;
    }

    if (money_spent == "") {
        alert("금액을 입력해 주세요.");
        return false;
    }

    if (received_money == "") {
        alert("금액을 입력해 주세요.");
        return false;
    }

    return true;
}

function login_form_check() {
    var username = document.getElementById("username").value
    var password = document.getElementById("password").value

    if (username == "") {
        alert("아이디를 입력해 주세요.");
        return false;
    }

    if (password == "") {
        alert("비밀번호 입력해 주세요.");
        return false;
    }
    return true;
}
