# WasteTracker
IoT-based waste tracking website

This code in intended to work with https://github.com/alexkosla/WasteTracker-RPI, which is how the reading data is obtained for this application. Follow the instruction at that repo to set everything up to receive data as intended.

To run this code, you'll need a MySQL Database up and running. You can use the `createDB_final.sql` file to generate a compatible database. By default, the readings table used is titled `readingtest`, which contains seeded data. If you want to start fresh, I recommend going to the `ReadingModel` class and changing line 21 to be `reading` instead of `readingtest`, and then wiping the `reading` table manually in SQL Workbench.

To make sure your SQL database is talking to Spring Boot, check out `application.properties` and change the lines there to match your own db setup.

To run the application, I recommend opening the project up using the pom.xml in an IDE such as IntelliJ. Then click the play icon to run it. If you have trouble with that, try running it via maven. Once the back-end is up and running, you should be able to access the front-end by going to `localhost:8080` in your web browser.

I've included comments at the start of functions and entity/model classes that give a brief overview of how they work, along with a some more detailed comments in some of the more complex functions that might be harder to follow.


