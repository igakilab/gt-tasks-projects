$board = $(".keijiban");
$btn = $(".less")
getMsg();

$btn.on('click', function (){
	var name = $('#name').val();
	var message = $('#message').val();
	var days = new Date();
	var month = days.getMonth()+1;
	var time = days.getFullYear()+"/"+month+"/"+days.getDate()+" "+days.getHours()+":"+days.getMinutes()+":"+days.getSeconds();
	//status = postMessage(name,message); 本番用
	$board.append("<h4 class='name' style='display:inline'>"+name+"</h4>");
	$board.append(" <h6 class='time' style='display:inline'>"+time+"</h6>");
	$board.append("<p class='message'>"+message+"</p>");
	$board.append("<hr>");
});

function getMsg(){
	//var name = PostForm.name;
	//var msg = PostForm.message;　本番用
	//var time = PostForm.time;
	var name="ああああああ"
	var msg="メッセージメッセージメッセージメッセージメッセージ"
	var time="1234/56/78 99:99:99"
	$board.append("<h4 class='name' style='display:inline'>"+name+"</h4>");
	$board.append(" <h6 class='time' style='display:inline'>"+time+"</h6>");
	$board.append("<p class='message'>"+msg+"</p>");
	$board.append("<hr>");
}