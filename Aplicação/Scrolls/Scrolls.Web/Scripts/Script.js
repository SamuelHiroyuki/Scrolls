(function($) {
  // NAVIGATION
  var responsiveNav = $('#responsive-nav'),
    catToggle = $('#responsive-nav .category-nav .category-header'),
    catList = $('#responsive-nav .category-nav .category-list'),
    menuToggle = $('#responsive-nav .menu-nav .menu-header'),
    menuList = $('#responsive-nav .menu-nav .menu-list');

  catToggle.on('click', function() {
    menuList.removeClass('open');
    catList.toggleClass('open');
  });

  menuToggle.on('click', function() {
    catList.removeClass('open');
    menuList.toggleClass('open');
  });

  $(document).click(function(event) {
    if (!$(event.target).closest(responsiveNav).length) {
      if (responsiveNav.hasClass('open')) {
        responsiveNav.removeClass('open');
        $('#navigation').removeClass('shadow');
      } else {
        if ($(event.target).closest('.nav-toggle > button').length) {
          if (!menuList.hasClass('open') && !catList.hasClass('open')) {
            menuList.addClass('open');
          }
          $('#navigation').addClass('shadow');
          responsiveNav.addClass('open');
        }
      }
    }
  });
        
//HOME SLICK
$('#home-slick').slick({
    autoplay: true,
    infinite: true,
    speed: 300,
    arrows: true,
});

// PRODUCTS SLICK
$('#product-slick-1').slick({
    slidesToShow: 4,
    slidesToScroll:  4,
    autoplay: true,
    infinite: true,
    speed: 300,
    dots: true,
    arrows: false,
    appendDots: '.product-slick-dots-1',
    responsive: [{
        breakpoint: 991,
            settings: {
                slidesToShow: 1,
                slidesToScroll: 1,
            }
        },
        {
        breakpoint: 480,
        settings: {
            dots: false,
            arrows: true,
            slidesToShow: 1,
            slidesToScroll: 1,
        }
        },
    ]
});

$('#product-slick-2').slick({
    slidesToShow: 4,
    slidesToScroll: 4,
    autoplay: true,
    infinite: true,
    speed: 300,
    dots: true,
    arrows: false,
    appendDots: '.product-slick-dots-2',
    responsive: [{
        breakpoint: 991,
        settings: {
            slidesToShow: 1,
            slidesToScroll: 1,
        }
        },
        {
        breakpoint: 480,
        settings: {
            dots: false,
            arrows: true,
            slidesToShow: 1,
            slidesToScroll: 1,
        }
        },
    ]
});
     
$('#product-slick-3').slick({
    slidesToShow: 4,
    slidesToScroll:  4,
    autoplay: true,
    infinite: true,
    speed: 300,
    dots: true,
    arrows: false,
    appendDots: '.product-slick-dots-3',
    responsive: [{
        breakpoint: 991,
            settings: {
                slidesToShow: 1,
                slidesToScroll: 1,
            }
        },
        {
        breakpoint: 480,
            settings: {
                dots: false,
                arrows: true,
                slidesToShow: 1,
                slidesToScroll: 1,
            }
        },
    ]
});
})(jQuery);

$(document).ready(function () {
    $("#product-main-view").owlCarousel({
        navigation: true,
        slideSpeed: 300,
        loop: true,
        nav: true,
        navText: ["<i class='icon ion-md-arrow-round-back'><i>", "<i class='icon ion-md-arrow-round-forward'><i>"],
        paginationSpeed: 400,
        singleItem: true,
        items: 1,
    });
});

var cartbtn1 = $('#essenceCartBtn');
var cartOverlay = $(".cart-bg-overlay");
var cartWrapper = $(".right-side-cart-area");
var cartbtn2 = $("#rightSideCart");
var cartOverlayOn = "cart-bg-overlay-on";
var cartOn = "cart-on";

cartbtn1.on('click', function () {
    cartOverlay.toggleClass(cartOverlayOn);
    cartWrapper.toggleClass(cartOn);
});
cartOverlay.on('click', function () {
    $(this).removeClass(cartOverlayOn);
    cartWrapper.removeClass(cartOn);
});
cartbtn2.on('click', function () {
    cartOverlay.removeClass(cartOverlayOn);
    cartWrapper.removeClass(cartOn);
});



