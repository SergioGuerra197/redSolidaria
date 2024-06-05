const actualPass = document.getElementById("actual_password");
const firstPass = document.getElementById("first_password");
const secondPass = document.getElementById("password");
const labels = document.getElementsByClassName("label__pass");

function validatePassField() {
    if (actualPass.value.trim() === "")
        actualPass.removeAttribute("required");
    /*if(!(firstPass === secondPass)){
        secondPass.setCustomValidity("Las contraseñas no coinciden")
//        document.getElementById("parrafoPrueba").display = "block";
    }*/
}

document.addEventListener("DOMContentLoaded", function() {
    // Function to enable or disable the new password fields
    function toggleNewPasswordFields() {
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
    }

    // Event listener for input event on the current password field
    actualPass.addEventListener("input", toggleNewPasswordFields);

    // Initial call to set the correct state on page load
    toggleNewPasswordFields();
});
