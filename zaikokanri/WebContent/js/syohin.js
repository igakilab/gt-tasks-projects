var $itemImport = $(".nyuuka");
var $btnImport = $(".nyuukabtn");
var $list = $('#list');

initList();

function initList(){
	Zaiko.getItemList(function(reply){
		$list.empty();
		$list.append("<tr><th>商品名</th><th>個数</th><th>出荷</th></tr>");

		for(var i=0; i<reply.length; i++){
			var $inputAmount = $("<input></input>").attr("type", "text");
			var $exbtn = $("<button></button>").text("出荷");

			//ボタンにイベントを登録
			$exbtn.on('click', {sname:reply[i].name, $inputAmount}, function(e){
				var name = e.data.sname;
				var amount = e.data.$inputAmount.val();

				Zaiko.issueItem({name, amount}, function(reply){
					if( reply ){
						alert(name + "を" + amount + "個出荷しました");
						initList();
					}else{
						alert("在庫が足りません");
					}
				});
			});

			$list.append($("<tr></tr>").append(
				$("<td></td>").text(reply[i].name),
				$("<td></td>").text(reply[i].amount),
				$inputAmount, $exbtn
			));
		}
	});
}

$btnImport.on('click',function(){
	var input = $("#nyuuka").serializeJson();

	Zaiko.receiveItem(input, function(reply){
		initList();
	});
});