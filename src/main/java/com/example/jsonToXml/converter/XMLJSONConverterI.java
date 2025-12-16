package com.example.jsonToXml.converter;

import java.io.File;

public interface XMLJSONConverterI {
    void convertJSONtoXML(File inputJson, File outputXml) throws Exception;
}
