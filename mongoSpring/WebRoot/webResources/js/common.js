function createSimpleWindow(divName,name,href,width,height){
	/*var div = "<div class='positionFix' id='"+divName+"' style='margin-left:-"+parseInt(width/2+50)+"px;margin-top:-"+parseInt(height/2)+"px'>"
		+"<iframe id='"+divName+"_frm' width='"+width
		+"px' height='"+height+"'px scrolling='no' frameborder='0'></iframe>";
	$(window.document.body).append(div);
	window.$("#"+divName+"_frm").attr("src",href);*/
	var iframe='<iframe id="'+divName+'_frm" width='+parseInt(width)+'px height='+height+'px scrolling="no" frameborder="0"></iframe>';
	//var iframe='<iframe id="'+divName+'_frm" scrolling="no" frameborder="0"></iframe>';
	var div='<div id="'+divName+'" style="width:'+parseInt(width+50)+'px;margin-left:-'+parseInt((width+50)/2)+'px;height:'+parseInt(height+110)+'px;"'
		+'class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">'
		+'<div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>'
		+'<h3 id="myModalLabel">'+name+'</h3></div><div class="modal-body">'+iframe+'</div><div class="modal-footer">'
		+'</div></div>';
//	$('#'+divName).css("width","'"+width+"px'");
//	$('#'+divName).css("margin-left","'-"+parseInt(width/2)+"px'");
	$(window.document.body).append(div);
	$('#'+divName).modal('show');
	window.$("#"+divName+"_frm").attr("src",href);
}

function close_win(id){
	$('#'+id).modal('hide');
}