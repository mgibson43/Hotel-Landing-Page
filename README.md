# WESTERN GOVERNOR UNIVERSITY 
## D387 – ADVANCED JAVA
### Matthew Gibson
### 11/15/2023

### Task B1
- resources: added Resource Bundle 'welcome' with files for US English and Canadian French
- welcome_en_US.properties - line 1: added welcome property
- welcome_fr_CA.properties - line 1: added welcome property
<br><br>
- edu.wgu.d387_sample_code: created d387 package
- d387: created WelcomeService.java interface with method for converting a String array to json
- d387: created WelcomeServiceImpl.java to implement WelcomeService and extend Thread
- WelcomeServiceImpl.java - lines 36-58: create 2 threads to retrieve welcome messages from resource bundles
- WelcomeServiceImpl.java - lines 30-34: as a buffer service to prevent an IllegalThreadStateException
<br><br>
- d387: created WelcomeController.java to create a get mapping to retrieve the welcome data
- WelcomeController.java - lines 18-21: inject WelcomeService into the WelcomeController and start the threads
- WelcomeController.java - lines 23-27: return the json data to the get mapping
<br><br>
- ApiConfig.java - lines 21-25: added Cors mapping for http://localhost:4200 and allowed GET and POST methods
<br><br>
- app.component.ts - line 24: added string to hold the url for the welcome get mapping
- app.component.ts - line 31: added string array to hold the data passed from the get request
- app.component.ts - lines 33-35: added method to return the data from the get request
- app.component.ts - line 54-58: parse json string from get request into a javascript array
<br><br>
- app.component.html - line 19: use *ngFor to iterate through messages array and display each message

### Task B2
- app.component.html - lines 81-82: added prices in Canadian dollars and Euros

### Task B3
- edu.wgu.d387_sample_code.converter: created TimeZoneService and TimeZoneServiceImpl
- edu.wgu.d387_sample_code.rest: created TimeZoneController
<br><br>
- TimeZoneServiceImpl.java - lines 25-41: create ZonedDateTime objects and add them to a list
- TimeZoneServiceImpl.java - lines 44-49: convert the list of ZonedDateTime objects to JSON
<br><br>
- TimeZoneController.java - lines 17-20: inject TimeZoneService into the controller
- TimeZoneController.java - lines 23-27: pass JSON of date times to front end through get mapping
<br><br>
- app.component.ts - lines 39-41: retrieve date time data from GET method
- app.component.ts - lines 66-74: convert timestamps to JS Date objects and subscribe them to the timeZone array