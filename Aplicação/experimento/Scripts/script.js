window.onload=function(){
  $(document).ready(function() {
    $(window).scroll(function() {
      if ($(document).scrollTop() > 200) {
        $('#nav').addClass('shrink');
      } else {
              $('#nav').removeClass('shrink');
        }
    });
  });
}

if (window.parent && window.parent.parent) {
  window.parent.parent.postMessage(["resultsFrame", {
    height: document.body.getBoundingClientRect().height,
    slug: ""}], "*")
}