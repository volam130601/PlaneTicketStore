function getID(param) {
	console.log(param);
	$('.box-id').html(`<label for="id" class="col-form-label">ID Route</label>
					<input id="id" name="id" type="text" disabled="true" value="${param}"  class="form-control"/>`);
	$('#btnAddorUpdate').val('UPDATE Route');
	$.ajax({
		url: "/spring-plane-ticket/api/route/"+param,
		method: "GET",
		success: function(result) {
			$(`#codeFrom option[value="${result.codeFrom}"]`).attr('selected' , 'selected')
			$(`#codeTo option[value="${result.codeTo}"]`).attr('selected' , 'selected')
			$(`input[value="${result.status}"]`).attr('checked', 'true')
		},
		error: function(error) {
			console.log(error);
		}
	})
}
$('#addBtn').click(function() {
	$('.box-id').html('');
	$('#btnAddorUpdate').val('ADD Route');
	$(`#codeFrom option[value=""]`).attr('selected' , 'selected')
	$(`#codeTo option[value=""]`).attr('selected' , 'selected')
	$(`input[value="1"]`).attr('checked', 'true')
})