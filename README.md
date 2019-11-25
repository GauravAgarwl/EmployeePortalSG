# EmployeePortalSG
UI is created in Angular 6 and bootstrap for simple styling.
Please start the UI with ng serve command. Then go to any browser and type http://localhost:4200 to view the login page.
So Before logging into the application we have to register into the system.
Once registration is done then log in to the application using First Name as username and Last Name as password.Both are case sensitive.
For Authentication I have used JWT in the backend and Auth Guard in frontend. So the url http://localhost:4200/viewAllUsers will be accessible only when the user is  logged in. Session management is also done using JWT and by default the time is set as 5 minutes.
Once the login is successsful it will redirect you to display list of registered employees.
Please do npm install --save and npm install bootstarp --save to generate the node modules.


Backend is created using Springboot,hibernate,jpa

Start the server by running the main file namely Application.java as a java program.
Spring security has been used for authentication and authorization.
Mysql database has been used to store data into the database.
Hibernate is used to create the table automatically if the table is not present.
BCryptPasswordEncoder is used to store the password in the db.
Rest end point (http://localhost:4200/viewAllUsers) is accessible only when the user is logged in and have a valid token.
