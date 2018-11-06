(function($) {

  // :: Nicescroll Active Code
    if ($.fn.niceScroll) {
        $(".cart-list, .cart-content").niceScroll();
    }

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

  

})(jQuery);

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



