
var breakingStart = true;	// autostart breaking news
var breakingSpeed = 40;		// breaking msg speed

var breakingScroll = [0,0,0,0,0,0,0,0,0,0];
var breakingOffset = [0,0,0,0,0,0,0,0,0,0];
var elementsToClone = [true,true,true,true,true,true,true,true,true,true];
var elementsActive = [];
var theCount = [0,0,0,0,0,0,0,0,0,0];
var _legatus_slider_timer;

// Legatus Slider Options
var _legatus_slider_autostart = true	// Autostart Slider (false / true)
var _legatus_slider_interval = 5000;	// Autoslide Interval (Def = 5000)
var _legatus_slider_loading = true;		// Autoslide With Loading Bar (false / true)



//form validation
function validateName(fld) {
    "use strict";
    var error = "";

    if (fld.value === '' || fld.value === 'Nickname' || fld.value === 'Enter Your Name..' || fld.value === 'Your Name..') {
        error = "You didn't enter Your First Name.";
    } else if ((fld.value.length < 2) || (fld.value.length > 200)) {
        error = "First Name is the wrong length.";
    }
    return error;
}

function validateEmail(fld) {
    "use strict";
    var error="";
    var illegalChars = /^[^@]+@[^@.]+\.[^@]*\w\w$/;

    if (fld.value === "") {
        error = "You didn't enter an email address.";
    } else if ( fld.value.match(illegalChars) === null) {
        error = "The email address contains illegal characters.";
    }

    return error;

}

function valName(text) {
    "use strict";
    var error = "";

    if (text === '' || text === 'Nickname' || text === 'Enter Your Name..' || text === 'Your Name..') {
        error = "You didn't enter Your First Name.";
    } else if ((text.length < 2) || (text.length > 50)) {
        error = "First Name is the wrong length.";
    }
    return error;
}

function valEmail(text) {
    "use strict";
    var error="";
    var illegalChars = /^[^@]+@[^@.]+\.[^@]*\w\w$/;

    if (text === "") {
        error = "You didn't enter an email address.";
    } else if ( text.match(illegalChars) === null) {
        error = "The email address contains illegal characters.";
    }

    return error;

}

function validateMessage(fld) {
    "use strict";
    var error = "";

    if (fld.value === '') {
        error = "You didn't enter Your message.";
    } else if (fld.value.length < 3) {
        error = "The message is to short.";
    }

    return error;
}

function validatecheckbox() {
    "use strict";
    var error = "Please select at least one checkbox!";
    return error;
}