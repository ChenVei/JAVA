			//选项卡功能
			var tabTits = getClassTag('div','tabTitTag'),tabtemp,tabtimetemp;
			for(var i=0,tabs; tabs=tabTits[i++];){
				tabtemp = tabs.getElementsByTagName('a');
				for(var j=0,taba;taba=tabtemp[j++];){
					taba.rel = j;
					taba.onmouseover = tabSkipTime;
					taba.onmouseout = function(){clearTimeout(tabtimetemp);}
				}
			}

			function tabSkipTime(){
				clearTimeout(tabtimetemp);
				var a=this
				tabtimetemp = setTimeout(function(){tabToggle(a)},300);
			}
			function tabToggle(my){
				var thisboxtag = my.parentNode.parentNode.parentNode.getElementsByTagName('dd')[0];
				var thisboxs = getClassTag('div','tabbox',thisboxtag);
				for(var i=0,box;box=thisboxs[i++];){
					box.style.display = "none";
					if(i==my.rel) box.style.display = "block";
				}
				var thistittags = my.parentNode.getElementsByTagName('a');
				for(var i=0,tits;tits=thistittags[i++];){
					tits.className = "";
					if(i==my.rel) tits.className = "hot";
				}
			}

