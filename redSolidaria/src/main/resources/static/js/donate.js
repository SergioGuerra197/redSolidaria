const optionType = document.getElementById("type");
const amountTitle = document.getElementById("amount_title");
const amountPlaceholder = document.getElementById("amount_label");
const conditionArea = document.getElementById("condition_area");

const leftPanel = document.querySelector(".donateleft");
const rightPanel = document.querySelector(".donateright");

optionType.addEventListener('change', function (){
    if (this.value === 'Asesoria'){
        amountTitle.innerText = "Indique una duración";
        amountPlaceholder.innerText = "Horas";
        conditionArea.style.setProperty("display", "none");

        rightPanel.insertBefore(document.querySelector(".entryarea--amount"), rightPanel.firstChild);
        rightPanel.insertBefore(amountTitle, rightPanel.firstChild);

        leftPanel.removeChild(amountTitle);
        leftPanel.removeChild(document.querySelector(".entryarea--amount"));
    } else {
        amountTitle.innerText = "Indique una cantidad";
        amountPlaceholder.innerText = "Cantidad";
        conditionArea.style.setProperty("display", "block");

        leftPanel.appendChild(amountTitle);
        leftPanel.appendChild(document.querySelector(".entryarea--amount"));

        rightPanel.removeChild(amountTitle);
        rightPanel.removeChild(document.querySelector(".entryarea--amount"));
    }
});