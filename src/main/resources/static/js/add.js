function validateForm() {
		var x = document.forms["myForm"]["num1"].value;
		var y = document.forms["myForm"]["num2"].value;
		if (x == "") {
			alert("Num1 must be filled out");
			return false;
		}
		if (y == "") {
			alert("Num2 must be filled out");
			return false;
		}
	}