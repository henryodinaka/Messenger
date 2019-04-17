package com.leo.henry.messenger.lecture.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Locations locations = new Locations();
    public static void main(String[] args) {
        locations.put(1,new Location(1,"ABJ","400KM"));
        locations.put(2,new Location(2,"LAG","002KM"));
        locations.put(3,new Location(3,"BEN","300KM"));
        locations.put(4,new Location(4,"ENU","245KM"));
        locations.put(5,new Location(5,"CAL","044KM"));
        locations.put(6,new Location(6,"SKT","500KM"));
        /*try(FileWriter locFile = new FileWriter("locations.txt")){
            for (Location location : locations.values()) {
                locFile.write(location.getId() + "," + location.getName() + ", " + location.getDistance() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
       /* FileWriter locFile = null;
        try {
            locFile = new FileWriter("locations.txt");
            for (Location location : locations.values()) {
                locFile.write(location.getId() + "," + location.getName() + ", " + location.getDistance() + "\n");
            }

        }catch (IOException e)
        {
            System.out.println("This is an error");
            e.printStackTrace();
        }finally {
            try {
                if (locFile !=null)
                  locFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }
    static {
        Scanner scanner =null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("locations.txt")));
//            scanner.useDelimiter(",");
            while (scanner.hasNextLine()){
               /* int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String name = scanner.nextLine();
//                scanner.skip(scanner.delimiter());
                String distance = scanner.nextLine();
                System.out.println("Imported loc: " + loc +": "+name);
                System.out.println("Imported loc: " +distance);*/
                String input = scanner.nextLine();
                String [] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String name = data[1];
                String  distance = data[2];

                System.out.println("Imported loc: " + loc +": "+name+": "+distance);

            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
                if (scanner !=null)
                    scanner.close();
        }
    }
}
