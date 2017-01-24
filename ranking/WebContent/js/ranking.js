var $rankList = $(".ranking"), $btn = $('.inpbtn'), $inpScore = $(".less");

$(document).ready(function(){
	$(".inpbtn").on('click', function(){
		var name =
	});
});

$btn.on('click',$inpScore,function(){

    var List = Ranking.getRanking("sinkei");
    console.log(List);
    $rankList.append("<table border='1' class='RList'><tr><th>順位</th><th>名前</th><th>点数</th></tr></table>");
    for(var tmp in List){
    	$(".RList").append("<tr><td>"+tmp.rank+"</td><td>"+tmp.name+"</td><td>"+tmp.score+"</td></tr>");
    }


});

function showSinkeiRanking(){
	Ranking.getRanking("sinkei", function(list){
		var $rankList = $(".ranking");

		$rankList.append("<table border='1' class='rlist'>" +
			"<tr><th>順位</th><th>名前</th><th>点数</th></tr>" +
			"</table>");

		for(var tmp in list){
			$(".rlist").append("<tr><td>" + tmp.rank +
				"</td><td>" + tmp.name +
				"</td><td>" + tmp.score + "</td></tr>");
		}
	});
}