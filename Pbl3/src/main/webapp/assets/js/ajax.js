
$(document).ready(function() {
	$(".product ul li").click(function(event){
		event.preventDefault();
    var id = $(this).val();
    $.ajax ({
      url: 'add-to-cart',
      type: 'GET',
      data: {
        id: id
      },
      success: function(data){
        swal("Congrats","Wow ! The Tour has been added to your cart ! <3 ","success");
      }
	})
   })
   
   	$(".cart_list tr td li").click(function(event){
		event.preventDefault();
    var key = $(this).val();
    $.ajax ({
      url: 'delete-from-cart',
      type: 'GET',
      data: {
        key: key
      },
      success: function(data){
		$("body").load("cart")
      }
	})
   })
});