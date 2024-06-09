
const actualPass = document.getElementById("actual_password");
const firstPass = document.getElementById("first_password");
const secondPass = document.getElementById("password");
const labels = document.getElementsByClassName("label__pass");
const userN = document.getElementById("name");
const contactN = document.getElementById("contact_number");

function validatePassField() {
    if (actualPass.value.trim() === "" &&
        userN.value.trim() !== "" &&
        contactN.value.trim() !== "")
            actualPass.removeAttribute("required");
}

actualPass.addEventListener("input", function(){
    if (actualPass.value.trim() === "") {
        for (let i = 0; i < labels.length; i++) {
            labels[i].classList.add("fixed");
        }

        firstPass.classList.add("disabled");
        firstPass.disabled = true;
        firstPass.value = "";

        secondPass.classList.add("disabled");
        secondPass.disabled = true;
        secondPass.value = "";
    } else {
        for (let i = 0; i < labels.length; i++) {
            labels[i].classList.remove("fixed");
        }

        firstPass.classList.remove("disabled");
        firstPass.disabled = false;

        secondPass.classList.remove("disabled");
        secondPass.disabled = false;
    }
});

firstPass.addEventListener('input', function(){
    if (secondPass.value !== "") {
        if (firstPass.value !== secondPass.value)
            secondPass.setCustomValidity('Las contraseñas no coinciden.');
        else
            secondPass.setCustomValidity('');
    } else
        secondPass.setCustomValidity('Rellene este campo.');
});

secondPass.addEventListener('input', function(){
    if (secondPass.value !== "") {
        if (firstPass.value !== secondPass.value)
            secondPass.setCustomValidity('Las contraseñas no coinciden.');
        else
            secondPass.setCustomValidity('');
    } else
        secondPass.setCustomValidity('Rellene este campo.');
});
