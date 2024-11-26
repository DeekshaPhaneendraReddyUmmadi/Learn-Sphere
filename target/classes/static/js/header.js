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