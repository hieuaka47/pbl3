
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
   
   	$("#tag-a").click(function(event){
		event.preventDefault();
    var oldP = $("#oldP").val();
    var newP = $("#newP").val();
    var reNewP = $("#reNewP").val();
    $.ajax ({
      url: 'change_password',
      type: 'POST',
      data: {
        oldP: oldP,
        newP: newP,
        reNewP: reNewP
      },
      success: function(data){
         alert(data);
         location.reload(); 
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