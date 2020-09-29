 # VENDING MACHINE PROJECT
 A vending machine system that has all the usual Vending machine functionalities with a GUI (Java FX).

The vending machine is a money-less operation where clients buy credit using an App and can then use that credit to buy bars in the vending machines, make photocopies in the library and buy meals in the café. 

The vending machine software loads up the ‘client’ and 'product' files on started up. The files contain customer details (username, current credit and password) and product details (name, location, cost and quantity).

To buy a product the user has to identify themselves (username and password), have enough credit and specify the product location in the vending machine. 

An admin is allowed to add/reload products back into the vending machine and “shut the system down”. This shutdown process stores the current product and customer details to the csv file that is reloaded on start-up.

The main functionality of the program:

 - It incorporates the persistent files into the system, as specified above;

 - Provides a graphical user interface (GUI) to the system using JavaFX; 

 - Offers operator authentication services for customers and admin.
 
 The program can be run through the main Login class.
