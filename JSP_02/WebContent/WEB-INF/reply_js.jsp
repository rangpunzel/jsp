<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.6/handlebars.js"></script>
<script type="text/x-handlebars-template" id="reply-list-template">
{{#each .}}
<div class="replyLi" data-rno={{rno}}>
	<i class="fas fa-comments bg-yellow"></i>
 	<div class="timeline-item" >
  		<span class="time">
    		<i class="fa fa-clock"></i>{{regdate}}
	 		<a class="btn btn-primary btn-xs" id="modifyReplyBtn"
	    		data-replyer={{replyer}} data-toggle="modal" data-target="#modifyModal">Modify</a>
  		</span>
	
  		<h3 class="timeline-header"><strong style="display:none;">{{rno}}</strong>{{replyer}}</h3>
  		<div class="timeline-body">{{replytext}} </div>
	</div>
</div>
{{/each}}
</script>

<script>
	var jsonData = [
			{
			"rno": 0,
			"bno": 2048,
			"replytext": "방가방가",
			"replyer": "mimi",
			"regdate": 1587456850000,
			"updatedate": 1587456850000
			},
			{
			"rno": 1,
			"bno": 2048,
			"replytext": "방가방가",
			"replyer": "mimi",
			"regdate": 1587456992000,
			"updatedate": 1587456992000
			}
		
	];
	var templateObject = $('#reply-list-template');
	var template=Handlebars.compile(templateObject.html());
	var html = template(jsonData);
	console.log(html);
	
	$('#repliesDiv').after(html);
</script>

