# user-details-service

This Microservice handles user details regarding user's movie preferences.

The code has two starting points

1) An initial migration : It reads user preferences from a json file, provided in the resources and stores it in mongoDB, in the preferred schema.

2) A server : It provides REST API's to access user preferences from mongoDB 
