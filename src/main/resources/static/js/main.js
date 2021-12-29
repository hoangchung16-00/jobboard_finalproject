
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
				if(result=="0") {
					alert("Có lỗi xảy ra! Vui lòng thử lại sau!");
				}
				if(result=="1") {
					alert("Ứng tuyển thành công! Vui lòng đợi phản hồi từ nhà tuyển dụng");
				}
				if(result=="2") {
					alert("Bạn đã ứng tuyển công việc này! Vui lòng đợi phản hồi từ nhà tuyển dụng");
				}
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
	location.reload();
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
	location.reload();
}

function deny(id) {
	$('#message').text('Từ chối hồ sơ ứng viên');
	$('#approveButton').on("click",() => requestDeny(id));
	$('#denyModal').modal('show');
}

function accept(id) {
	$('#message').text('Đồng ý hồ sơ ứng viên ');
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

//drop
/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
function myFunction() {
	document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
	if (!event.target.matches('.dropbtn')) {
		var dropdowns = document.getElementsByClassName("customdrop-content");
		var i;
		for (i = 0; i < dropdowns.length; i++) {
			var openDropdown = dropdowns[i];
			if (openDropdown.classList.contains('show')) {
				openDropdown.classList.remove('show');
			}
		}
	}
}
