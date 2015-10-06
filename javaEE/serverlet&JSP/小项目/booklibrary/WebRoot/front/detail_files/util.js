var messageBoxTemplate = '<div class="POPinfo"><img src="/common/style/pop/{imgName}">' +
'<div class="title">{title}</div><p class="cont">{content}</p><input class="POPbutton" type="button" value="确认"></div>';

/**
 * 泡泡
 */
function Pop(){
	/**
	 * 包体 
	 */
	Pop.prototype.popBody = null;
	
	/**
	 * 显示
	 */
	Pop.prototype.show = function(){
		var maskDiv = null;
		if(this.popBody.isDialog){
			if((maskDiv = document.getElementById('maskDiv')) == null){
				maskDiv = document.createElement("DIV");
				maskDiv.id = 'maskDiv';
				maskDiv.style.top = 0;
				maskDiv.style.left = 0;
				maskDiv.style.width = '100%';
				maskDiv.style.height = (Math.max(document.body.clientHeight,document.body.offsetHeight,document.documentElement.clientHeight)) + 'px';
				maskDiv.style.position = 'absolute';
				maskDiv.style.zIndex = 9050;
				maskDiv.style.backgroundColor = 'black';
				
				if(maskDiv.style.opacity != undefined){
					maskDiv.style.opacity = 0.5;
				}else{
					maskDiv.style.filter = 'alpha(opacity=50)';
				}
				document.body.appendChild(maskDiv);
			}
			maskDiv.style.display = 'none';
		}
		if(maskDiv){
			maskDiv.style.display = 'block';	
		}
		this.popBody.style.display = 'block';
	}
	
	/**
	 * 隐藏
	 * @param {Function} fun 隐藏后执行的方法 可选
	 */
	Pop.prototype.hidden = function(fun){
		this.popBody.style.display = 'none';
		if(this.popBody.isDialog){
			document.getElementById('maskDiv').style.display = 'none';
		}
		if(fun){
			fun();
		}
	}
	
	/**
	 * 保存包体
	 * @param {String} title 标题
	 * @param {Number} height 高
	 * @param {Number} width 宽
	 * @param {Number} top 居上坐标
	 * @param {Number} left 居左坐标
	 * @param {Object} source 元素(可以使html代码.但是要注意 在泡泡失效后. 此元素会被删除)
	 * @param {Boolean} isDialog 是否是弹出层
	 * @param {Function} clsAfterFunc 关闭按钮后执行方法
	 */
	Pop.prototype.setPopBody = function(title , width , height , top , left , source , isDialog , clsAfterFunc){
		var WHarr = [ width , height ];
		var main = document.createElement("DIV");
		var content = main.cloneNode(false);
		content.id = 'content';
		var closeButton = main.cloneNode(false);
		
		var bodyHeight = Math.max(document.documentElement.clientHeight,
				document.body.offsetHeight);
		
		var popTop = top ? top : (WHarr[1] ? (document.documentElement.clientHeight / 2)
				- WHarr[1] / 2 : (document.documentElement.clientHeight / 5)) + document.documentElement.scrollTop;
		
		var popLeft = left ? left : document.documentElement.clientWidth / 2 - (WHarr[0] ? WHarr[0] / 2 : 0);
		
		main.style.cssText = "display:none;position:absolute;z-index:9100;background-color:white;"
				+ (WHarr[0] ? ('width:' + WHarr[0] + 'px;'): '')
				+ (WHarr[1] ? ('height:' + WHarr[1] + 'px;'): '')
				+ "left:" + popLeft + 'px;'
				+ "top:" + popTop + "px;";
		
		main.className = "popupTag";
		if(title){
			main.innerHTML = "<div class='popupTit'>" + title + "</div>";	
		}
//		content.style.cssText = "padding:5px;position:relative;display:block;overflow:auto;width:" +(WHarr[0] - 20) + "px;height:" + (WHarr[1] - 50) + 'px;';
		content.style.cssText = "padding:5px;display:block;width:" + (WHarr[0] ? ('width:' + (WHarr[0] - 20) + 'px;'): '') + (WHarr[1] ? ('height:' + (WHarr[1] - 50) + 'px;overflow:auto;'): '');
		
		this.clear = function() {
			if(isDialog){
				document.getElementById('maskDiv').style.display = 'none';
			}
			main.style.display = 'none';
			document.body.removeChild(main);
		};
		
		closeButton.style.cssText = "position:absolute;top:7px;right:10px;width:27px;height:26px;cursor:pointer";
		closeButton.className = "popupCls";
		closeButton.onclick = function() {
			if(isDialog){
				document.getElementById('maskDiv').style.display = 'none';
			}
			if(clsAfterFunc){
				clsAfterFunc();
			}
			main.style.display = 'none';
			document.body.removeChild(main);
		};
		//closeButton.onclick = this.clear;
		if(typeof source == 'string'){
			content.innerHTML = source;
		}else{
			content.appendChild(source);	
		}
		main.appendChild(closeButton);
		main.appendChild(content);
		if(isDialog){
			main.isDialog = true;	
		}else{
			main.isDialog = false;
		}
//		if(this.popBody){
//			document.body.removeChild(this.popBody);
//		}
		this.popBody = main;
		document.body.appendChild(main);
	}
	
	/**
	 * 清除
	 */
	Pop.prototype.clear = function(func){
		this.hidden();
		document.body.removeChild(this.popBody);
	}
	
}

/**
 * 确认框
 * @param {Object} message
 */

function confirmBox(message , execFunc){
	var pop = new Pop();

	var confirmDiv = document.createElement("DIV");
	confirmDiv.innerHTML = message + '<br />';
	var center = document.createElement("CENTER");
	confirmDiv.appendChild(center);
	var table = document.createElement("TABLE");
	center.appendChild(table);
	var buttonY = document.createElement("INPUT");
	var buttonN = document.createElement("INPUT");
	buttonY.type = 'button';
	buttonN.type = 'button';
	buttonY.value = "确认";
	buttonY.className = 'popupbut'
	buttonN.value = "取消";
	buttonN.className = "popupbut";
	buttonY.onclick = function(){
		if(execFunc){
			execFunc();	
		}
		pop.clear();
	}
	buttonN.onclick = function(){
		pop.clear();
	}
	var row = table.insertRow(-1);
	row.insertCell(-1).appendChild(buttonY);
	row.insertCell(-1).appendChild(buttonN);
	pop.setPopBody('确认框' ,350 , 150 ,null,null,confirmDiv,true);
	pop.show();
}

/**
 * 弹出框
 * @param {Object} message 提示信息
 * @param {Object} type 类型 success:操作成功 failure:失败 error:错误
 * @param {Object} execFunc 点击确认后执行方法
 * @param {Object} isDialog 是否锁屏
 */
function messageBox(message , type , execFunc , isDialog){
	if(window.messageBoxPop){
		try{
			window.messageBoxPop.clear();
		}catch(e){}
	}
	var pop = new Pop();
	window.messageBoxPop = pop;
	
	var title = '';
	var imgName = '';
	
	type = type ? type : 'failure';
	
	if(type == 'success'){
		title = '操作成功';
		imgName = 'ok.jpg';
	}else if(type == 'failure'){
		title = '操作失败';
		imgName = 'error.jpg';
	}else if(type == 'error'){
		title = '出现问题';
		imgName = 'error2.jpg';
	}else{
		title = '出现问题';
		imgName = 'error2.jpg';
	}
	
	var htmlCode = messageBoxTemplate.replaceAll('{content}',message);
	htmlCode = htmlCode.replaceAll('{title}',title).replaceAll('{imgName}',imgName);
	pop.setPopBody(title ,430 , null ,null,null,htmlCode, (isDialog ? true : false));
	var body = pop.popBody;
	var buttons = body.getElementsByTagName('INPUT');
	for(var i = 0 ; i < buttons.length ; i ++){
		if(buttons[i].className == 'POPbutton'){
			buttons[i].onclick = function(){
				if(execFunc){
					execFunc();
				}
				pop.clear();
			};
		}
	}
	pop.show();
}

function loginBox(){
	var htmlCode = '<form id="loginBox_form" ' +
	'action="/sso/logon.jsps?returnUrl=' + escape(window.location.href) + '&visitUrl=' + escape(window.location.href) + '" method="post">' +
	'<table style="font-size: 12px;"  cellspacing="1" style="padding:5px" cellpadding="5" width="350" align="center">' +
	'<tr bgcolor="white"><td align="right" >用户名：</td><td align="left" ><input type="text" id="loginBox_userName" name="userName" style="width: 150px;" maxlength="30"  /></td><td style="color:red;" ></td>' +
	'</tr><tr bgcolor="white"><td align="right">密 码：</td><td align="left"><input type="password" id="loginBox_userPass" name="userPass" style="width: 150px;" maxlength="30" /></td><td style="color:red;" ></td>' +
	'</tr><tr><td></td><td ><input style="vertical-align:middle" type="checkbox" name="local" value="1" />记住我 ｜ <a href="/user/resetPassword.jsps">忘记密码</a></td></tr>' +
	'<tr bgcolor="white"><td></td><td align="left"><input type="submit" value="登录" /></td></tr></table></form>';

	var pop = new Pop();
	
	pop.setPopBody('用户登录',370,null,null ,null,htmlCode,true);
	
	var lbForm = document.getElementById('loginBox_form');
	lbForm.onkeyup = function(e){
		if((window.event ? window.event : e).keyCode == 13){
			lbForm.submit();
		}
	}
	lbForm.onsubmit = function(e){
		var name = document.getElementById('loginBox_userName');
		var pass = document.getElementById('loginBox_userPass');
		if(name.value == ''){
			alert('请填写用户名');
			return false;
		}else if(pass.value == ''){
			alert('请填写密码');
			return false;
		}else{
			return true;	
		}
	}
	pop.show();
}


function getCookieValue(name){
	var cookieArray = document.cookie.split("; ");
	var cookie = new Object();
	for(var i=0;i<cookieArray.length;i++){
		var arr = cookieArray[i].split("=");
		if(arr[0]==name)return decodeURI(arr[1]);
	}
	return null;
}

String.prototype.replaceAll = function(s1,s2) {
    return this.replace(new RegExp(s1,"gm"),s2);
}
