// localhost port for development
url = "http://localhost:8080/users/create";

// saveStats: Gets form data to select which days of the week there will be a waste pickup
// Next, a timestamp string that is easily parsable as a Java LocalDateTime object is built using the current time
// All of these values are saved to a dictionary, with the pickup data converted to bools
// A dummy variable is set for username, as this uses the create user endpoint that was too late to change
// the dict is converted to JSON and then POSTed to the create user endpoint
function saveStats(){
    var toSave = document.forms["addScheduleForm"];
    let toSaveDict = {};

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
    request = JSON.stringify(toSaveDict);

    console.log(request);
    event.preventDefault();
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