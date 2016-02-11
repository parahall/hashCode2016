package com.android.academy;

import java.io.*;

public class Main {

    private static final String FILE_OUTPUT_SUFFIX = "solution.txt";

    public static void main(String[] args) throws IOException {
        for (String arg : args) {
            ProblemInstance instance = initParsing(arg);

            DroneInstruction[] solution = Solver.solve(instance);

            writeSolutionsToFile(arg, solution);
        }

    }

    private static void writeSolutionsToFile(String arg, DroneInstruction[] solution) throws IOException {
        PrintWriter printWriter = new PrintWriter(arg+ FILE_OUTPUT_SUFFIX);
        printWriter.println(solution.length);
        for (DroneInstruction aSolution : solution) {
            printWriter.println(aSolution.toLine());
        }


    }

    private static ProblemInstance initParsing(String arg) {
        ProblemInstance problemInstance = null;

        if (arg != null && arg.length() > 0) {
            try (BufferedReader br = new BufferedReader(new FileReader(arg))) {
                problemInstance = new ProblemInstance();
                parseSimulationParams(problemInstance, br);
                initProductWeights(problemInstance, br);
                parseProductWeights(problemInstance, br);
                parseWarehousesContent(problemInstance, br);
                parseCustomerOrders(problemInstance, br);
            } catch (IOException ignored) {
            }
        }

        return problemInstance;
    }

    private static void parseCustomerOrders(ProblemInstance problemInstance, BufferedReader br) throws IOException {
        String line = br.readLine();
        problemInstance.orders = new Order[Integer.parseInt(line)];
        for (int i = 0; i < problemInstance.orders.length; i++) {
            line = br.readLine();
            String[] location = line.split(" ");
            problemInstance.orders[i] = new Order();
            problemInstance.orders[i].row = Integer.parseInt(location[0]);
            problemInstance.orders[i].col = Integer.parseInt(location[1]);
            line = br.readLine();
            problemInstance.orders[i].orderlines = new int[Integer.parseInt(line)];
            line = br.readLine();
            String[] items = line.split(" ");
            for (int j = 0; j < problemInstance.orders[i].orderlines.length; j++) {
                problemInstance.orders[i].orderlines[j] = Integer.parseInt(items[j]);
            }
        }

    }

    private static void parseWarehousesContent(ProblemInstance problemInstance, BufferedReader br) throws IOException {
        String line = br.readLine();
        problemInstance.warehouses = new Warehouse[Integer.parseInt(line)];
        for (int i = 0; i < problemInstance.warehouses.length; i++) {
            line = br.readLine();
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
