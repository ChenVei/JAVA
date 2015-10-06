function getCookieValue(name){
	var cookieArray = document.cookie.split("; ");
	var cookie = new Object();
	for(var i=0;i<cookieArray.length;i++){
		var arr = cookieArray[i].split("=");
		if(arr[0]==name)return decodeURI(arr[1]);
	}
	return null;
}
/**
 * 抽取公用推荐图书方法 recomendBook
 * 
 * @param bookId
 *            图书ID
 * @param recommendComment
 *            推荐理由
 * @param recommendTypes
 *            推荐类型（关注我的人为：0，我关注的人为：1 如果两者都选中 组成字符串0;1）
 * @param afterFunc
 *            返回后执行的方法
 */
function recomendBook(bookId, recommendComment, recommendTypes, afterFunc) {
	if(getCookieValue('chineseall.login') != null ){
		var params = {
			"bookId" : bookId,
			"recommendComment" : recommendComment,
			"recommendToFriends" : (recommendTypes.indexOf('0') > -1 ? 1 : 0),
			"recommendToMyOrg" : (recommendTypes.indexOf('1') > -1 ? 1 : 0)
		};
		$.ajax({
			url : "/book/recommendBook.jsps",
			data : params,
			cache : false,
			async : false,
			dataType : "json",
			success : function(data) {
				if (afterFunc) {
					afterFunc(data);
				}
			}
		});
	}else{
		loginBox();
	}
}

/**
 * 用户打分评价方法
 * 
 * @param bookId
 *            图书ID
 * @param score
 *            评分
 * @param afterFunc
 *            返回后执行的方法
 */
function ratingBook(bookId, score, afterFunc) {
	if(getCookieValue('chineseall.login') != null ){
		var params = {
			"score" : score,
			"bookId" : bookId
		};
		$.ajax({
			url : "/book/scoring.jsps",
			data : params,
			cache : false,
			async : false,
			dataType : "json",
			success : function(data) {
				if (afterFunc) {
					afterFunc(data);
				}
			}
		});
	}else{
		loginBox();
	}
}

/**
 * 获取用户对图书分值
 * @param {Object} bookId 图书id 非空
 * @param {Object} userId 用户id 选
 */
function getUserToBookScore(bookId , userId){
	var params;
	if(userId){
		params = {"bookId" : bookId , "userId" : userId}	
	}else{
		params = {"bookId" : bookId}
	}
	var returnValue;
	$.ajax({
		url : "/book/getUserToBookScore.jsps",
		data : params,
		async : false,
		cache : false,
		dataType : "json",
		success : function(data) {
			if(data && data.success){
				returnValue = data.data;
			}else{
				//messageBox(data.msg);
				returnValue = null;
			}
		}
	});
	return returnValue;
}

/**
 * 获取书的书评数
 * @param {Object} bookId 书id
 * @param {Object} userId 用户id 选
 * @return {Integer} 
 */
function getBookCommentCount(bookId , userId){
	var params;
	if(userId){
		params = {"bookId" : bookId , "userId" : userId}	
	}else{
		params = {"bookId" : bookId}
	}
	var returnValue;
	$.ajax({
		url : "/book/getBookCommentCount.jsps",
		data : params,
		cache : false,
		async : false,
		dataType : "json",
		success : function(data) {
			if(data && data.success){
				returnValue = data.data;
			}else{
				returnValue = null;
			}
		}
	});
	return returnValue;
}

/**
 * 获取图书标签列表
 * @param {Object} bookId
 * @param {Object} userId
 * @return {TypeName} 
 */
function getUserToBookTags(bookId , userId){
	var returnValue = false;
	if(bookId){
		var param;
		if(userId){
			param = {"bookId" : bookId , "userId" : userId};
		}else{
			param = {"bookId" : bookId};
		}
		$.ajax({
			url : "/book/getUserToBookTags.jsps",
			data : param,
			cache : false,
			async : false,
			dataType : "json",
			success : function(data) {
				if(data && data.success){
					returnValue = data.data;
				}else{
					returnValue = null;
				}
			}
		});
	}
	return returnValue;
}
function getBookTags(bookId , size){
	var returnValue = null;
	if(bookId){
		params = {"bookId" : bookId};
		if(size){
			params.size = size;
		}
		$.ajax({
			url : "/book/getBookTags.jsps",
			data : params,
			cache : false,
			async : false,
			dataType : "json",
			success : function(data) {
				if(data && data.success){
					returnValue = data.data;
				}else{
					returnValue = null;
				}
			}
		});
	}	
	return returnValue;
}
function getUserTags(userId){
	var returnValue = null;
	var param;
	if(userId){
		param = {"userId" : userId};
	}else{
		param = {};
	}
	$.ajax({
		url : "/book/getUserTags.jsps",
		data : param,
		cache : false,
		async : false,
		dataType : "json",
		success : function(data) {
			if(data && data.success){
				returnValue = data.data;
			}else{
				returnValue = null;
			}
		}
	});
	return returnValue;
}
/**
 * 修改图书标签方法
 * @param {Number} bookId 图书id
 * @param {Object} userId	用户id
 * @param {Object} afterFun	返回方法
 */
function editBookTag(bookName , bookId , userId , afterFun){
	if(bookId){
		var htmlCode = '<div id="labelbox" style="width:450px;" class="labelbox">' +
		'<span style="font-size:14px">给 <font class="red">' + bookName + '</font> 打标签</span>' +
		'<table cellpadding="5" cellspacing="5" >' +
		'<tr><th width="100" >标签</th><td><input id="tags" name="tags" size="45" value="[tags]" /></td></tr>' +
		'<tr><th width="100">我的标签</th><td><div class="labels">[userTags]</div></td></tr>' +
		'<tr><th width="100">本书常用标签</th><td><div class="labels">[bookTags]</td></tr>' +
		'<tr><th colspan="2" ><button type="button" style="float:left;cursor: pointer;margin-right: 10px;" class="popupbut" >确认</button>' +
		'<button type="button" style="float:left;cursor: pointer;" class="popupbut" >取消</button></th></tr>' +
		'</table></div>';
		
		var tags = getUserToBookTags(bookId , userId);
		var value = '';
		if(tags){
			for(var i = 0 ; i < tags.length ; i ++){
				value += tags[i].tag + ' '
			}
		}
		htmlCode = htmlCode.replace('[tags]',value);
		var bookTags = getBookTags(bookId);
		value = '';
		if(bookTags && bookTags.length > 0){
			for(var i = 0 ; i < bookTags.length ; i ++){
				value += '<span style="cursor: pointer;" >' + bookTags[i].tag + '</span>';
			}
		}else{
			value = '这本书还没有标签';
		}
		htmlCode = htmlCode.replace('[bookTags]',value);
		var userTags = getUserTags(userId);
		value = '';
		if(userTags && userTags.length > 0){
			for(var i = 0 ; i < userTags.length ; i ++){
				value += '<span style="cursor: pointer;">' + userTags[i].tag + '</span>';
			}
		}else{
			value = '您还没有设置过标签';
		}
		htmlCode = htmlCode.replace('[userTags]',value);
		var pop = new Pop();
		pop.setPopBody('设置标签' , 450 , null , null , null , htmlCode , true);
		var tags = document.getElementById('tags');
		var spans = pop.popBody.getElementsByTagName('SPAN');
		tags.onkeyup = function(){
			var values = this.value.split(" ");
			for(var i = 0 ; i < spans.length ; i ++ ){
				spans[i].className = '';
				for(var x = 0 ; x < values.length ; x ++){
					if(values[x] == spans[i].innerHTML){
						spans[i].className = 'hot';
						break;
					}
				}
			}
		}
		tags.onkeyup();
		for(var i = 0 ; i < spans.length ; i ++){
			spans[i].onclick = function(){
				if(this.className != 'hot'){
					tags.value += ' ' + this.innerHTML;
				}else{
					tags.value = tags.value.replace(this.innerHTML , '');
				}
				var values = tags.value.split(' ');
				tags.value = '';
				for(var i = 0 ; i < values.length ; i ++){
					tags.value += values[i] != '' ? values[i] + ' ' : '';
				}
				tags.value = tags.value.replace(/(^\s*)|(\s*$)/g, "");
				tags.onkeyup();
			}
		}
		pop.popBody.getElementsByTagName("BUTTON")[0].onclick = function(){
			var tagsArray = tags.value.split(" ");
			if(tagsArray && tagsArray.length > 0){
				if(tagsArray && tagsArray.length > 10){
					messageBox('对一本书设置标签不能超过十个')
				}else{
					for(var i = 0 ; i < tagsArray.length ; i ++){
						if(tagsArray[i].length > 10){
							messageBox('标签限制10个字')
							return ;
						}
					}
					var params = {"bookId" : bookId , "tags" : tags.value}
					$.ajax({
						url : "/book/editBookTag.jsps",
						data : params,
						cache : false,
						async : false,
						dataType : "json",
						success : function(data) {
							pop.clear();
							if(afterFun){
								afterFun(data);
							}
						}
					});
				}
			}else{
				messageBox('请填写标签')
			}
		}
		pop.popBody.getElementsByTagName("BUTTON")[1].onclick = function(){
			pop.clear();
		}
		pop.show();
	}
}

/**
 * 获取图书的章
 * @param {Object} bookId 图书id
 * @return 章列表
 */
function getTxtBookChapterList(bookId){
	var params = {
		"bookId" : bookId
	};
	var returnValue;
	$.ajax({
		url : "/book/getTxtBookChapterList.action",
		data : params,
		cache : false,
		async : false,
		dataType : "json",
		success : function(data) {
			if(data && data.success){
				returnValue = data.data;
			}else{
				returnValue = null;
			}
		}
	});
	return returnValue;
}

/**
 * 获取图书的节
 * @param {Object} chapterId 章id
 * @return {TypeName} 节列表
 */
function getTxtBookSectionList(bookId , chapterId){
	var params = {
		"chapterId" : chapterId ,
		"bookId" : bookId
	};
	var returnValue;
	$.ajax({
		url : "/book/getTxtBookSectionList.action",
		data : params,
		cache : false,
		async : false,
		dataType : "json",
		success : function(data) {
			if(data && data.success){
				returnValue = data.data;
			}else{
				returnValue = null;
			}
		}
	});
	return returnValue;
}

/**
* 用户收藏图书方法
* @param bookId 图书ID
* @param afterFunc 返回后执行的方法
*/
function collectionBook(bookId, afterFunc) {
	if(getCookieValue('chineseall.login') != null ){
		if(bookId){
			var param; 
			if(bookId.length){
				var bookIds = '?bookIds=' + bookId[0];
				for(var i = 1 ; i < bookId.length ; i ++){
					bookIds += '&bookIds=' + bookId[i];
				}
				param = bookIds;
			}else{
				param = '?bookIds=' + bookId;
			}
			$.ajax({
				url : "/book/collectionBook.jsps" + param,
				cache : false,
				async : false,
				dataType : "json",
				success : function(data) {
					if (afterFunc) {
						afterFunc(data);
					}
				}
			});
		}else{
			messageBox('请选择您要收藏的图书' , 'failure');
		}
	}else{
		loginBox();
	}
} 

/**
 * 用户删除收藏图书方法
 * @param bookId 图书ID
 * @param afterFunc 返回后执行的方法
 */
function deleteCollectionBook(bookId, afterFunc) {
	if(getCookieValue('chineseall.login') != null ){
		confirmBox("确认删除这条记录?",function(){
			var params = {
				"bookId" : bookId
			};
			$.ajax({
				url : "/book/deleteCollectionBook.jsps",
				data : params,
				cache : false,
				async : false,
				dataType : "json",
				success : function(data) {
					if (afterFunc) {
						afterFunc(data);
					}
				}
			});
		})
	}else{
		loginBox();
	}
}

/**
 * 获取用户对某书阅读进度对象
 * @param {Object} userId 用户id
 * @param {Object} bookId 图书id
 * @return {TypeName} {readSchedule : 阅读进度百分比 , startReadTime : 开始阅读时间 , endReadTime : 结束阅读时间 , readPageCount : 阅读页数}
 */
function getUserReadBookDetail(userId , bookId){
	var returnValue = null;
	if(userId && bookId){
		var params = { "userId" : userId , "bookId" : bookId };
		$.ajax({
			url : "/book/getUserReadBookDetail.jsps",
			data : params,
			cache : false,
			async : false,
			dataType : "json",
			success : function(data) {
				if(data && data.success ){
					returnValue = data.data;	
				}
			}
		});
	}
	return returnValue;
}
