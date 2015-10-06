/**
 * 星级评分
 * 
 * @author 杨磊
 * @version 1
 */
$(function() {
	// 点击星图标 进行评分
	$("#domark small")
			.click(
					function() {
						var v = $(this).text();
						var bookId = $("#bookId").val();
						$("input[name='mark']").val(v);
						$(this).parent().attr("v", v);
						$(this).parent().attr("class", "star_" + v);

						var score = parseInt(v);
						var params = {
							"score" : score,
							"bookId" : bookId
						};
						$
								.ajax({
									url : "/book/scoring.jsps",
									data : params,
									cache : false,
									dataType : "json",
									success : function(data) {
										if (data.success == false) {
											alert(data.msg);
										} else {
											alert(data.msg);
											// 页面加载时初始化星级评分图
											var avg = data.data.avgScore;
											var count = data.data.scoreCount;
											var avgInt = Math.round(avg);

											$("#commonRaty div").attr("class",
													"star_" + avgInt);
											$("#big2").html(avgInt);

											var ratingCount = data.data.ratingCount;
											for(var i = 0 ; i < ratingCount.length ; i ++){
												if(ratingCount[i] == null){
													ratingCount[i] = 0;
												}
											}

											data[0] = (ratingCount[5] * 100 / count)
													.toFixed(2);
											data[1] = (ratingCount[4] * 100 / count)
													.toFixed(2);
											data[2] = (ratingCount[3] * 100 / count)
													.toFixed(2);
											data[3] = (ratingCount[2] * 100 / count)
													.toFixed(2);
											data[4] = (ratingCount[1] * 100 / count)
													.toFixed(2);
											var ratyBody = "";
											ratyBody = ratyBody
													+ "<dd><img src=\"/common/style/agency/star/5a.gif\" /><span style=\"width:"
													+ data[0]
													+ "px;\"></span><em>"
													+ ratingCount[5]
													+ "</em></dd><dd><img src=\"/common/style/agency/star/4a.gif\" /><span style=\"width:"
													+ data[1]
													+ "px;\"></span><em>"
													+ ratingCount[4]
													+ "</em></dd><dd><img src=\"/common/style/agency/star/3a.gif\" /><span style=\"width:"
													+ data[2]
													+ "px;\"></span><em>"
													+ ratingCount[3]
													+ "</em></dd><dd><img src=\"/common/style/agency/star/2a.gif\" /><span style=\"width:"
													+ data[3]
													+ "px;\"></span><em>"
													+ ratingCount[2]
													+ "</em></dd><dd><img src=\"/common/style/agency/star/1a.gif\" /><span style=\"width:"
													+ data[4]
													+ "px;\"></span><em>"
													+ ratingCount[1]
													+ "</em></dd>";

											$("#ratyPhoto").html(ratyBody);

										}
									}
								});
					});

	// 鼠标经过时
	$("#domark small").hover(function() {
		var v = $(this).text();
		$(this).parent().attr("class", "star_" + v);
		$("#domark big").text(v);
		$("#domark em").text($(this).attr("v"));
	}, function() {
		var v = $(this).parent().attr("v");
		$(this).parent().attr("class", "star_" + v);
		$("#domark big").text(v);
		$("#domark em").text($("#domark small").eq(v - 1).attr("v"));
	});

	/**
	 * 页面加载时初始化星级评分图---------------------------------------------------------------开始
	 */

	var avg = $.trim($("#avgRating").val());
	var avgInt = Math.round(avg);
	var count = $("#stars").val();
	var myScore = $.trim($("#myScore").val());
	var myScoreInt = parseInt(myScore);

	var tag = "";
	if (myScoreInt == 1)
		tag = "很差";
	else if (myScoreInt == 2)
		tag = "差";
	else if (myScoreInt == 3)
		tag = "一般";
	else if (myScoreInt == 4)
		tag = "好";
	else if (myScoreInt == 5)
		tag = "很好";
	else {
		tag = "未评价";
		myScoreInt = 0;
	}
	$("#commonRaty div").attr("class", "star_" + avgInt);
	$("#big2").html(avgInt);
	$("#myRaty").attr("class", "star_" + myScore);
	$("#myRaty").attr("v", myScore);
	$("#myRaty").attr("class", "star_" + myScore);
	
	$("#big1").text(myScoreInt);
	$("#em1").text(tag);
	var data = [];
	data[0] = ($("#stars5").val() * 100 / count).toFixed(2);
	data[1] = ($("#stars4").val() * 100 / count).toFixed(2);
	data[2] = ($("#stars3").val() * 100 / count).toFixed(2);
	data[3] = ($("#stars2").val() * 100 / count).toFixed(2);
	data[4] = ($("#stars1").val() * 100 / count).toFixed(2);

	var ratyBody = "";
	ratyBody = ratyBody
			+ "<dd><img src=\"/common/style/agency/star/5a.gif\" /><span style=\"width:"
			+ data[0]
			+ "px;\"></span><em>"
			+ $("#stars5").val()
			+ "</em></dd><dd><img src=\"/common/style/agency/star/4a.gif\" /><span style=\"width:"
			+ data[1]
			+ "px;\"></span><em>"
			+ $("#stars4").val()
			+ "</em></dd><dd><img src=\"/common/style/agency/star/3a.gif\" /><span style=\"width:"
			+ data[2]
			+ "px;\"></span><em>"
			+ $("#stars3").val()
			+ "</em></dd><dd><img src=\"/common/style/agency/star/2a.gif\" /><span style=\"width:"
			+ data[3]
			+ "px;\"></span><em>"
			+ $("#stars2").val()
			+ "</em></dd><dd><img src=\"/common/style/agency/star/1a.gif\" /><span style=\"width:"
			+ data[4] + "px;\"></span><em>" + $("#stars1").val() + "</em></dd>";

	$("#ratyPhoto").html(ratyBody);

	/**
	 * 页面加载时初始化星级评分图---------------------------------------------------------------开始
	 */
});