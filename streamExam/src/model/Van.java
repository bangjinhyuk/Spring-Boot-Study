package model;

public class Van extends Car{
    public Van(String name, String brand) {
        super(name, brand);
    }
    public void drive(){
        System.out.println("Driving an Van "+ name + " from "+ brand);
    }
}
