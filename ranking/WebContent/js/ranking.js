var $rankList = $(".ranking"), $btn = $('.inpbtn'), $inpScore = $(".less");

$btn.on('click',$inpScore,function(){

    var List = Ranking.getRanking("sinkei");
    console.log(List);
    $rankList.append("<table border='1' class='RList'><tr><th>順位</th><th>名前</th><th>点数</th></tr></table>");
    for(var tmp in List){
    	$(".RList").append("<tr><td>"+tmp.rank+"</td><td>"+tmp.name+"</td><td>"+tmp.score+"</td></tr>");
    }


});