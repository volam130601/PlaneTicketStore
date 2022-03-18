function showMessage(txt, name) {
	if(txt == 'add_success') {
		var message = {
			toast_header: 'ADD '+ name,
			toast_body: 'Look! Add '+name+' Success!',
			color: 'success',
			icon: '<i class="fa-solid fa-circle-check"></i>'
		}
	}
	if(txt == 'add_error') {
		var message = {
			toast_header: 'ADD '+name+'',
			toast_body: 'ERROR!!! Add '+name+' defeat!',
			color: 'danger',
			icon: '<i class="fa-solid fa-circle-exclamation"></i>'
		}
	}
	if(txt == 'update_success') {
		var message = {
			toast_header: 'UPDATE '+name+'',
			toast_body: 'Look! Update '+name+' Success!',
			color: 'success',
			icon: '<i class="fa-solid fa-circle-check"></i>'
		}
	}
	if(txt == 'update_error') {
		var message = {
			toast_header: 'UPDATE '+name+'',
			toast_body: 'ERROR!!! Update '+name+' defeat!',
			color: 'danger',
			icon: '<i class="fa-solid fa-circle-exclamation"></i>'
		}
	}
	if(txt == 'delete_success') {
		var message = {
			toast_header: 'DELETE '+name+'',
			toast_body: 'Hello! Delete '+name+' Success!',
			color: 'success',
			icon: '<i class="fa-solid fa-circle-check"></i>'
		}
	}
	if(txt == 'delete_error') {
		var message = {
			toast_header: 'DELETE '+name+'',
			toast_body: 'ERROR!!! Delete '+name+' defeat!',
			color: 'danger',
			icon: '<i class="fa-solid fa-circle-exclamation"></i>'
		}
	}
	var toastStr = `<div id="liveToast" class="bg-${message.color} rounded fadeInOut" role="alert" aria-live="assertive" aria-atomic="true">
	                                <div class="toast-header bg-${message.color} text-light">
	                                    <span aria-hidden="true" class="me-1">${message.icon}</span>
	                                    <strong class="me-auto">${message.toast_header}</strong>
	                                    <small>4 second</small>
	                                    <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
	                                </div>
	                                <div class="toast-body text-light">
	                                    ${message.toast_body}
	                                </div>
	                            </div>`;
	$('#box-toast').html(toastStr);
	$('#liveToast').toast('show')
}