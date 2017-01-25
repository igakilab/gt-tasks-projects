$(document).ready(function(){
	reloadList();

	$(".nyuukabtn").on('click', function(){
		var input = $("#nyuuka").serializeJson();

		Zaiko.receiveItem(input, function(reply){
			reloadList();
		});
	});
})

function reloadList(){
	Zaiko.getItemList(function(reply){
		var $list = $("#list");

		//表をクリア
		$list.empty();
		$list.append("<tr><th>商品名</th><th>個数</th><th>出荷</th></tr>");

		for(var i=0; i<reply.length; i++){
			var $inputAmount = $("<input></input>").attr("type", "text");
			var $exbtn = $("<button></button>").text("出荷");

			//ボタンにイベントを登録
			$exbtn.on('click', {sname:reply[i].name, $inputAmount}, function(e){
				syukka(e.data.sname, e.data.$inputAmount.val());
			});

			//表に追加
			$list.append($("<tr></tr>").append(
				$("<td></td>").text(reply[i].name),
				$("<td></td>").text(reply[i].amount),
				$inputAmount, $exbtn
			));
		}
	});
}

function syukka(name, amount){
	Zaiko.issueItem({name, amount}, function(reply){
		if( reply ){
			alert(name + "を" + amount + "個出荷しました");
			reloadList();
		}else{
			alert("在庫が足りません");
		}
	});
}