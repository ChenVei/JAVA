<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.ws.DB"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.ws.Article"%>
<%@ page pageEncoding="UTF-8" %>
<%
	int id = -1;
	int rootID = -1;
	try {
		id = Integer.parseInt(request.getParameter("id"));
		rootID = Integer.parseInt(request.getParameter("rootID"));
	}
	catch(NumberFormatException e) {
		out.println("NumberFormatException!! ");
		e.printStackTrace();
		return;
	}
 %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0042)http://bbs.51cto.com/thread-1160254-1.html -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<title>新人的困惑 - Java论坛 -  51CTO技术论坛_中国领先的IT技术社区 </title>
		<meta name="keywords" content="IT论坛">
<meta name="MSSmartTagsPreventParsing" content="True">
<meta http-equiv="MSThemeCompatible" content="Yes">

<style type="text/css">
DIV.jing {
    background: url(images/stamp/jing.png) no-repeat !important;
	filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true, src="images/stamp/jing.png"); background:none;
	shou
    float: left;
    height: 107px;
    position: absolute;
    width: 107px;
    z-index: 10;
    left:1120px;
    top:246px;
}
		
		

<style>
.t_l, .t_c, .t_r, .m_l, .m_r, .b_l, .b_c, .b_r {
    background: none repeat scroll 0 0 #000000;
    opacity: 0.2;
    overflow: hidden;
	filter:alpha(opacity=20);
	-moz-opacity:0.2;
	-khtml-opacity: 0.2;
}

.Postban a{ color:#1470a1;}
.Postban {
    color: #000000;
    line-height: 164px;
    text-align: center;
}
.hftxtarea, .Postban {
    background: none repeat scroll 0 0 #FFFFFF;
    border: 1px solid #DDDDDD;
    height: 164px;
    width: 499px;
}

/*end jacena*/


.ipadFload{ position:fixed; width:136px; height:194px; background:url(http://bbs.51cto.com/images/IPad-bg.png) left top no-repeat #fff; font-family:"微软雅黑"; padding-left:18px;}
.ipadClose{ text-align:right; font-size:14px; line-height:20px;}
.ipadImg{ padding-top:38px;}
.ipadImg img{ width:105px; height:105px;}
.iPadair2{ font-size:12px;}
.iPadair2 a{ color:#659b01; text-decoration:none; background:url(http://bbs.51cto.com/images/51CTO-IPAD-BOTTOM.png) right center no-repeat; display:block; line-height:30px;}

</style>


<div class="clear"></div>
	
		

<%--****表单***************************************************************************************--%>            
<div>
    
    <form action="replyDetail.jsp" method="post">
    	<input type="hidden" name="pid" value="<%=id%>" />
        <input type="hidden" name="rootID" value="<%=rootID%>" />
    Content:
    <textarea name="cont" rows="15" cols="80"></textarea>
    <br />
    <input type="submit" value="提交" />
    </form>
</div>
<%--*******************************************************************************************--%>    
<script>
    jQuery(function() {
        jQuery.ajax({
            type:'post',
            url:'/plugins/index/service.sy.php',
            success: function(msg){
                if(msg == 1 || msg == 2 || msg == 3) {
                    jQuery('#bbs_bz_display').css('display','block');
                } else {
                    jQuery('#bbs_bz_display').css('display','none');
                }
            }
        })
        jQuery('#showTag').bind('click',function() {
            var dis = jQuery('#bbsTag').css('display');
            var jTop = jQuery('.jing').css('top');
            var jian = jQuery('.jian').css('top');
            var edit_shou = jQuery('.edit_shou').css('top');

            if(dis == 'block') {
                jQuery('#bbsTag').slideUp('slow');
                jQuery('#showTag').removeClass('un_flod_btn');
                jQuery('#showTag').addClass('flod_btn');
            } else {
                jQuery('#bbsTag').slideDown('slow');
                jQuery('#showTag').removeClass('flod_btn');
                jQuery('#showTag').addClass('un_flod_btn');
            }
            if(jTop || jian || edit_shou) {
                jTop = parseInt(jTop);
                jian = parseInt(jian);
                edit_shou = parseInt(edit_shou);
                if(jTop == 246) {
                    jQuery('.jing').css('top',416);
                } else {
                    jQuery('.jing').css('top',246);
                }
                if(jian == 346) {
                    jQuery('.jian').css('top',516);
                } else {
                    jQuery('.jian').css('top',346);
                }
                if(edit_shou == 346) {
                    jQuery('.edit_shou').css('top',516);
                } else {
                    jQuery('.edit_shou').css('top',346);
                }
            }
        });
    })
</script>
<div class="clear hr10"></div>
		
		
		

	
	
<div class="hr10"></div>
		<div class="w960"></div>
		<div class="clear hr10"></div><a name="hf">
		<div class="clear"></div>
<!-- taobaoke --><!-- taobaoke -->

<style>

#smiliesdiv table td {
    line-height: 30px;
    width: 30px;
}

.medalsbox{ line-height:0; font-size:0;}

.signatures {
    background: url("../../images/default/sigline.gif") no-repeat scroll 0 0 transparent;
    color: #666666;
    line-height: 1.6em;
    margin: 10px;
    overflow: hidden;
    padding-top: 20px;
	text-align:left;
}
.signatures * {
    line-height: normal;
}
.signatures strong {
    font-weight: bold;
}

.signatures { height: expression(signature(this)); max-height: 100px; }

#smiliesdiv {
	margin-top:64px;

}




//



.t_l, .t_r, .b_l, .b_r {
    height: 8px;
    width: 8px;
}
.t_c, .b_c {
    height: 8px;
}
.m_l, .m_r {
    width: 8px;
}
.t_l {
    border-radius: 8px 0 0 0;
}
.t_r {
    border-radius: 0 8px 0 0;
}
.b_l {
    border-radius: 0 0 0 8px;
}
.b_r {
    border-radius: 0 0 8px 0;
}
.m_c {
    background: none repeat scroll 0 0 #FFFFFF;
}
.m_c .tb {
    margin: 0 0 10px;
    padding: 0 10px;
}
.m_c .c {
    padding: 0 10px 10px;
}
.m_c .o {
    background: none repeat scroll 0 0 #F2F2F2;
    border-top: 1px solid #CCCCCC;
    height: 26px;
    padding: 8px 10px;
    text-align: right;
}
.m_c .el {
    width: 420px;
}
.m_c .el li {
    border: medium none;
    padding: 0;
}

</style>	
		

		
		</a><div class="foot"><br>
Copyright©2005-2014</div>


	<script src="./img2/forum.inc.php" type="text/javascript"></script>
			<script src="./img2/count.js"></script><script src="./img2/count.php"></script>
</body></html>