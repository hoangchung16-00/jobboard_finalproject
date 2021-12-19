
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

function requestDeny(id) {
	$.ajax({
		type: 'GET',
		contentType: "application/json",
		url: '/deny',
		data: {
			id: id
		},
		success: function (result) {
			$('#message').text(result);
		},
		error: function (e) {
			alert('error')
			console.log("ERROR: ", e);
		}
	});
	$('#status'+id).text("Denied");
}

function requestAccept(id) {
	$.ajax({
		type: 'GET',
		contentType: "application/json",
		url: '/accept',
		data: {
			id: id
		},
		success: function (result) {
			$('#message').text(result);
		},
		error: function (e) {
			alert('error')
			console.log("ERROR: ", e);
		}
	});
	$('#status'+id).text("Accept");
}

function deny(id) {
	$('#message').text('Deny this request');
	$('#approveButton').on("click",() => requestDeny(id));
	$('#denyModal').modal('show');
}

function accept(id) {
	$('#message').text('Accept this request');
	$('#approveButton').on("click",() => requestAccept(id));
	$('#denyModal').modal('show');
}

function searchJob() {
  	const key =	$('#keyword').val();
  	if(key == ''){
  		window.location.href = '/findJob/all';
	} else {
  		window.location.href = '/findJob/' + key;
	}
}

class SkillInput {
	static id = 0;
	static addSKill(){
		if($('#skillName'+SkillInput.id).val()===""){
			return;
		}
		SkillInput.id = SkillInput.id + 1;
		$('#skillName'+(SkillInput.id-1)).after("<input placeholder='Skill Name' id='skillName"+ SkillInput.id + "' class='form-control' name='skillNameList["+ SkillInput.id +"]'/>")
		$('#skillEx'+(SkillInput.id-1)).after("<select id='skillEx"+ SkillInput.id + "' class='form-control' name='skillExperienceList["+SkillInput.id+"]'>" +
			"<option class=\"form-control\" value=\"1\">Internship</option>" +
			"<option class=\"form-control\" value=\"2\">Fresher</option>" +
			"<option class=\"form-control\" value=\"2\">Fresher</option>" +
			"<option class=\"form-control\" value=\"4\">Middle</option>" +
			"<option class=\"form-control\" value=\"5\">Senior</option>" +
			"</input>")
	}
}


