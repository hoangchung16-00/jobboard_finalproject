
$(document).ready(function(){
			$("#testimonial-slider").owlCarousel({
				items:1,
				itemsDesktop:[1000,1],
				itemsDesktopSmall:[979,1],
				itemsTablet:[768,1],
				pagination: true,
				autoPlay:false
			});
		});
function apply(id,isLogin) {
	if(!isLogin){
		window.location.href = "/login";
	} else {
		$.ajax({
			type: 'GET',
			contentType: "application/json",
			url: '/apply',
			data: {
				id: id
			},
			success: function (result) {
				var result = JSON.parse(result);
				alert(result)
			},
			error: function (e) {
				alert('error')
				console.log("ERROR: ", e);
			}
		});
	}

}