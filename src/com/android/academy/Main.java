package com.android.academy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if(args[0]!=null && args[0].length()>0) {
            String input = args[0];
            ProblemInstance problemInstance = new ProblemInstance();
            try (BufferedReader br = new BufferedReader(new FileReader(input))) {
                String line;
                for (int i = 0; (line = br.readLine()) != null ; i++) {
                    if(i==0){
                        String[] split = line.split(" ");
                        parseSimulationParams(problemInstance, split);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private static void parseSimulationParams(ProblemInstance problemInstance, String[] split) {
        problemInstance.rows = Integer.parseInt(split[0]);
        problemInstance.cols = Integer.parseInt(split[1]);
        problemInstance.numberOfDrowns = Integer.parseInt(split[2]);
        problemInstance.deadline = Integer.parseInt(split[3]);
        problemInstance.droneMaxLoad = Integer.parseInt(split[4]);
    }
}
