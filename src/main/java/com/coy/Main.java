package com.coy;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Scanner;

//WBA13BJ06MWX31988
public class Main {
    static void main(String[] args) throws JsonProcessingException {
        RequestObject rqst = new RequestObject();
        ParseObject prse = new ParseObject();
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter raw VIN, no extra characters quotes or spaces\n");
        String vin = scnr.nextLine();

        String toParse = rqst.requestAVin(vin);
        prse.parseResponse(toParse);
        scnr.close();
    }
}
