function enviarDatos() {
    var id = document.getElementsByName("id").value;
    var name = document.getElementsByName("name").value;
    var email = document.getElementsByName("email").value;
    var password = document.getElementsByName("password").value;
    var contactNumber = document.getElementsByName("contact_number").value;
    var role = document.getElementsByName("role").value;

    var datos = {
        id: id,
        name: name,
        email: email,
        password: password,
        contactNumber: contactNumber,
        role: role
    };

    fetch('http://localhost:8080/api/v1/users/signup', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error al registrar el usuario');
        }
        return response.json();
    })
    .then(data => {
        // Manejar la respuesta de la API si es necesario
        console.log(data);
    })
    .catch(error => {
        console.error('Error:', error);
    });
}
