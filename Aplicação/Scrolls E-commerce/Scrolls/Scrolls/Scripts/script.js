function trocaCor(){
	document.getElementById("lupa").style.color = "#F8C141";
}

function retrocaCor(){
	document.getElementById("lupa").style.color = "#0D7694";
}

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