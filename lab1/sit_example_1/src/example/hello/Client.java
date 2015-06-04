/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.hello;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        helloStub(args);
        //houseStub(args);
       (new Scanner(System.in)).nextByte();
    }
    
    public static void helloStub(String[] args)
    {
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Hello stub = (Hello) registry.lookup("Hello");
            String response = stub.sayHello();
            System.out.println("response: " + response);
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
    public static void houseStub(String[] args)
    {
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            House stub = (House) registry.lookup("house");
            stub.setFilled(0, 0);
            //stub.setFilled(1, 1);
            stub.setFilled(2, 2);
            String response = stub.getField();
            System.out.println("response: \n" + response);
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
