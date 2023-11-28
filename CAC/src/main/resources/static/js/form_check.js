function form_check() {
    var title = document.getElementById("title").value
    var location = document.getElementById("location").value
    var age = document.getElementById("age").value
    var relationship = document.getElementById("relationship").value
    var money = document.getElementById("money").value
    var money_type = document.getElementById("money_type").value


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
    } else if (isNaN(age)) {
        alert("숫자를 입력해 주세요.");
        return false;
    }

    if (relationship == "") {
        alert("관계를 입력해 주세요.");
        return false;
    }

    if (money == "") {
        alert("금액을 입력해 주세요.");
        return false;
    } else if (isNaN(money)) {
        alert("숫자를 입력해 주세요.");
        return false;
    }

    if (money_type == "") {
        alert("선택해 주세요");
        return false;
    }

    return true;
}
