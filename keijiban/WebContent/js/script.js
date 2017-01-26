$(document).ready(function(){
	loadRooms();

	$(".less").on('click', function(){
		var input = $("#toukou").serializeJson();

		Keijiban.postMessage(input, function(reply){
			loadMessages(input.room);
		});
	});
});

function initForm(room){
	if( room ){
		$(".room-header").css("display", "none");
		$("#roomInput").val(room).attr("type", "hidden");
		$(".less").text("投稿");
	}else{
		$(".room-header").css("display", "");
		$("#roomInput").val("").attr("type", "text");
		$(".less").text("ルーム作成");
	}
}

function loadMessages(room){
	Keijiban.getMessages(room, function(reply){
		var $board = $(".keijiban");
		initForm(room);

		$board.empty();
		$board.append("<h3>" + room + "</h3>");
		for(var i=0; i<reply.length; i++){
			$board.append("<h4 class='name' style='display:inline'>"+reply[i].name+"</h4>");
			$board.append(" <h6 class='time' style='display:inline'>"+reply[i].time+"</h6>");
			$board.append("<p class='message'>"+reply[i].message+"</p>");
		}
	});
}

function loadRooms(){
	Keijiban.getRoomList(function(reply){
		$list = $(".room-list");
		initForm(null);

		$list.empty();
		for(var i=0; i<reply.length; i++){
			var $link = $("<a></a>").attr("href", "#").text(reply[i]);
			$link.on('click', {room:reply[i]}, function(e){
				loadMessages(e.data.room);
			});

			$list.append($("<li></li>").append($link));
		}
	});
}