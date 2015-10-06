function init(){
	$.ajax( {
		url : '/book/getBookUserInfo.jsps',
		data : {'bookId' : $('#bookId').val()},
		cache : false,
		async : false,
		dataType : "json",
		success : function(r) {
			if(r && r.success){
				var d = r.data
				if(d.isCollection){
					$('#sCollectionBook').removeAttr('style');
				}else{
					$('#collectionBook').removeAttr('style');
				}
				//if(d.isRecommend){
					//$('#recommend').html('推荐到小组');
					//$('#recommend').html('已推荐');
					//$('#recommend').removeAttr('onclick');
				//}
				$('#recommend').removeAttr('style');
				if(d.lastBorrowCount <= 0){
					$('#borrow').attr('title' , '副本数不足无法借阅');
					$('#borrow').css('color' , 'gray');
					$('#borrow').removeAttr('target');
					$('#borrow').removeAttr('href');
				}
				$('#lastBorrowCount').html(d.lastBorrowCount);
				$('#readNum').html(d.readNum);
				$('#collectionCount').html(d.collectionCount);
				$('#recommendCount').html(d.recommendCount);
				$('#myScore').val(d.userToBookScore);
				
				var s = d.scoreStatistics
				$('#stars').val(s.scoreCount);
				var rc = s.ratingCount;
				$('#stars1').val(rc[1]);
				$('#stars2').val(rc[2]);
				$('#stars3').val(rc[3]);
				$('#stars4').val(rc[4]);
				$('#stars5').val(rc[5]);
				$('#avgRating').val(s.avgScore);
				if(d.browseBook && d.browseBook.length > 0){	
					$('#browseBooks').html('');
					var t = '<li><a href="/book/bookIndex.jsps?bookId={id}" target="_blank"><img onerror="javascript:this.src=\'http://img.chineseall.cn/bookpic/default.jpg\'" title="{tName}" src="{pic}" /></a><a title="{tName}" href="/book/bookIndex.jsps?bookId={id}" target="_blank">{name}</a></li>'
					var h = '';
					var l = '';
					var books = d.browseBook;
					var b ;
					for(var i = 0 ; i < books.length ; i ++){
						b = books[i];
						l = t.replaceAll('{id}' , b.id);
						l = l.replaceAll('{pic}' , b.picPathAddress);
						l = l.replaceAll('{tName}' , b.name);
						l = l.replaceAll('{name}' , b.name.length > 8 ? (b.name.substring(0 , 8) + '..') : b.name);
						h = h + l
					}
					$('#browseBooksDiv').css('display' , 'block');
					$('#browseBooks').html(h);
				}
				//tagTitle
				
				if(d.tags && d.tags.length > 0){
					var tags = d.tags;
					$('#userTags').html('');
					var h = '';
					for(var i = 0 ; i < tags.length ; i ++){
						h = h + '<span>' + tags[i] + '</span>&nbsp;';
					}
					$('#userTags').html(h);
					if(getCookieValue('chineseall.login')){
						$('#tagTitle').html('我的标签:');
						$('#updateTag').html('修改');
					}else{
						$('#updateTag').html('添加标签');
					}
				}else{
					if(getCookieValue('chineseall.login')){
						$('#userTags').html('您还没有设置标签');
					}else{
						$('#userTags').html('没有人给此书打标签');
					}
					$('#updateTag').html('添加标签');
				}
			}
		}
	}); 
	
	if($('#topTitle').html().length > 14){
		$('#topTitle').attr("title" , $('#topTitle').html());
		$('#topTitle').html($('#topTitle').html().substring(0 , 13) + '..')
	}
	$('#topTitle').css("display" , "block");
	s = $('a[name="uDName"]');
	if(s){
		for(var i = 0 ; i < s.length ; i ++){
			if($(s[i]).html().length > 5){
				$(s[i]).attr("title" , $(s[i]).html());
				$(s[i]).html($(s[i]).html().substring(0 , 5) + '..')
			}
		}
	}
	s = $('a[name="oBName"]');
	if(s){
		for(var i = 0 ; i < s.length ; i ++){
			if($(s[i]).html().length > 10){
				$(s[i]).attr("title" , $(s[i]).html());
				$(s[i]).html($(s[i]).html().substring(0 , 9) + '..')
			}
		}
	}
}


var commentTemplate = '<dl><dt><a href="{userAddress}" target="_blank">' +
'<img src="{userHeadImg}" onerror="javascript:this.src=\'http://img.chineseall.cn/userHeadImg/moren/default.jpg\'" alt="{userDisplayName}"></a></dt><dd><div class="dgBook_dd_t">' +
'<span class="name"><a href="{userAddress}" target="_blank">{userDisplayName}</a></span><span class="time">&nbsp;{submitTime}&nbsp;</span>' +
'<span class="page">评论页数：第<b>{page}</b>页</span></div><div class="dgBook_dd_c">{content}</div>' +
'<div class="dgBook_dd_b"><span><a class="a1" href="javascript:ifUsefulComment({commentId},1);">' +
'（<label id="useful_{commentId}">{useful}</label>）</a>|<a class="a2" href="javascript:ifUsefulComment({commentId},0);">' +
'（<label id="useless_{commentId}">{useless}</label>）</a></span></div></dd></dl>';

var recommendTemplate = '<form id="formDiv" class="contboxUppop"><div class="right">推荐给：<br><input type="checkbox" value="0" name="recommendType">' +
'我的书友<br><input type="checkbox" value="1" name="recommendType">推荐机构购买</div><div class="left"><input id="bookId" type="hidden" value="{id}">' +
'<a class="img" href="/book/bookIndex.jsps?bookId={id}" target="_blank"><img alt="{tName}" style="display: block;height: 113px;margin: 0 auto; padding: 3px;width: 80px;" src="http://img.chineseall.cn/{bookPic}" ' +
' onerror="javascript:this.src=\'http://img.chineseall.cn/bookpic/default.jpg\'"></a><a class="tit" title="{tName}" href="/book/bookIndex.jsps?bookId={id}" target="_blank">{name} </a>' +
'<br><font color="gray">作者:</font><span title="tAuthor">{author}</span><br><font color="gray">出版社:</font><span title="{tPublisher}">{publisher}</span>' +
'<br></div><div class="input">写几句:<textarea id="recommendContent"></textarea><input id="submitButton" type="button" value="确认"></div></form>'


function toPage(page){

	var comments = getCommentList($("#bookId").val() , page , $("#bookCommentOrder").val() , $("#bookCommentScope").val());
	
	var list = comments.list;
	var count = comments.count;
	var pageSize = comments.pageSize;

	if(list){
		$("#bookCommentsDiv").html('');
		if(list.length == 0){
			$("#bookCommentsDiv").html('<dd>还没有人对此书进行评论……</dd>');
			$("#pagination").html('');
		}else{
			$("#pagination").pagination(count, {
				items_per_page:pageSize,
				current_page: page,
				prev_text:'上一页',
				next_text:'下一页' ,
				callback : toPage ,
				num_edge_entries : 1,
				num_display_entries : 5,
				link_to : 'javascript:void(0)'
			});
			for(var i = 0 ; i < list.length ; i ++){
				writeComment(list[i]);
			}
		}
	}else{
		$("#bookCommentsDiv").html('<dd>获取书评失败……</dd>')
		$("#pagination").html('');
	}
	
}
function getCommentList(bookId , currentPage , order , scope){
	var params = {'bookId' : bookId , 'currentPage' : currentPage , 'order' : order , 'scope' : scope};
	var returnValue = false;
	$.ajax( {
		url : '/book/getCommentList.jsps',
		data : params,
		cache : false,
		async : false,
		dataType : "json",
		success : function(data) {
			if(data.success){
				returnValue = data.data;
			}
		}
	});
	return returnValue;
}

function addComment(bookId , content , page , afterExecFunc){
	if(getCookieValue('chineseall.login') != null){
		if(!bookId){
			messageBox('请选择图书后进行评价' , 'failure' , false , true);
		}else if(!content || $.trim(content).length == 0){
			messageBox('请填写评论内容' , 'failure');
		}else if($.trim(content).length > 1000 && $.trim(content).length >= 10){
			messageBox('评论内容请保持在1000字以内' , 'failure' , false , true);
		}else if(window.pcontent && window.pcontent == $.trim(content)){
			messageBox('请不要提交重复内容评论' , 'failure' , false , true);
		}else{
			page = page ? page : 0;
			var params = {'bookId' : bookId , 'content' : content , 'page' : page};
			$.ajax( {
				url : '/book/addComment.jsps',
				data : params,
				cache : false,
				async : false,
				dataType : "json",
				success : function(data) {
					if(data.success){
						messageBox(data.msg  , 'success' , function(){
							toPage(0);
						} , true);
						window.pcontent = $.trim(content);
					}else{
						messageBox(data.msg, 'failure' , false , true);
					}
				}
			});
		}
	}else{
		loginBox();
	}
}

function writeComment(comment){
	if ($("#bookCommentsDiv").html() == "<dd>还没有人对此书进行评论……</dd>") {
		$("#bookCommentsDiv").html("");
	}
	if($("#bookCommentsDiv dl").length >= 20){
	   $("#bookCommentsDiv dl").last().remove();
	}
	
	if(comment.content.length > 30){
		comment.content = '<p>' + comment.content.substring(0 , 30) + '……&nbsp;<a onclick="contract(this.parentNode.parentNode , \'open\')" style="cursor: pointer;" >[展开]</a></p>'
		+ '<p style="display:none;" >' + comment.content + '&nbsp;<a onclick="contract(this.parentNode.parentNode , \'hidden\')" style="cursor: pointer;" >[收回]</a></p>';
	}
	
	var commentBody = commentTemplate.replaceAll('{content}',comment.content);
	commentBody = commentBody.replaceAll('{userAddress}',('/user/userIndex.jsps?userId=' + comment.submiterId));
	commentBody = commentBody.replaceAll('{userHeadImg}',comment.submiterHeadIcon);
	commentBody = commentBody.replaceAll('{userDisplayName}',comment.submiterName);
	commentBody = commentBody.replaceAll('{submitTime}',new Date(comment.submitTime.time).format('yyyy-MM-dd hh:mm'));
	commentBody = commentBody.replaceAll('{commentId}',comment.id);
	commentBody = commentBody.replaceAll('{page}',comment.page);
	commentBody = commentBody.replaceAll('{useful}',comment.usefulCount);
	commentBody = commentBody.replaceAll('{useless}',comment.uselessCount);
	
	$("#bookCommentsDiv").html(
			$("#bookCommentsDiv").html()
					+ commentBody);
}

function contract(node , type){
  	if(type == 'open'){
  		node.getElementsByTagName('P')[0].style.display = 'none';
  		node.getElementsByTagName('P')[1].style.display = 'block';
  	}else{
  		node.getElementsByTagName('P')[0].style.display = 'block';
  		node.getElementsByTagName('P')[1].style.display = 'none';
  	}
}

function ifUsefulComment(id , ifUseful){
	var params = {'commentId' : id , 'ifUseful' : ifUseful};
	$.ajax( {
		url : '/book/ifUsefulComment.jsps',
		data : params,
		cache : false,
		async : false,
		dataType : "json",
		success : function(data) {
			if(data.success){
				if(ifUseful == 1){
					$('#useful_' + id).html(Number($.trim($('#useful_' + id).html())) + 1);
					if(data.data == 'update'){
						$('#useless_' + id).html(Number($.trim($('#useless_' + id).html())) - 1);
					}
				}else{
					$('#useless_' + id).html(Number($.trim($('#useless_' + id).html())) + 1);
					if(data.data == 'update'){
						$('#useful_' + id).html(Number($.trim($('#useful_' + id).html())) - 1);
					}
				}
				messageBox(data.msg,'success');
			}else{
				messageBox(data.msg,'failure');
			}
		}
	});
}

function recommendBookPop(bookId , bookName, author, publisher, bookImg){
	if(getCookieValue('chineseall.login')){
		var pop = new Pop();
		var body = recommendTemplate.replaceAll('{id}',bookId);
		body = body.replaceAll('{tName}',(bookName.length > 5 ? bookName.substring(0 , 5) + '..' : bookName));
		body = body.replaceAll('{name}',bookName);
		body = body.replaceAll('{tAuthor}',(author.length > 5 ? author.substring(0 , 5) + '..' : author));
		body = body.replaceAll('{author}',author);
		body = body.replaceAll('{tPublisher}',(publisher.length > 5 ? publisher.substring(0 , 5) + '..' : publisher));
		body = body.replaceAll('{publisher}',publisher);
		body = body.replaceAll('{bookPic}',bookImg);
		
		pop.setPopBody('推荐图书',400,250,null,null,body,true);
		pop.show();
		document.getElementById('submitButton').onclick = function(){
			var arrays = document.getElementsByName('recommendType');
			var recommendType = '';
			for(var i = 0 ; i < arrays.length ; i ++){
				if(arrays[i].checked){
					recommendType += arrays[i].value + ';';
				}
			}
			if(recommendType == ''){
				messageBox('请选择推荐目标!','failure');
			}else if(document.getElementById('recommendContent').value.length > 100){
				messageBox('荐语内容过长！请保持在100字以内!','failure');
			}else{
				recomendBook(document.getElementById('bookId').value , 
				document.getElementById('recommendContent').value , recommendType,
				function(data){
					if(data){
						messageBox(data.msg , (data.success ? 'success' : 'failure') , function(){
							pop.clear();
							if(data.success){
								window.location = window.location; 
							}
						});
					}else{
						messageBox(message,'failure' , function(){
							pop.clear();
						});
					}
				});
			}
		}
	}else{
		loginBox();
	}
}

String.prototype.replaceAll = function(s1,s2) {
    return this.replace(new RegExp(s1,"gm"),s2);
}
Date.prototype.format = function (format) {
	var o = {
		"M+": this.getMonth() + 1, //month
		"d+": this.getDate(), //day
		"h+": this.getHours(), //hour
		"m+": this.getMinutes(), //minute
		"s+": this.getSeconds(), //second
		"q+": Math.floor((this.getMonth() + 3) / 3), //quarter
		"S": this.getMilliseconds() //millisecond
		}     
		if (/(y+)/.test(format)) format = format.replace(RegExp.$1,(this.getFullYear() + "").substr(4 - RegExp.$1.length));
		for (var k in o) if (new RegExp("(" + k + ")").test(format))format = format.replace(RegExp.$1,RegExp.$1.length == 1 ? o[k] :("00" + o[k]).substr(("" + o[k]).length));
		return format; 
}