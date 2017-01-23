var $itemImport = $(".nyuuka"),$itemOutport = $(".syukka");
var $btnImport = $(".nyuukabtn"),$btnOutport = $(".syukkabtn");
var $list = $('#list');

$btnImport.on('click',function(){

	var itemname = $('#syohinmei').val();
	var num = $('#nyuuka-kosuu').val();
	//var status = receiveItem(itemname,num);

	$list.append("<tr><td class='sname'>"+itemname+"</td><td class='snum'>"+num+"</td><td><span class='syukka'><input type='text' id='syukka-kosuu'/></span><span class='sbtn'><button class='syukkabtn'>出荷</button></span></td></tr>");


});

$('table').on('click',$btnOutport,function(){

	var itemname = $('.sname').text();
	var amount = $('.snum').text();
	var need = $('#syukka-kosuu').val();

	//var status = issuelItem(itemname,need);

	var num = amount - need;
	$('.snum').text(num);


});