package com.portfolio2;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static ArrayList<port> ports;

    static void scanFile() throws Exception {
        Scanner sc = new Scanner(new File("./src/com/portfolio2/transfer.txt"));
        ports = new ArrayList<port>();
        int nb = 1;
        String port1Name = null;
        String port2Name = null;

        while (sc.hasNextLine()) {
            String nextLine = sc.nextLine();
            if (nb == 1)
                port1Name = nextLine;
            else if (nb == 2)
                port2Name = nextLine;
            else {
                int TEU = Integer.parseInt(nextLine);
                ports.add(new port(port1Name, TEU));
                ports.add(new port(port2Name, -TEU));
                nb = 0;
            }
            nb++;
        }
        sc.close();
    }

    static void reverseFlow() {
        int price = 0;

        for (int i = 0; i < ports.size(); i++)
            price += Math.abs(ports.get(i).TEU) * 100;
        System.out.println("Reverse flow cost is equal to : " + price);
    }

    static void mergePorts() {
        for (int i = 0; i < ports.size(); i++) {
            for (int j = i + 1; j < ports.size(); j++) {
                if (ports.get(i).name.equals(ports.get(j).name)) {
                    ports.get(i).TEU += ports.get(j).TEU;
                    ports.remove(j);
                    j--;
                }
            }
        }
    }

    static void minimumCost() {
        int price = 0;

        for (int i = 0; i < ports.size(); i++) {
            for (int j = 0; j < ports.size(); j++) {
                if (ports.get(i).TEU > 0 && i != j) {
                    int diff = Math.abs(ports.get(j).TEU) - ports.get(i).TEU;
                    if (diff >= 0) {
                        price += ports.get(i).TEU * 100;
                        ports.get(j).TEU += ports.get(i).TEU;
                        ports.get(i).TEU = 0;
                    } else {
                        price += Math.abs(ports.get(j).TEU) * 100;
                        ports.get(i).TEU -= Math.abs(ports.get(j).TEU);
                        ports.get(j).TEU = 0;
                    }
                }
            }
        }
        System.out.println("Minimum cost is equal to : " + price);
    }

    public static void main(String[] args) throws Exception {
        // Scan file with all ports information
        // Creates an arrayList of each ports value for each transaction
        scanFile();

        // Reverse flow method
        reverseFlow();

        // Merge all transaction for all ports together
        mergePorts();
        // Minimized cost method
        minimumCost();

        // Print results (for testing purpose only)
        //for (int i = 0; i < ports.size(); i++)
        //    System.out.println(ports.get(i).name + " : " + ports.get(i).TEU);
    }
}
