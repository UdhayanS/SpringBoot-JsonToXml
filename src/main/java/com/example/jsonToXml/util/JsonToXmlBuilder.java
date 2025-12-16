package com.example.jsonToXml.util;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Iterator;
import java.util.Map;

public class JsonToXmlBuilder {

    private StringBuilder xml = new StringBuilder();

    public String convert(JsonNode node) {
        buildXML(node, null);
        return xml.toString();
    }

    private void buildXML(JsonNode node, String name) {

        if (node.isObject()) {
            xml.append("<object");
            if (name != null) xml.append(" name=\"").append(name).append("\"");
            xml.append(">\n");

            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                buildXML(entry.getValue(), entry.getKey());
            }

            xml.append("</object>\n");
        }

        else if (node.isArray()) {
            xml.append("<array");
            if (name != null) xml.append(" name=\"").append(name).append("\"");
            xml.append(">\n");

            for (JsonNode item : node) {
                buildXML(item, null);
            }

            xml.append("</array>\n");
        }

        else if (node.isTextual()) {
            xml.append("<string");
            if (name != null) xml.append(" name=\"").append(name).append("\"");
            xml.append(">")
                    .append(node.asText())
                    .append("</string>\n");
        }

        else if (node.isNumber()) {
            xml.append("<number");
            if (name != null) xml.append(" name=\"").append(name).append("\"");
            xml.append(">")
                    .append(node.numberValue())
                    .append("</number>\n");
        }

        else if (node.isBoolean()) {
            xml.append("<boolean");
            if (name != null) xml.append(" name=\"").append(name).append("\"");
            xml.append(">")
                    .append(node.asBoolean())
                    .append("</boolean>\n");
        }

        else if (node.isNull()) {
            xml.append("<null");
            if (name != null) xml.append(" name=\"").append(name).append("\"");
            xml.append("/>\n");
        }
    }
}
