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

