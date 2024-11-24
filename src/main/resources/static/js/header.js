// function toggleMenu() {
//     const menu = document.getElementById('nav-menu');
//     menu.classList.toggle('active'); // Toggle the 'active' class
// }
// function toggleMenu() {
//     const menu = document.getElementById('nav-menu');
//     menu.classList.toggle('active');
// }

let menu = document.querySelector("#menu-icon");
let img = document.querySelector(".change");
let navbar = document.querySelector(".navbar");
let isIcon1 = true;

menu.onclick = () => {
if (isIcon1) {
    img.src = "/images/close.png";
} else {
    img.src = "/images/menu.png";
}
isIcon1 = !isIcon1;
navbar.classList.toggle("open");
};