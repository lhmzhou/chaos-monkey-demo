package com.chaos;

import java.util.Scanner;
import com.chaos.functions.Connection;
import com.chaos.functions.RuntimeConfiguration;
import com.chaos.functions.Network;

public class ChaosTester {
    public static void main(String[] args) {
        System.out.println("Enter one of the following commands:");
        System.out.println("1 - Get runtime configurations");
        System.out.println("2 - Set runtime configurations");
        System.out.println("3 - Clear runtime configurations");
        System.out.println("4 - Exit");

        Scanner scanChoice = new Scanner(System.in);

        int entry = -1;

        while (entry < 4){

            System.out.println("Enter \"1\", \"2\", \"3\" or \"4\"");
            if (scanChoice.hasNextInt()) {
                entry = scanChoice.nextInt();
            }

            switch(entry) {

                case 1: // Get runtime configs
                    RuntimeConfig.getRuntimeConfig();
                    break;

                case 2: // Network injection
                    int networkEntry = 0;
                    System.out.println("Enter one of the following commands:");
                    System.out.println("1 - Inject Network Fault");
                    System.out.println("2 - Inject Network Delay");
                    System.out.println("3 - Main Menu");

                    if (scanChoice.hasNextInt()) {
                        networkEntry = scanChoice.nextInt();
                    }

                    if (networkEntry == 1) { // inject network fault
                        int abortPercent = 0;
                        int httpStatus = -1;
                        System.out.println("Enter abort percent: ");
                        if (scanChoice.hasNextInt()) {
                            abortPercent = scanChoice.nextInt();
                        }
                        System.out.println("Enter httpStatus code: ");
                        if (scanChoice.hasNextInt()) {
                            httpStatus = scanChoice.nextInt();
                        }
                        Network.abortRequests(abortPercent, httpStatus);
                    }
                    else if (networkEntry == 2) { // inject delay
                        int delayPercent = 0;
                        int delayDuration = -1;

                        System.out.println("Enter delay percent: ");
                        if (scanChoice.hasNextInt()) {
                            delayPercent = scanChoice.nextInt();
                        }
                        System.out.println("Enter delay duration: ");
                        if (scanChoice.hasNextInt()) {
                            delayDuration = scanChoice.nextInt();
                        }
                        Network.injectHttpDelay(delayPercent, delayDuration);
                    }
                    else { // return to main menu
                        break;
                    }

                    break;

                case 3: // Clear network runtime configs
                    Network.clear();
                    break;
            }

        }
        System.out.println("Exiting...");

    }
}