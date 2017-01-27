$(document).ready(function(){
	$(".less-create").on('click', function(reply){
		var input = $("#toukou").serializeJson();

		Keijiban.postMessage(input, function(reply){
			location.href = "index.html?room=" + input.room;
		});
	});
})