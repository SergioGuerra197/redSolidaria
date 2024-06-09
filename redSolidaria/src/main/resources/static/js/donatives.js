const modal = document.getElementById("modal");

function openModal(){
    modal.classList.add("modal--active")
}

function closeModal(){
    modal.classList.remove("modal--active")
}

// Hacer la solicitud a la ruta /filter/food
/*fetch('/donatives/filter/food')
    .then(response => {
        if (!response.ok) {
            throw new Error('Error al obtener los datos');
        }
        return response.json();
    })
    .then(data => {
        // Verificar si la respuesta tiene datos (es decir, si se cumplió la condición)
        if (data && data.length > 0) {
            // Mostrar el contenido condicional
            document.getElementById("teach_link_link").classList.remove("navtype__link--active");
            document.getElementById("supplies_link_link").classList.remove("navtype__link--active");
            document.getElementById("food_link").classList.add("navtype__link--active");
            document.getElementById("other_link_link").classList.remove("navtype__link--active");
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });*/