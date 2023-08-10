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
let bno = $('input[name = "bno"]').val();
console.log(bno);
	$.ajax({
	method:"Post",
	data: $("#replyFrm").serialize(),
	url:"/replies/new",
	success: function(result) {
		replyList(bno);	
	},
	error: function (){}
	//contentType:
})
});