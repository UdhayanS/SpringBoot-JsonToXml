package com.example.jsonToXml;

import com.example.jsonToXml.converter.XMLJSONConverterI;
import com.example.jsonToXml.factory.ConverterFactory;

import java.io.File;

public class MainApp {

    public static void main(String[] args) throws Exception {

        if (args.length != 2) {
            System.out.println("Usage: java -jar jsonToXml.jar <input.json> <output.xml>");
            return;
        }

        File inputJson = new File(args[0]);
        File outputXml = new File(args[1]);

        XMLJSONConverterI converter =
                ConverterFactory.createXMLJSONConverter();

        converter.convertJSONtoXML(inputJson, outputXml);

        System.out.println("JSON converted to XML successfully.");
    }
}
