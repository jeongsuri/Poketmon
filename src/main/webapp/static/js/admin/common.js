window.addEventListener("DOMContentLoaded", function () {
   const winHeight = innerHeight;
   const mainEl = document.querySelector("main");
   const headerEl = document.querySelector("header");
   mainEl.style.height = (winHeight - headerEl.clientHeight) + "px";
   console.log(winHeight - headerEl.clientHeight);
});