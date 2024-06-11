const modal = document.getElementById("modal");

function getDonativeInfo(href){
    return fetch(href, {
        headers: {
            'Accept': 'application/json'
        }
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al obtener los datos');
            }
            return response.json();
        })
        .catch(error => console.error('Error:', error));
}

document.addEventListener('DOMContentLoaded', function (){
   switch(new URLSearchParams(window.location.search).get('type')){
       case 'Asesoria':
           document.getElementById('teach_link').classList.add('navtype__link--active');
           break;
       case 'Util escolar':
           document.getElementById('supplies_link').classList.add('navtype__link--active');
           break;
       case 'Alimento':
           document.getElementById('food_link').classList.add('navtype__link--active');
           break;
       case "Varios":
           document.getElementById('other_link').classList.add('navtype__link--active');
           break;
       default:
           document.getElementById('all_link').classList.add('navtype__link--active');
           break;
   }
});

document.querySelectorAll('.product__details').forEach(a => {

    a.addEventListener('click', async function(event) {
        event.preventDefault();

        document.querySelector(".modal__product").style.display = "block";
        document.querySelector(".modal__contact").style.display = "none";


        try {
            let response = await getDonativeInfo(this.getAttribute('href')); // Espera a que se resuelva la promesa

            // Extrae donative y userName de la respuesta
            let { donative, user } = response;

            document.getElementById('name').innerHTML = "<b>Nombre: </b>" + donative.name;
            document.getElementById('idUser').innerHTML = "<b>Donador: </b>" + user.name;
            document.getElementById('type').innerHTML = "<b>Tipo: </b>" + donative.type;
            document.getElementById('condition').innerHTML = "<b>Estado: </b>" + donative.donativeCondition;

            if (donative.donativeCondition === "")
                document.querySelector(".field--condition").style.display = 'none';
            else
                document.querySelector(".field--condition").style.display = 'block';

            if (donative.type === "Asesoria")
                document.getElementById('amount').innerHTML = "<b>Duración: </b>" + donative.amount + " horas";
            else
                document.getElementById('amount').innerHTML = "<b>Cantidad: </b>" + donative.amount;

            document.getElementById('date').innerHTML = "<b>Fecha de publicación: </b>" + donative.donativeDate;
            document.getElementById('description').innerHTML = "<b>Descripción: </b>" + donative.description;

            //Show Modal
            modal.classList.add("modal--active");
        } catch (error) {
            console.error('Error:', error);
        }
    });
});

document.querySelectorAll(".contact--button").forEach(a => {
    a.addEventListener('click', async function (event){
        event.preventDefault();

        document.querySelector(".modal__contact").style.display = "flex";
        document.querySelector(".modal__product").style.display = "none";

        try {
            let response = await getDonativeInfo(this.getAttribute('href')); // Espera a que se resuelva la promesa
            console.log(response)

            // Extrae los datos del donador
            let { donative, user } = response;
            console.log(user)

            document.querySelector(".contact__email").value = user.email;
            document.getElementById("contact__subject").value = "Alguien se ha interesado en tu donación: " + donative.name;

            //Show Modal
            modal.classList.add("modal--active");
        } catch (error) {
            console.error('Error:', error);
        }
    });
});

document.querySelector(".modal__close").addEventListener('click', function (){
    modal.classList.remove("modal--active");
});