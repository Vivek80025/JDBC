package org.example;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TruckService truck = new TruckService();

        Truck tata = new Truck("TATA","2021",1000,"Rajesh");
        Truck volvo = new Truck("VOLVO","2022",1000,"Bashisht");
        Truck mahindra = new Truck("MAHINDRA","2023",1000,"Vivek");
        Truck eicher = new Truck("EICHER","2024",1000,"Rajan");

        //adding data into database
        System.out.println("Adding data.................");
        truck.addTruck(tata);
        truck.addTruck(volvo);
        truck.addTruck(mahindra);
        truck.addTruck(eicher);

        //fetch
        System.out.println("Fetching the data by ID..........."+2);
        Truck t = truck.getTruckBuyId(2);
        System.out.println("truck data: "+t);

        //updating truck data
        System.out.println("updated data.....................");
        t.setDriver_name("gullu bro");
        truck.updateTruck(t);
        System.out.println("updated truck data: "+truck.getTruckBuyId(2));

        //get all truck data
        System.out.println("fetching all the data...........................");
        List<Truck> list = truck.getAllTrucks();
        for(Truck allt : list){
            System.out.println(allt);
        }

        //delete truck data
        System.out.println("deleting truck data by id............."+4);
        truck.deleteTruck(4);
        System.out.println("data deleted by id "+4);

        //truck data after all operation
        System.out.println("truck data after all operation performed.....................");
        List<Truck> alltruck = truck.getAllTrucks();
        for(Truck allt : alltruck){
            System.out.println(allt);
        }
    }
}
