document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    console.log("hello world dorrrrk");
    
    var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        // initialView: 'dayGridWeek',
        height: "90%",
        themeSystem: 'standard',
        eventTimeFormat: {
            hour: 'numeric',
            minute: '2-digit',
            meridiem: 'short'
        }
        // contentHeight: 500
    });
    console.log("about to fetch readings");
    const daily_url = "http://localhost:8080/readings/getDaily";

    var readings = getDailyReadings(calendar);
    var schedule = getPickupDays(calendar);
    var changes = getDailyChanges(calendar);

    // calendar.addEvent({title: '50%', start: '2023-07-17', end: '2023-07-17'});
    // calendar.addEvent({title: '80%', start: '2023-07-18', end: '2023-07-18'});
    setPickupAlert(readings, schedule, calendar);

    calendar.render(); 
    console.log(calendar);
});

function getDailyReadings(calendar)
{
    
    const daily_url = "http://localhost:8080/readings/getDaily";
    var readings;
    fetch(daily_url, {
            method: "GET",
            headers: {"Content-type": "application/json"}
        })
        .then(response => response.json())
        .then(data => {
            readings = data;
            console.log(data);
            data.forEach(element => {
                calendar.addEvent(element)
            });
            console.log(calendar.getEvents())
        })
        .catch((error) => {
            window.alert(error);
        });   
    return readings;
}

function getPickupDays(calendar)
{
    const users_url = "http://localhost:8080/users/getAll";
    var schedule;

    fetch(users_url, {
        method: "GET",
        headers: {"Content-type": "application/json"}
    })
    .then(response => response.json())
    .then(data => {
        schedule = data;
        console.log(data);

        var user = data[0];

        if(user != null)
        {
            setPickupDays(user, calendar);
        }
    })
    .catch((error) => {
        window.alert(error);
    });
    return schedule;
}

function getDailyChanges(calendar)
{
    const avg_changes_url = "http://localhost:8080/readings/getDailyChanges";
    var changes;
    fetch(avg_changes_url, {
            method: "GET",
            headers: {"Content-type": "application/json"}
        })
        .then(response => response.json())
        .then(data => {
            changes = data;
            console.log(changes);
            setAvgChanges(changes, calendar);
        })
        .catch((error) => {
            window.alert(error);
        });   
    return changes;
}

function setPickupDays(user, calendar)
{
    if(user.mondayPickup) {calendar.addEvent({title: 'Waste Pickup Day', daysOfWeek: [1]})}
    if(user.tuesdayPickup) {calendar.addEvent({title: 'Waste Pickup Day', daysOfWeek: [2]})}
    if(user.wednesdayPickup) {calendar.addEvent({title: 'Waste Pickup Day', daysOfWeek: [3]})}
    if(user.thursdayPickup) {calendar.addEvent({title: 'Waste Pickup Day', daysOfWeek: [4]})}
    if(user.fridayPickup) {calendar.addEvent({title: 'Waste Pickup Day', daysOfWeek: [5]})}
    if(user.saturdayPickup) {calendar.addEvent({title: 'Waste Pickup Day', daysOfWeek: [6]})}
    if(user.sundayPickup) {calendar.addEvent({title: 'Waste Pickup Day', daysOfWeek: [7]})}
}

function setAvgChanges(changes, calendar)
{
    if(changes.mondayChange) {calendar.addEvent({title: changes.mondayChange, display:'background', daysOfWeek: [1]})}
    if(changes.tuesdayChange) {calendar.addEvent({title: changes.tuesdayChange, display: 'block', daysOfWeek: [2]})}
    if(changes.wednesdayChange) {calendar.addEvent({title: changes.wednesdayChange, display: 'list-item', daysOfWeek: [3]})}
    if(changes.thursdayChange) {calendar.addEvent({title: changes.thursdayChange, display: 'inverse-background', daysOfWeek: [4]})}
    if(changes.fridayChange) {calendar.addEvent({title: changes.fridayChange, daysOfWeek: [5]})}
    if(changes.saturdayChange) {calendar.addEvent({title: changes.saturdayChange, daysOfWeek: [6]})}
    if(changes.sundayChange) {calendar.addEvent({title: changes.sundayChange, daysOfWeek: [7]})}
}

function setPickupAlert(readings, schedule, calendar)
{
    // using data i've already fetched, figure out if the user should take out their waste
    // display it somehow, probably above the calendar as like an h1

    // fetch(users_url, {
    //     method: "GET",
    //     headers: {"Content-type": "application/json"}
    // })
    // .then(response => response.json())
    // .then(data => {
    //     schedule = data;
    //     console.log(data);
    //     console.log(data[0]);
    //     var user = data[0];

    //     if(user != null)
    //     {
    //         setPickupDays(user, calendar);
    //     }
    // })
    // .catch((error) => {
    //     window.alert(error);
    // });
}