/**
 * 
 */
 
 $("#term").on("click", function(){
	if($(this).is(":checked")){

		$(".terms").prop("checked", true);
	}else{

		$(".terms").prop("checked", false);
	}
})


function formSubmit(){
	var form = document.joinForm;
	
	check = false;
	
	$.each($(".terms"), function(index, item){
		if(!$(item).is(":checked")){
			check = true;
		}
	});
	
	if(check){
		alert("이용약관 동의가 필요합니다.");
		return;
	}
	
	form.submit();
}


function checkUsername(user_name){
	check = false;
	
	if(user_name == ""){
		$("#idCheck_text").text("");
		return;
	}
	
	$.ajax({
		url:contextPath+"/user/CheckUsernameOk.us?user_name=" + user_name,
		type:"get",
		dataType:"json",
		success:function(result){
			if(result.status == "ok"){
				$("#userCheck_text").text("사용 가능");
				$("#userCheck_text").css("color", "blue");
				check = true;
			}else{
				$("#userCheck_text").text("사용 불가");
				$("#userCheck_text").css("color", "red");
			}
		},
		error:function(){
			console.log("오류");
		}
	});
}

$("input[name='user_name']").keyup(function(){
	//중복 검사
	checkUsername($(this).val())
})
