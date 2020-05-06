function validatelogin(){
	var username = document.login.username;
	var password = document.login.password;
	
	if(username_validation(username) & password_validation(password)){
		
		return true;
	}
	return false;
}

function username_validation(username){
	if(username.value.length == 0){
		document.getElementById('email_error').innerHTML = 'Email must be filled out';
		username.focus();
		return false;
	}
	return true;
}

function password_validation(password){
	if(password.value.length == 0){
		document.getElementById('password_error').innerHTML = 'Password must be filled out';
		password.focus();
		return false;
	}
	return true;
}
var select=-1;


function validateregister(){
	var premisesName = document.register.premisesName;
	var premisesContactNumber = document.register.premisesContactNumber;
	var email = document.register.email;
	var ownerName = document.register.ownerName;
	var ownerContactNumber = document.register.ownerContactNumber;
	var premisesAddress = document.register.premisesAddress;
	var country = document.register.country;
	var state = document.register.state;
	var city = document.register.city;
	//console.log(country.options[country.selectedIndex].value);
	if(premisesName_validation(premisesName) & premisesContactNumber_validation(premisesContactNumber) & email_validation(email)
			& ownerName_validation(ownerName) & ownerContactNumber_validation(ownerContactNumber) &  premisesAddress_validation(premisesAddress)){
			//& state_validation(state) & country_validation(country) & city_validation(city)
		return true;
	}
	return false;
}

function premisesName_validation(premisesName){
	if(premisesName.value.length == 0){
		document.getElementById('premisesNameError').innerHTML = 'Premises Name must be filled out';
		premisesName.focus();
		return false;
	}
	return true;
}

function premisesContactNumber_validation(premisesContactNumber){
	if(premisesContactNumber.value.length == 0){
		document.getElementById('premisesContactNumberError').innerHTML = 'Premises Contact number must be filled out';
		premisesContactNumber.focus();
		return false;
	}
	return true;
}

function email_validation(email){
	if(email.value.length == 0){
		document.getElementById('emailError').innerHTML = 'Email must be filled out';
		email.focus();
		return false;
	}
	return true;
}

function ownerName_validation(ownerName){
	if(ownerName.value.length == 0){
		document.getElementById('ownerNameError').innerHTML = 'Owner Name must be filled out';
		ownerName.focus();
		return false;
	}
	return true;
}

function ownerContactNumber_validation(ownerContactNumber){
	if(ownerContactNumber.value.length == 0){
		document.getElementById('ownerContactNumberError').innerHTML = 'Owner Contact Number must be filled out';
		ownerContactNumber.focus();
		return false;
	}
	return true;
}

function premisesAddress_validation(premisesAddress){
	if(premisesAddress.value.length == 0){
		document.getElementById('premisesAddressError').innerHTML = 'Premises Address must be filled out';
		premisesAddress.focus();
		return false;
	}
	return true;
}
/*function country_validation(country){
	if(country.options[country.selectedIndex].value > 0){
		document.getElementById('countryError').innerHTML = 'country Name must be chosen';
		country.focus();
		return false;
	}
	return true;
}

function state_validation(state){
	if(state.selectedIndex > 0){
		document.getElementById('stateError').innerHTML = 'state Name must be chosen';
		state.focus();
		return false;
	}
	return true;
}

function city_validation(city){
	if(city.selectedIndex > 0){
		document.getElementById('cityError').innerHTML = 'city Name must be chosen';
		city.focus();
		return false;
	}
	return true;
}*/

