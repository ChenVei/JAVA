//我的书房菜单
var suborg = document.getElementById('suborg'),suborgtag = document.getElementById('suborgtag'),suborgtemp;
if(suborg){
suborg.onmouseover = function(){
	this.style.cssText = 'color:red;font-weight:bold';
	suborgtag.style.display = 'block';
	suborgtag.style.height = (suborgtag.getElementsByTagName('div')[1].clientHeight + 20) + 'px';
	clearTimeout(suborgtemp);
}
suborg.onmouseout = suborgout;
suborgtag.onmouseout = suborgout;
suborgtag.onclick = suborgout;
suborgtag.onmousemove = function(){
	this.style.display="block";
	clearTimeout(suborgtemp);
	suborg.style.cssText = 'color:red;font-weight:bold';
}
}
function suborgout(){
	suborgtemp = setTimeout(function(){
		suborgtag.style.display = 'none';
		suborg.style.cssText = '';
	},600);
}
//我的书房菜单
var myroom = document.getElementById('myroom'),myroomtag = document.getElementById('myroomtag'),myroomtemp;
if(myroom){
myroom.onmouseover = function(){
	this.style.cssText = 'color:red;font-weight:bold';
	myroomtag.style.display = 'block';
	myroomtag.style.height = (myroomtag.getElementsByTagName('div')[1].clientHeight + 20) + 'px';
	clearTimeout(myroomtemp);
}
myroom.onmouseout = myroomout;
myroomtag.onmouseout = myroomout;
myroomtag.onclick = myroomout;
myroomtag.onmousemove = function(){
	this.style.display="block";
	clearTimeout(myroomtemp);
	myroom.style.cssText = 'color:red;font-weight:bold';
}
}
function myroomout(){
	myroomtemp = setTimeout(function(){
		myroomtag.style.display = 'none';
		myroom.style.cssText = '';
	},600);
}
//城市切换
var citybut = document.getElementById('city'),citytag = document.getElementById('citytag'),citytemp;
if(citybut){
	citybut.onclick = showcity;
	citytag.onmousemove = showcity;
	citybut.onmouseout = function(){
		citytemp = setTimeout(function(){citytag.style.display = 'none';},600);
	}
}
function showcity(){
	citytag.style.display = 'block';
	clearTimeout(citytemp);
}
//导航小坚线处理
var nav = document.getElementById('index_nav');
if(nav){
	var navdd = nav.getElementsByTagName('dd');
	for(var i=0;i<navdd.length;i++)
		if(navdd[i].className) navdd[i+1].style.background = 'none';
}

//公用方法
function getClassTag(tag,classname,dom){
	var DOM = dom||document;
	var Tags = DOM.getElementsByTagName(tag);
	var tagArr = [];
	for(var i=0; i<Tags.length; i++){
		if(Tags[i].className.indexOf(classname)!=-1)
		tagArr.push(Tags[i]);
	}
	return tagArr;
}

function selectCheckbox(Name,Mod){
	var check = document.getElementsByName(Name);
	if(check.length == 0) alert('No select!')
	if(Mod == 'all')
		for(var i=0,j;j=check[i++];){j.checked = true;}
	if(Mod == 'Inverse')
		for(var i=0,j;j=check[i++];){j.checked = !j.checked;}
	if(Mod == 'unselect')
		for(var i=0,j;j=check[i++];){j.checked = false;}
	if(typeof Mod == 'object')
		for(var i=0,j;j=check[i++];){j.checked = Mod.checked;}
	return false;
}

function AjaxXML(file,fun){
	var xmlObj = window.ActiveXObject?new ActiveXObject("Microsoft.XMLHTTP"):new XMLHttpRequest();
	xmlObj.onreadystatechange = function(){
		if(xmlObj.readyState == 4){fun(xmlObj.responseXML);}
	}
	xmlObj.open ('GET', file, true);
	xmlObj.send ('');
}

function setURL(url,dat,fun){
	var xmlObj = window.ActiveXObject?new ActiveXObject("Microsoft.XMLHTTP"):new XMLHttpRequest();
	var datas = dat||null;
	xmlObj.onreadystatechange = function(){
		if(xmlObj.readyState == 4){if(fun){fun(responseText)}}
	}
	xmlObj.open ('POST', url, true);
	xmlObj.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xmlObj.send (datas);
}

//帐户设置按钮菜单
function showUserSetMenu(idName,Type){
	var tag = document.getElementById(idName)
	if(Type) tag.style.display = 'block';
	else tag.style.display = 'none';
}