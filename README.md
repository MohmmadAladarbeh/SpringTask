
# Lab 11
in this Lab we should to use spring boot framework to deal with web app and create routepointe and connect it with mdel and view

## RoutePointe that i created in this Lab

* ##  /hello 
    this route will show to us the hello view    

* ## /hello/{name}
    this route will take the name as a variable path and show this variable with uppercase format in html page(view)

* ## / 
    this route is the root to the my app 
* ## /albums

    this route will create object from Album class and the show this object as a json format in view templet 

* ## Controller 
    we use controller to connect between our routepointe and view and model(album class)

# Lab 12
in this Lab we should to use spring boot framework to deal with web app and create table inside our postgres (DBMS) .

## RoutePointe that I'm created in this Lab

* ## /albumpage 
    this route will return to me view that contain form format that allow to us add fill this input field and the save it inside my database.  
    after I click on submit form the form automatically will call /addalbum rout that will add this values iside my database.
* ## /addalbum  
    this route will be available after the user click on the submit method that found inside form templet.  
    this rout that will add the value that the user entered it in the field and then save this value inside my database with use repository that deal with postgres (DBMS).
* ## properties that I use it to deal with postgres (DBMS).
    spring.sql.init.platform=postgres  
    spring.datasource.url=jdbc:postgresql://localhost:5432/lab12  
    spring.datasource.username=mohmad_98  
    spring.datasource.password=  
    spring.jpa.hibernate.ddl-auto=update  
    spring.sql.init.mode=always  
