# forum
Forum (registration, authorization, data storage in the database, distribution of access rights (to the list of users and the granting of rights to them). By default, an administrator is created (password: pass) and user (password: user).

launch on Linux, if necessary, install packages

    service postgresql start;

    su postgres;

    psql;

    all that is required is to create a database with the command: (create database forum);

    to make sure everything is done correctly, run the command (\l) and find the name of the database you just created

    download and import the project into the IDE or run from the terminal in the root, running the command mvn package. 
    After we find and run the file. For example: java -jar forum-1.0-SNAPSHOT.jar. 
    
    Open the browser and enter in the address bar: localhost:8080. If the port is busy, you can check this with the command:
    lsof -i tcp:8080. We can kill the process on the port with the following command: pgrep java | xargs kill -9. Or change
    the port used in the file application.properties
    
