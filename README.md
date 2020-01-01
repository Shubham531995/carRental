# carRental
Car Rental Application
******************Car Rental Application*****************


1) DB connections and scripts:

i) I have used an Oracle DB with login details : user : "system" pass: "password" .
ii) There a in total 2 tables : a) CARDETAILS b) BOOKINGDETAILS
iii) CARDETAILS : consist of all the details for a specific car.
iv) BOOKINGDETAILS: consist of all the car that are booked as per specific date.

Scripts:

create table cardetails(carid varchar2(10), carname varchar2(50),carprice number(10),carseats number(10),transmission varchar2(20),engine varchar2(50),photo varchar2(50),location varchar2(50));
create table bookingdetails(carid varchar2(10), datetime varchar2(50));
insert into cardetails (carid, carname, carprice, carseats, transmission, engine, photo, location) values (1,BMW,5000,5,AUTO,DIESEL,/photo/bmw.png,YELAHANKA);
insert into cardetails (carid, carname, carprice, carseats, transmission, engine, photo, location) values (2,AUDI,8000,5,AUTO,PETROL,/photo/audi.png,MARATHALI);
insert into cardetails (carid, carname, carprice, carseats, transmission, engine, photo, location) values (3,LANCER,8000,5,AUTO,PETROL,/photo/lancer.png,YELAHANKA);
insert into cardetails (carid, carname, carprice, carseats, transmission, engine, photo, location) values (4,AUDI,8000,4,AUTO,PETROL,/photo/audi.png,WHITEFIELD);
insert into cardetails (carid, carname, carprice, carseats, transmission, engine, photo, location) values (5,BMW,8000,5,AUTO,PETROL,/photo/audi.png,INDRANAGAR);
insert into cardetails (carid, carname, carprice, carseats, transmission, engine, photo, location) values (6,ZEN,8000,4,AUTO,PETROL,/photo/audi.png,BELANDHUR);

insert into bookingdetails(carid,datetime) values (1,01JAN2019);
insert into bookingdetails(carid,datetime) values (1,04JAN2019);
insert into bookingdetails(carid,datetime) values (6,01JAN2019);
insert into bookingdetails(carid,datetime) values (1,06JAN2019);
insert into bookingdetails(carid,datetime) values (3,02JAN2019);
insert into bookingdetails(carid,datetime) values (1,01JAN2019);

commit;

2) API description:

i) After running the project on any tomcat server a JSP get displays on the localhost.
ii) JSP contains two input fields: Location and date with a submit button.
iii) Submit button click calls the servlet that internally runs a db script on the database and fetch the result.
iv) JSP shows the result json on the screen with the availability of cars with location.
v) Status 1 : represent that the car is available Status 0: car is unavailable.
