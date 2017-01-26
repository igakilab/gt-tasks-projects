$(document).ready(function(){
	//reloadMessages();
	loadThreads();
	$(".less").on('click', function(){
		var toukou = $("#toukou").serializeJson();

		Keijiban.postMessage(toukou, function(reply){
			reloadMessages();
		});
	});
});

function reloadMessages(){
	Keijiban.getMessages(function(reply){
		var $board = $(".keijiban");

		$board.empty();
		for(var i=0; i<reply.length; i++){
			$board.append("<h4 class='name' style='display:inline'>"+reply[i].name+"</h4>");
			$board.append(" <h6 class='time' style='display:inline'>"+reply[i].time+"</h6>");
			$board.append("<p class='message'>"+reply[i].message+"</p>");
		}
	});
}

function loadThreads(){
	$thread = $(".thread");
	$thread.append("<h3>スレッド一覧</h3>");
	$thread.append("<ul class='Tlist'><li><a href='#aaaaa'>aaaaa</a></li><li><a href='#bbbbb'>bbbbb</a></li></ul>");
	$(".Tlist").on('click',function(){
			$("#toukou").css("display","");
			$(".keijiban").css("display","");
			$thread.css("display","none");
			//reloadMessages();
	});

}