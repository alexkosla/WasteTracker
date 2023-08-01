// localhost port for development
var url = "http://localhost:8080/users/create";
// example of url used with tomcat
// url = "http://localhost:8087/mapstatstf-q3-4/submit-user";

function validateForm() {
    var missingFields = new Array();
    let errormsg = "";
    let hasMiscError = false;
    var usernameTest = /^[a-zA-Z0-9._]*$/;

    // for every field in the form, get its value and check if it's empty
    // if it's empty, then add it to a list of missing fields
    let username = document.forms["addScheduleForm"]["username"].value;
    if (username == "") {
      missingFields.push("Username");
    }
    if(!usernameTest.test(username))
    {
        alert("Only alphanumeric, ',', and '_' are allowed in username");
    }
    else{
        // if there are no missing fields or format errors, save the entered data and then send an alert
        saveStats();
    }
  } 

function saveStats(){
    var toSave = document.forms["addScheduleForm"];

    // try to load any saved states and parse them as a dict
    // var loadedStats = JSON.parse(localStorage.getItem('users'));
    let toSaveDict = {};

    // format the output of the isAdmin checkbox to be a capitalized bool
    // if(toSave.admin.checked)
    //     toSave.admin.value = true;
    // else
    //     toSave.admin.value = false;

    toSave.MondayPickup.value = toSave.MondayPickup.checked ? true : false;
    toSave.TuesdayPickup.value = toSave.TuesdayPickup.checked ? true : false;
    toSave.WednesdayPickup.value = toSave.WednesdayPickup.checked ? true : false;
    toSave.ThursdayPickup.value = toSave.ThursdayPickup.checked ? true : false;
    toSave.FridayPickup.value = toSave.FridayPickup.checked ? true : false;
    toSave.SaturdayPickup.value = toSave.SaturdayPickup.checked ? true : false;
    toSave.SundayPickup.value = toSave.SundayPickup.checked ? true : false;
    var currentDate = new Date();
    var dd = String(currentDate.getDate()).padStart(2, '0');
    var month = String(currentDate.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = currentDate.getFullYear();
    var hh = String(currentDate.getHours());
    var minutes = String(currentDate.getMinutes());
    var ss = String(currentDate.getSeconds());
    // format into java-readable LocalDateTime
    var dateTime = yyyy + "-" + month + "-" + dd + "T" + hh + ":" + minutes + ":" + ss;

    toSaveDict = {
        username: "Jon_Arbuckle",
        timestamp: dateTime,
        mondayPickup: toSave.MondayPickup.checked ? true : false,
        tuesdayPickup: toSave.TuesdayPickup.checked ? true : false,
        wednesdayPickup: toSave.WednesdayPickup.checked ? true : false,
        thursdayPickup: toSave.ThursdayPickup.checked ? true : false,
        fridayPickup: toSave.FridayPickup.checked ? true : false,
        saturdayPickup: toSave.SaturdayPickup.checked ? true : false,
        sundayPickup: toSave.SundayPickup.checked ? true : false
    }

    // save the dict you've added the form stats to to local storage
    var request = JSON.stringify(toSaveDict);

    console.log(request);
    // event.preventDefault();
    fetch(url, {
        method: 'POST',
        headers: {'Content-type': 'application/json'},
        body: JSON.stringify(toSaveDict)})
    .then(async response => {
        const isJson = response.headers.get('content-type')?.includes('application/json');
        const data = isJson ? await response.json() : null;
        console.log(response);

        if (response.status != 201) {
            return Promise.reject(data || {'status': response.status, 'message' : 'Unexpected Error'});
        }
        else
        {
            alert("Stats saved!");
            console.log("Posted new schedule");
            console.log(data);
        }
    })
    .catch(error => {
        alert('There was an error!\n' +  error.message);
    }).finally(() => {
         $('.form-popup').hide();
    });
}