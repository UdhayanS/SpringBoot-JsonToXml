package com.example.jsonToXml.factory;

import com.example.jsonToXml.converter.XMLJSONConverterI;
import com.example.jsonToXml.converter.XMLJSONConverterImpl;

public class ConverterFactory {

    public static XMLJSONConverterI createXMLJSONConverter() {
        return new XMLJSONConverterImpl();
    }
}
