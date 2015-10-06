$(document).ready(function(){
	
	$('head').append('<link href="/common/style/recommend.css" rel="stylesheet" type="text/css" />');
	var b = $(document.body).append('<div id="recommendbg" style="display:none;position:absolute;background:gray;z-index:10;left:0;top:0;filter:alpha(opacity=60);opacity:0.6;" ></div>');
	
	var resize = function(){
		var rpop = $('.brecommend');
		rpop.offset({'top' : $(document).scrollTop() + 50 , 'left' : (b.width() / 2 - rpop.width() / 2)});
		$('#recommendbg').css({'height' : b.height() , 'width' : '100%'});
	} , show = function(){
		$('#recommendbg').show() , $('.brecommend').show();
	} , hide = function(){
		$('#recommendbg').hide() , $('.brecommend').hide();
	}
	
	$(window).resize(resize).scroll(function(){
		$('#recommendbg').css({'height' : b.height() , 'width' : '100%'});
	});

	window.recommendBook = function(bookId){
		if(getCookieValue('chineseall.login') != null){
			if($('#recommend_' + bookId).length == 0){
				$('.brecommend').remove();
				$.ajax({
					url : '/user/recommendBook.jsps',
		  			data : {'bookId' : bookId},
					cache : false,
					async : false,
					dataType : "html",
					success : function(data){
						if(data){
							b.append(data);
	
							$('button[name="rclose"],a[name="rclose"]').bind('click' , hide);
							$('.rgroup dd').bind('click' , function(){
						  		$(this).toggleClass("selected");
						  	});
							
						  	$('#rmd').bind('click' , function(){
						  		var ritem = $('.ritem input:checked') , groupIds = '' , dds = $('.rgroup dd.selected') , btn = this;;
						  		for(var i = 0 ; i < dds.length ; i ++){
						  			groupIds += ('&groupId=' + dds[i].id);
								}
								if(ritem.length || groupIds){
									btn.disabled = true;
									btn.innerHTML = '处理中,请稍后...';
									var url = '/user/saveBookRecommend.jsps?bookId=' + bookId;
									for(var i = 0 ; i < ritem.length ; i ++){
							  			url += ('&' + ritem[i].name + '=1');
									}
									url += groupIds;
							  		$.ajax({
							  			url : url,
							  			data : {'comment' : $('#comment').val()},
										cache : false,
										async : false,
										dataType : "json",
										success : function(data){
											if(data){
												btn.innerHTML = '推荐完成！';
												alert(data.msg);
												hide();
											}
										}
							  		});
								}else{
									alert('请选择推荐方向!');
								}
						  	})
						}
					}
				})
			}
			show();
			resize();
		}else{
			loginBox();	
		}
	}
})
