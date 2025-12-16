package com.example.jsonToXml.converter;

import com.example.jsonToXml.util.JsonToXmlBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;

public class XMLJSONConverterImpl implements XMLJSONConverterI {

    @Override
    public void convertJSONtoXML(File inputJson, File outputXml) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(inputJson);

        JsonToXmlBuilder builder = new JsonToXmlBuilder();
        String xml = builder.convert(rootNode);

        FileWriter writer = new FileWriter(outputXml);
        writer.write(xml);
        writer.close();
    }
}
