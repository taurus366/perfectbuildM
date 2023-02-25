window.onscroll = function() {myFunction()};

// let header = document.getElementById("myHeader");
let logoImg = document.querySelector(".company-image-article");
let tempScrolled = document.querySelector(".scrolled-temp");
let header = document.querySelector(".top-information-navigation-section");
let sticky = header.offsetTop;

function myFunction() {
  if (window.pageYOffset > sticky) {
    header.classList.add("sticky");
    logoImg.classList.add("scrolled-sticky");
    tempScrolled.classList.add("scrolled-temp");
  } else {
    header.classList.remove("sticky");
    logoImg.classList.remove("scrolled-sticky");
    tempScrolled.classList.remove("scrolled-temp");
  }
}

