This Car Rental System is a Java-based application designed to manage car rental services. It utilizes Object-Oriented Programming (OOP) concepts to encapsulate various entities and behaviors in the system. The application allows users to rent cars, return cars, and view the list of available cars. It also handles customer details and rental transactions efficiently.

Key Features:
Car Management: Add, view, and manage cars available for rent.
Customer Management: Add and manage customer information.
Rental Transactions: Rent out cars to customers and manage rental details.
Return Transactions: Process car returns and update availability status.
Classes and Methods:
Car:

Attributes: car_id, brand, pricePerDay, available
Methods: getCar_id(), getBrand(), calculatePrice(int days), isAvailable(), setAvailable(boolean status)
Customer:

Attributes: custom_id, name
Methods: getCustom_id(), getName()
Rental:

Attributes: rental_id, car, customer, rentalDays
Methods: getRental_id(), getCar(), getCustomer(), getRentalDays()
CarRentalSystem:

Attributes: cars (List of Car objects), customers (List of Customer objects), rentals (List of Rental objects)
Methods:
addCar(Car car): Adds a car to the system.
addCustomer(Customer customer): Adds a customer to the system.
rentCar(Car car, Customer customer, int rentalDays): Rents a car to a customer.
returnCar(Car car): Returns a rented car and updates its status.
menu(): Displays the main menu and handles user input.
Usage:
Add Cars: The system initializes with a predefined set of cars. You can add more cars to the system if needed.
Rent a Car: Select the option to rent a car, provide customer details, choose an available car, and confirm the rental.
Return a Car: Select the option to return a car, provide the car ID, and the system will process the return and update availability.
Exit: Exit the application
