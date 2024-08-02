package Project;

class Car {
    private final int car_id;
    private final String brand;
    private boolean available;
    private final double rentalPricePerDay;

    public Car(int car_id, String brand, double rentalPricePerDay) {
        this.car_id = car_id;
        this.brand = brand;
        this.rentalPricePerDay = rentalPricePerDay;
        this.available = true; 
    }

    public int getCar_id() {
        return car_id;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double calculatePrice(int days) {
        return rentalPricePerDay * days;
    }

    public void rent() {
        available = false;
    }

    public void returnCar() {
        available = true;
    }
}
