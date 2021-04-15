var prevScrollpos = window.pageYOffset;
window.onscroll = function () {
  let navbar = document.getElementById("navbar");
  var currentScrollPos = window.pageYOffset;
  if (currentScrollPos < 300 || currentScrollPos < prevScrollpos) {
    navbar.style.top = "0";
    navbar.style.background = "none";
    if (currentScrollPos > 360 && currentScrollPos < prevScrollpos) {
      navbar.style.background = "#302121c8";
    }
  } else {
    navbar.style.top = "-100px";
  }
  prevScrollpos = currentScrollPos;
};
