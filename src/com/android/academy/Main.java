package com.android.academy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args[0] != null && args[0].length() > 0) {
            String input = args[0];
            ProblemInstance problemInstance = new ProblemInstance();
            try (BufferedReader br = new BufferedReader(new FileReader(input))) {
                parseSimulationParams(problemInstance, br);
                initProductWeights(problemInstance, br);
                parseProductWeights(problemInstance, br);
                parseNumberWarehouses(problemInstance, br);
                parseWarehousesContent(problemInstance, br);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private static void parseWarehousesContent(ProblemInstance problemInstance, BufferedReader br) throws IOException {
        for (int i = 0; i < problemInstance.warehouses.length; i++) {
            String line = br.readLine();
            String[] location = line.split(" ");
            problemInstance.warehouses[i] = new Warehouse();
            problemInstance.warehouses[i].row = Integer.parseInt(location[0]);
            problemInstance.warehouses[i].col = Integer.parseInt(location[1]);
            line = br.readLine();
            String[] stock = line.split(" ");
            problemInstance.warehouses[i].availableStock = new int[stock.length];
            for (int j = 0; j < stock.length; j++) {
                problemInstance.warehouses[i].availableStock[j] = Integer.parseInt(stock[j]);
            }
        }
    }

    private static void parseNumberWarehouses(ProblemInstance problemInstance, BufferedReader br) throws IOException {
        String line = br.readLine();
        problemInstance.warehouses = new Warehouse[Integer.parseInt(line)];
    }

    private static void initProductWeights(ProblemInstance problemInstance, BufferedReader br) throws IOException {
        String line = br.readLine();
        problemInstance.productWegihts = new int[Integer.parseInt(line)];
    }

    private static void parseProductWeights(ProblemInstance problemInstance, BufferedReader br) throws IOException {
        String line = br.readLine();
        String[] split;
        split = line.split(" ");
        for (int j = 0; j < split.length; j++) {
            problemInstance.productWegihts[j] = Integer.parseInt(split[j]);
        }
    }

    private static void parseSimulationParams(ProblemInstance problemInstance, BufferedReader br) throws IOException {
        String line = br.readLine();
        String[] split = line.split(" ");
        problemInstance.rows = Integer.parseInt(split[0]);
        problemInstance.cols = Integer.parseInt(split[1]);
        problemInstance.numberOfDrowns = Integer.parseInt(split[2]);
        problemInstance.deadline = Integer.parseInt(split[3]);
        problemInstance.droneMaxLoad = Integer.parseInt(split[4]);
    }
}
