/**
 * 
 */

$(document).ready(function(){
	
	$('.nBtn,.table .eBtn').on('click',function(e){
		
		e.preventDefault();
		
		var href = $(this).attr('href');
		
		var text = $(this).text();
		
		if(text=='Edit'){
			$.get(href,function(employee,status){
			
				$('.forms #id').val(employee.id);
				$('.forms #first_name').val(employee.first_name);
				$('.forms #last_name').val(employee.last_name);
				$('.forms #email').val(employee.email);
			});
			
			$('.forms #exampleModalLong').modal();
		
		}else{
			
			$('.forms #id').val(0);
			$('.forms #Eid').hide();
			$('.forms #first_name').val('');
			$('.forms #last_name').val('');
			$('.forms #email').val('');
			
			$('.forms #exampleModalLong').modal();
		}
		
	});
});