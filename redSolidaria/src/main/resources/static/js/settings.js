var actualPass = document.getElementById("actual_password").value;
var firstPass = document.getElementById("first_password").value;
var secondPass = document.getElementById("password").value;

// Event listener for input event on the current password field
actualPass.addEventListener("input", () => {
    if (actualPass.value.trim() === "") {
        firstPass.addClass("disabled")
        firstPass.disabled = true;
        secondPass.addClass("disabled")
        secondPass.disabled = true;
    } else {
        firstPass.disabled = false;
        secondPass.disabled = false;
    }
});

