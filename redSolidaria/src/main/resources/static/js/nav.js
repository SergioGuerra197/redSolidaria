let submenu = document.getElementById("submenu");
const username = document.getElementById('user-name');
function toggleMenu(){
    submenu.classList.toggle("open")
}
document.addEventListener('DOMContentLoaded', function() {
    if (username) {
        fetch('/settings/internal/name')
            .then(response => response.text())
            .then(data => {
                username.querySelector('span').textContent = data;
            })
            .catch(error => console.error('Error fetching user name:', error));
    }
});