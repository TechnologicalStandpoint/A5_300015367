# A5_300015367
// Project: A5_300015367
// Copyright (c) 2020 William Kennedy

This application use the latest version of java to run its processes.
Exterior or other software is not needed to use this application.  
The UI only consists of using the command prompt.  The main function of the
application is run from the mainSystem.java file.


Compiling the system:

  This system can be compiled from any command prompt, simply enter the top level
  directory.  Compile the whole project, and run java mainSystem to run the
  main method


Important Aspects of this system:

  Database.java- Contains data structure that holds all of the created tickets,
    does the majority of the data processing for creating, manipulating, and
    deleting objects.

  Authenticator.java- Authenticates each ticket, ensuring that the ticket has
    not expired and that it has a valid serial number


Ways to improve my system:

  Create more unique serial numbers and a method to encrypt them in the
  database class.

  Create a user visual user interface, something similar you would see at a
  kiosk stand.

  A faster search to find the serial numbers of the pass holders


Architecture of the System:

  The system is similar to a multi-layer pattern, where each level mainly communicates
  with other classes on that level or its subclasses.  This is illustrated by
  the class diagram.
