const modal = document.getElementById("modal");

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

document.querySelectorAll('.product__details').forEach(button => {
    button.addEventListener('click', function(event) {
        event.preventDefault();

        let href = this.getAttribute('href');

        fetch(href, {
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
            .then(response => {
                console.log(response);

                document.getElementById('name').innerHTML = "<b>Nombre: </b>" + response.donative.name;
                document.getElementById('idUser').innerHTML = "<b>Donador: </b>" + response.userName;
                document.getElementById('type').innerHTML = "<b>Tipo: </b>" + response.donative.type;
                document.getElementById('condition').innerHTML = "<b>Estado: </b>" + response.donative.donativeCondition;

                if (response.donative.donativeCondition === "")
                    document.querySelector(".field--condition").style.display = 'none';
                else
                    document.querySelector(".field--condition").style.display = 'block';

                if (response.donative.type === "Asesoria")
                    document.getElementById('amount').innerHTML = "<b>Duración: </b>" + response.donative.amount + " horas";
                else
                    document.getElementById('amount').innerHTML = "<b>Cantidad: </b>" + response.donative.amount;

                document.getElementById('date').innerHTML = "<b>Fecha de publicación: </b>" + response.donative.donativeDate;
                document.getElementById('description').innerHTML = "<b>Descripción: </b>" + response.donative.description;

                //Show Modal
                modal.classList.add("modal--active");
            })
            .catch(error => console.error('Error:', error));
    });
});

function closeModal(){
    modal.classList.remove("modal--active");
}