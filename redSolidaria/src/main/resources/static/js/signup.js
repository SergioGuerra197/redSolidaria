const email = document.getElementById("email_signup");

email.addEventListener('input', function (){
    let email_pattern = /^[a-zA-Z0-9._%+-]+@elpoli\.edu\.co$/;

    if (email.value !== "") {
        if (!(email_pattern.test(email.value)))
            email.setCustomValidity('Dominio no valido.')
        else
            email.setCustomValidity('')
    } else
        email.setCustomValidity('Rellene este campo.')
});