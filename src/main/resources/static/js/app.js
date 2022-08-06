function validate() {
	var username = document.getElementById('username').value;
	var password = document.getElementById('password').value;
	if (username == '') {
		alert('Please provide valid username');
		document.getElementById('username').focus();
		return false;
	}else if (password == '') {
		alert('Please provide valid password');
		document.getElementById('password').focus();
		return false;
	} else {
		return true;
	}
}


