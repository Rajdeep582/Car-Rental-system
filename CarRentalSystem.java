package Project;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CarRentalSystem {
    ArrayList<Car> cars;
    ArrayList<Customer> customers;
    ArrayList<Rental> rentals;

    public CarRentalSystem() {
       cars=new ArrayList<>();
        this.customers=new ArrayList<>();
        this.rentals=new ArrayList<>();
    }
    public void addCar(Car car) {
        cars.add(car);
    }
    public void addCustomer(Customer customer)
    {
        customers.add(customer);
    }
    public void addRentals(Rental rent)
    {
        rentals.add(rent);
    }



    public void rentCar(Car car,Customer customer,int days)
    {
        if(car.isAvailable())
        {
            car.rent();
            car.setAvailable(false);
            rentals.add(new Rental(car,customer,days));
        }
        else{
            System.out.println("Car is not available!!!");
        }
    }
    public void returnCar(Car car){
        Rental removeRental=null;
        for(Rental rental: rentals)
        {
            if(rental.getCar()==car)
            {
                car.returnCar();
                car.setAvailable(true);
                removeRental=rental;
                break;
            }
        }
        if(removeRental!=null)
        {
            rentals.remove(removeRental);
            System.out.println("--------------Return Successful-------------");
        }
        else{
            System.out.println("------------Car was not rented--------------");
        }
    }
    public void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("<----- Car Rental System ----->");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = 0;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
            }

            switch (choice) {
                case 1:
                    System.out.println("\n---- Rent a Car ----\n");
                    System.out.print("Enter your name: ");
                    String customerName = sc.nextLine();

                    System.out.println("--- Available Cars ---");
                    for (Car car : cars) {
                        if (car.isAvailable()) {
                            System.out.println(car.getBrand() + " ---> " + car.getCar_id());
                        }
                    }

                    System.out.print("\nEnter the car brand you want to rent: ");
                    String carName = sc.nextLine();
                    System.out.print("Enter the number of days for rental: ");
                    int rentalDays = sc.nextInt();
                    sc.nextLine();

                    Customer newCustomer = new Customer(customers.size() + 100, customerName);
                    addCustomer(newCustomer);

                    Car selectedCar = null;
                    for (Car car : cars) {
                        if (car.getBrand().equalsIgnoreCase(carName) && car.isAvailable()) {
                            selectedCar = car;
                            break;
                        }
                    }

                    if (selectedCar != null) {
                        double totalPrice = selectedCar.calculatePrice(rentalDays);
                        System.out.println("\n<----- Rental Information ----->\n");
                        System.out.println("Customer ID: " + newCustomer.getCustom_id());
                        System.out.println("Customer Name: " + newCustomer.getName());
                        System.out.println("Car: " + selectedCar.getBrand());
                        System.out.println("Duration: " + rentalDays);
                        System.out.printf("Total Price: $%.2f%n", totalPrice);
                        System.out.println("Enter (Y/N) to confirm booking");
                        String confirm = sc.nextLine();

                        if (confirm.equalsIgnoreCase("Y")) {
                            rentCar(selectedCar, newCustomer, rentalDays);
                            System.out.println("------ Booking confirmed -----");
                            System.out.println("----- Booking details -----");
                            System.out.println("Car Brand: " + selectedCar.getBrand());
                            System.out.println("Car ID: " + selectedCar.getCar_id());
                            System.out.println("Customer name: " + newCustomer.getName());
                            System.out.println("Rent duration: " + rentalDays);
                            System.out.println("Status: Booked");
                        } else {
                            System.out.println("Try again!!!");
                        }
                    }
                    break;

                case 2:
                    System.out.println("<---- Welcome to car return system ---->");
                    System.out.print("Enter car ID to return: ");
                    int carId;
                    try {
                        carId = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Error: " + e.getMessage());
                        sc.next();
                        break;
                    }

                    Car toReturnCar = null;
                    for (Car car : cars) {
                        if (car.getCar_id() == carId && !car.isAvailable()) {
                            toReturnCar = car;
                            break;
                        }
                    }

                    if (toReturnCar != null) {
                        Customer customer = null;
                        for (Rental rental : rentals) {
                            if (rental.getCar() == toReturnCar) {
                                customer = rental.getCustomer();
                                break;
                            }
                        }

                        if (customer != null) {
                            returnCar(toReturnCar);
                            System.out.println("Car returned successfully by " + customer.getName());
                        } else {
                            System.out.println("No rental record found for this car.");
                        }
                    } else {
                        System.out.println("Invalid car ID or car not rented.");
                    }
                    break;

                case 3:
                    System.out.println("<--------------- Thank you for using Car Rental System --------------->");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    public static void main(String[] args) {
        CarRentalSystem rentalSystem=new CarRentalSystem();
        Car car1 = new Car(1, "Toyota",  60.0);
        Car car2 = new Car(2, "Honda",  70.0);
        Car car3 = new Car(3, "Mahindra", 150.0);
        Car car4 = new Car(4, "Ford", 80.0);
        Car car5 = new Car(5, "Chevrolet", 90.0);
        Car car6 = new Car(6, "BMW", 120.0);
        Car car7 = new Car(7, "Audi", 130.0);
        Car car8 = new Car(8, "Mercedes", 140.0);
        Car car9 = new Car(9, "Hyundai", 55.0);
        Car car10 = new Car(10, "Nissan", 85.0);

        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);
        rentalSystem.addCar(car4);
        rentalSystem.addCar(car5);
        rentalSystem.addCar(car6);
        rentalSystem.addCar(car7);
        rentalSystem.addCar(car8);
        rentalSystem.addCar(car9);
        rentalSystem.addCar(car10);
        rentalSystem.menu();
    }

}
