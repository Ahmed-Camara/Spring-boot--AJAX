/**
 * 
 */

$(document).ready(function(){
	
	$('.nBtn,.table .eBtn').on('click',function(e){
		
		e.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href,function(employee,status){
			
			$('.forms #id').val(employee.id);
			$('.forms #first_name').val(employee.first_name);
			$('.forms #last_name').val(employee.last_name);
			$('.forms #email').val(employee.email);
		});
		$('.forms #exampleModalLong').modal();
	});
});