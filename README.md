# CarRentalSimulation




# Team Members:


Krithika Damodar Bhat

Meeti Baliga


# Instructions to Run the code:


On the terminal:

git clone https://github.com/meetibaliga/CarRentalSimulation

cd src/

javac RentalSimulation/Main.java

java RentalSimulation/Main

Output will be stored in logs.txt in src

# Language Used: Java

# Compiler: javac

# Description and Assumption:

System Design:
Car Rental System

Assumption Discussion:
Below are the list of assumption we made while designing the system
1. Only 24 cars are available and customers are only 12 (4- casual customer, 4 – regular
customer and 4 – business customer)
2. Cars are (Economy – 6, Standard – 4, Minivan - 4, SUV – 6 and Luxury – 4)
3. No Customer will take more than what is assigned to them.
4. Add on for cars are 1 and will be added per car.
5. Hardcoded number of customers limited to 3 per day.

System Design:
We have used three design patterns to make the Car Rental System.

1) Decorator Design pattern a. AddOnCost
This is the class which acts as a decorator class for (add ons). This will update the price of the order by adding price of add on and providing cashier with proper amount.
Below are the classes which uses this:
• satelliteRadio.java
• childseat.java
• GPSModule.java

2) Factory Design Pattern a. CatalogFactory
This factory will provide us with instance of various cars as requested. It will
limit the instance creation with amount of cars.

3) Observer Design Pattern a. OrderObserverClass
This is our observer class which will maintain all updated details of day and transation details per day. This will also print details to console which allow us to see store performance per day.






