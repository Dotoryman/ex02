/* filename : reply.js */

console.log("댓글처리입니다옹")


function replyList(bno){

$.ajax({
	method:"get",       //type으로 써도 된다
	url:`/replies/pages/${bno}/1`,
	//data:
	//contentType:
	success: function(result) {
		$("#replyList").html("");
		for(i = 0 ; i < result.length; i++){
		$("#replyList").append(result[i].reply + "<br>");
		}
	},
	error: function (){}
})
}

$("#addReply").on("click", function () {
	$.ajax({
	method:"Post",
	data: $("#replyFrm").serialize(),
	url:"/replies/new",
	success: function(result) {
	//	alert(result);
		replyList();	
	},
	error: function (){}
	//contentType:
})
});