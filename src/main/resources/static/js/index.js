// import { Calendar } from '@fullcalendar/core';

document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    
    var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        // initialView: 'dayGridWeek',
        height: "90%",
        // themeSystem: 'standard',
        eventTimeFormat: {
            hour: 'numeric',
            minute: '2-digit',
            meridiem: 'short'
        }, 
        headerToolbar: {
            end: 'dayGridMonth,timeGridWeek today prev,next',
            start: 'title',
        },
        // contentHeight: 500
    });
    console.log("about to fetch readings");
    const daily_url = "http://localhost:8080/readings/getDaily";

    var percents = getDailyReadings(calendar);
    var schedule = getPickupDays(calendar);
    var average_changes = getDailyChanges(calendar);
    Promise.all([average_changes, percents, schedule]).then((values) => {
        console.log(values);
        setPickupAlert(values[0], values[1], values[2], calendar);
    })

    // calendar.addEvent({title: '50%', start: '2023-07-17', end: '2023-07-17'});
    // calendar.addEvent({title: '80%', start: '2023-07-18', end: '2023-07-18'});
        
    // setTimeout(() =>
    // {
    //     console.log("printing percents after delay");
    //     console.log(average_changes);
    //     console.log(percents);
    //     console.log(schedule);
    //     setPickupAlert(average_changes, percents, schedule, calendar);
    // }, 2000);
    

    calendar.render(); 
    console.log(calendar);
});

async function getDailyReadings(calendar)
{
    try{
        const daily_url = "http://localhost:8080/readings/getDaily";
        var readings;
        const response = await fetch(daily_url, {
            method: "GET",
            headers: {"Content-type": "application/json"}
        });
        readings = await response.json();
        readings.forEach(element => {
            calendar.addEvent(element)
        });
        return readings;
    } catch (error) {
        console.error(error);
    }
}

async function getPickupDays(calendar)
{
    try{
        const users_url = "http://localhost:8080/users/getAll";
        const response = await fetch(users_url, {
            method: "GET",
            headers: {"Content-type": "application/json"}
        });
        const schedule = await response.json();
        var user = schedule[0];

        if(user != null)
        {
            setPickupDays(user, calendar);
        }
        return user;
    } catch (error) {
        console.error(error);
    }
}

async function getDailyChanges(calendar)
{
    try{
        const avg_changes_url = "http://localhost:8080/readings/getDailyChanges";
        var changes;
        const response = await fetch(avg_changes_url, {
            method: "GET",
            headers: {"Content-type": "application/json"}
        });
        changes = await response.json();
        setAvgChanges(changes, calendar);

        return changes;
    } catch (error) {
        console.error(error);
    }
}

function getDailyChangesOld(calendar)
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
            console.log("changes are:");
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
    console.log("in setAvgChanges");
    if(changes.mondayChange) {calendar.addEvent({title: changes.mondayChange + '% avg increase', color:'rgb(50,50,50)', daysOfWeek: [1]})}
    if(changes.tuesdayChange) {calendar.addEvent({title: changes.tuesdayChange + '% avg increase', color:'rgb(50,50,50)', daysOfWeek: [2]})}
    if(changes.wednesdayChange) {calendar.addEvent({title: changes.wednesdayChange + '% avg increase', color:'rgb(50,50,50)', daysOfWeek: [3]})}
    if(changes.thursdayChange) {calendar.addEvent({title: changes.thursdayChange + '% avg increase', color:'rgb(50,50,50)',  daysOfWeek: [4]})}
    if(changes.fridayChange) {calendar.addEvent({title: changes.fridayChange + '% avg increase', color:'rgb(50,50,50)', daysOfWeek: [5]})}
    if(changes.saturdayChange) {calendar.addEvent({title: changes.saturdayChange + '% avg increase', color:'rgb(50,50,50)', daysOfWeek: [6]})}
    if(changes.sundayChange) {calendar.addEvent({title: changes.sundayChange + '% avg increase', color:'rgb(50,50,50)', daysOfWeek: [0]})}
}

/**
 * 
 * @param {Array} average_changes 
 * @param {Array} percents 
 * @param {Array} schedule 
 * @param {Calendar} calendar 
 */
function setPickupAlert(average_changes, percents, schedule, calendar)
{
    // using data i've already fetched, figure out if the user should take out their waste
    // display it somehow, probably above the calendar as like an h1

    var currDate = calendar.getDate();
    console.log("in setPickupAlert");
    console.log(average_changes);
    console.log(percents);
    console.log(schedule);

    // 1. get the current day
    // 2. figure out what the next pickup day is
    // 3. for each of the days in between, get the average changes
    // 4. add those averages up together with the current fullness
    // 5. if the sum is greater than 90%, change the text of an H1 alert somewhere on the page

    // 1. get the current day
    // let's assume that we'll have a reading for today
    var currReading = percents[percents.length - 1];
    var currReadingDate = new Date(currReading["end"]);
    console.log(currReadingDate);

    
    // 2. figure out what the next pickup day is
    // add on a date and check if the new date is a pickup day
    // gets day of the week as a number
    console.log(currReadingDate.getDay());
}

function calculateNextPickup(average_changes, percents, schedule)
{
    // first calculate if the user needs
}