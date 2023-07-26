document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    
    var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth'
    });
    console.log("about to fetch readings");
    const daily_url = "http://localhost:8080/readings/getDaily";
    const users_url = "http://localhost:8080/users/getAll";

    fetch(daily_url, {
        method: "GET",
        headers: {"Content-type": "application/json"}
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
        data.forEach(element => {
          calendar.addEvent(element)
        });
        console.log(calendar.getEvents())
        // calendar.addEvent(data);
    })
    .catch((error) => {
        window.alert(error);
    });

    fetch(users_url, {
        method: "GET",
        headers: {"Content-type": "application/json"}
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
        console.log(data[0]);
        var user = data[0];
        if(user != null)
        {
            setPickupDays(user, calendar);
        }
        data.forEach(element => {
        //   calendar.addEvent(element)
        });
        // console.log(calendar.getEvents())
    })
    .catch((error) => {
        window.alert(error);
    });

    // calendar.addEvent({title: '50%', start: '2023-07-17', end: '2023-07-17'});
    // calendar.addEvent({title: '80%', start: '2023-07-18', end: '2023-07-18'});

    calendar.render();
});

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