var $itemImport = $(".nyuuka"),$itemOutport = $(".syukka");
var $btnImport = $(".nyuukabtn"),$btnOutport = $(".syukkabtn");
var $list = $('#list');

function initList(){
	var List = Zaiko.getItemList();
	console.log(List);
	$list.append("<tr><td class='sname'>"+List.name+"</td><td class='snum'>"+List.amount+"</td><td><span class='syukka'><input type='text' id='syukka-kosuu'/></span><span class='sbtn'><button class='syukkabtn'>出荷</button></span></td></tr>");
}

$btnImport.on('click',function(){

	var name = $('#syohinmei').val();
	var amount = $('#nyuuka-kosuu').val();
	console.log(name);
	console.log(amount);
	var status = Zaiko.receiveItem({name,amount});
	console.log(status);

	if(status)initList();


});

$('table').on('click',$btnOutport,function(){

	var itemname = $('.sname').text();
	var amount = $('.snum').text();
	var need = $('#syukka-kosuu').val();

	var status = Zaiko.issuelItem({itemname,need});

	if(status)initList();


});