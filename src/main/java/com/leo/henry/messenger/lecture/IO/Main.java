package com.leo.henry.messenger.lecture.IO;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Locations locations = new Locations();
    private static Map<Integer,IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;
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
        FileWriter locFile = null;
        try {
            locFile = new FileWriter("locations.txt");
            for (Location location : locations.values()) {
                locFile.write(location.getId() + ": " + location.getName() + " " + location.getDistance() + "\n");
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
        }

        /**
         * Using DataOutputStream to write to a file*/
        /*try (DataOutputStream locFile1 =new DataOutputStream(new BufferedOutputStream((new FileOutputStream("locations.dat"))))){

            System.out.println("Writing location ");
            for (Location location : locations.values())
            {
                locFile1.writeInt(location.getId());
                locFile1.writeUTF(location.getName()+", "+location.getDistance());
                System.out.println(location.getId()+": "+location.getName()+" "+location.getDistance());
            }
        }catch (IOException e)
        {

        }*/

        /**
         * Using ObjectOutputStream to write to a file*/
        /*try (ObjectOutputStream locFile1 =new ObjectOutputStream(new BufferedOutputStream((new FileOutputStream("locations.dat"))))){

            System.out.println("Writing location ");
            for (Location location : locations.values())
            {
                locFile1.writeObject(location);
//                System.out.println(location.getId()+": "+location.getName()+" "+location.getDistance());
            }
        }catch (IOException e)
        {

        }*/
        try (RandomAccessFile rao = new RandomAccessFile("locations_rand.dat","rwd")){
            rao.writeInt(locations.size());
            int indexSize = locations.size() * 3 * Integer.BYTES;
            int locationsStart = (int)(indexSize + rao.getFilePointer() + Integer.BYTES);
            rao.writeInt(locationsStart);
            long indexStart = rao.getFilePointer();
            int startPointer = locationsStart;
            rao.seek(startPointer);
            for (Location location : locations.values())
            {
                rao.writeInt(location.getId());
                rao.writeUTF(location.getName());
                rao.writeUTF(location.getDistance());

                IndexRecord record = new IndexRecord(startPointer,(int)(rao.getFilePointer() - startPointer));
                index.put(location.getId(),record);
                startPointer = (int) rao.getFilePointer();
            }
            rao.seek(startPointer);
            for (Integer locationId : index.keySet()){
                rao.writeInt(locationId);
                rao.writeInt(index.get(locationId).getStartByte());
                rao.writeInt(index.get(locationId).getLength());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * This block loads the file from the disc
     * */
    static {
        /**
         * Using Scannner class to load file
         * */
       /* Scanner scanner =null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("locations.txt")));
//            scanner.useDelimiter(",");
            System.out.println("Locations read from file");
            while (scanner.hasNextLine()){
                *//**
                 * Using delimiter to separate files*//*
               *//* int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String name = scanner.nextLine();
//                scanner.skip(scanner.delimiter());
                String distance = scanner.nextLine();
                System.out.println("Imported loc: " + loc +": "+name);
                System.out.println("Imported loc: " +distance);*//*
                *//**
                 * Using split to separate files*//*
                String input = scanner.nextLine();
                String [] data = input.split(": ");
                int loc = Integer.parseInt(data[0]);
                String name = data[1];
//                String  distance = data[2];

                System.out.println(loc +": "+name);

            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
                if (scanner !=null)
                    scanner.close();
        }*/

        /**
         * Using ObjectInputStream to load file
         * */
       /* try(ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))){
            boolean eof = false;
            System.out.println("Read locations using ObjectInputStream ");
            while (!eof)
            {
                try {
                    Location location = (Location) locFile.readObject();
                    System.out.println( location.getId() + ": " + " " + location.getName() + " " + location.getDistance());
                    locations.put(location.getId(), location);
                }catch (ClassNotFoundException e) {
                    eof = true;
                    e.printStackTrace();
                }
            }
        }catch (IOException e)
        {

        }*/
       /**
        * Reading data from file Using RandomAccessFile
        * */
       try{
           ra = new RandomAccessFile("locations_rand.dat","rwd");
           int numLocations = ra.readInt();
           int locationStartPoint = ra.readInt();
           while (ra.getFilePointer() < locationStartPoint){
               int locationId =ra.readInt();
               int locationStart =ra.readInt();
               int locationLength =ra.readInt();

               IndexRecord record = new IndexRecord(locationStart,locationLength);
               index.put(locationId,record);
           }
       }catch (IOException e){
           System.out.println("IOExceptions ");
       }
    }
}
