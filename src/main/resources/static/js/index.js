document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    
    var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        height: "85%",
        eventTimeFormat: {
            hour: 'numeric',
            minute: '2-digit',
            meridiem: 'short'
        }, 
        headerToolbar: {
            end: 'dayGridMonth,timeGridWeek today prev,next',
            start: 'title',
        },
    });

    var percents = getDailyReadings(calendar);
    var schedule = getPickupDays(calendar);
    var average_changes = getDailyChanges(calendar);
    Promise.all([average_changes, percents, schedule]).then((values) => {
        console.log(values);
        setPickupAlert(values[0], values[1], values[2], calendar);
    })    

    calendar.render(); 
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

    var alert = document.getElementById('alert');
    var currDate = calendar.getDate();
    alert.hidden = true;
    alert.innerHTML = "";

    // 1. get the current day
    // 2. figure out what the next pickup day is
    // 3. for each of the days in between, get the average changes
    // 4. add those averages up together with the current fullness
    // 5. if the sum is greater than 90%, change the text of an H1 alert somewhere on the page

    // 1. get the current day
    // let's assume that we'll have a reading for today
    var currReading = percents[percents.length - 1];
    var currReadingDate = new Date(currReading["end"]);

    // if the date of the last reading does not equal today
    // then don't display an error
    var today = new Date();
    var readingIsUpToDate = false;
    var pickupIsTomorrow = false;

    // if there is no reading for the current day, never display a pickup alert
    if(currReadingDate.getFullYear() == today.getFullYear() && currReadingDate.getMonth() == today.getMonth() && currReadingDate.getDate() == today.getDate())
    {
        console.log("last reading is today, gonna check for pickup alert")
        readingIsUpToDate = true;
        debugger
    }
    
    // 2. figure out what the next pickup day is
    // add on a date and check if the new date is a pickup day
    // gets day of the week as a number
    // day int is 0 for sunday, 6 for saturday, bizarrely
    var pickupDayDecoder = {0: "sundayPickup", 1: "mondayPickup", 2: "tuesdayPickup", 
                            3: "wednesdayPickup", 4: "thursdayPickup", 5: "fridayPickup", 6: "saturdayPickup"};
    var avgChangeDecoder = {0: "sundayChange", 1: "mondayChange", 2: "tuesdayChange", 
                            3: "wednesdayChange", 4: "thursdayChange", 5: "fridayChange", 6: "saturdayChange"};

    var currDayInt = currReadingDate.getDay();
    var totalPercent = parseFloat(currReading.percent);
    var nextDayInt = (currDayInt + 1) % 7;

    // if tomorrow is a pickup day, try to calculate if you should take out the bin now
    // or wait until the next pickup day
    if(schedule[pickupDayDecoder[nextDayInt]])
        pickupIsTomorrow = true;

    if(pickupIsTomorrow && readingIsUpToDate)
    {
        for(dayCount = 0; dayCount < 7; dayCount++)
        {
            currDayInt += dayCount;
            // check for the next pickup day AFTER tomorrow
            var nextDayInt = (currDayInt + 2) % 7;
            debugger
    
            // if the next day is a pickup day
            if(schedule[pickupDayDecoder[nextDayInt]])
            {
                // check if totalPercent exceeds threshold
                if(totalPercent > 90.0)
                {
                    alert.hidden = false;
                    alert.innerHTML = "Recommendation: Take out your bin";
                }
                // if the threshold isn't estimated to be exceeded by the next pickup day
                // then no alert needs to be displayed
                break;
            }
            else
            {
                // if the next pickup day isn't the following day
                // estimate the waste production by getting the average percent for that day
                // and adding it onto the totalPercent
                totalPercent += parseFloat(average_changes[avgChangeDecoder[nextDayInt]]);
            }
            console.log("total percent is: "+totalPercent);
        }
    }
    
}