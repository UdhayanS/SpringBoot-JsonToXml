# jsonToXml

A simple Java program to convert JSON files to XML files using recursion.

## 🚀 Features
- Converts JSON objects, arrays, strings, numbers, booleans, and null values to XML.
- Top-level JSON can only be an array or object.
- Recursively handles nested objects and arrays.
- Generates valid XML output.

## 🛠 Prerequisites
- Java JDK 17+
- Maven
- Basic knowledge of terminal/command-line

## 💻 How to Build
Open terminal in project root (`jsonToXml`) and run:

mvn clean package

This will generate the executable JAR at:

target/jsonToXml-0.0.1-SNAPSHOT.jar

## ▶️ How to Run
java -jar target/jsonToXml-0.0.1-SNAPSHOT.jar <input.json> <output.xml>

### Example
java -jar target/jsonToXml-0.0.1-SNAPSHOT.jar input.json output.xml

After running, `output.xml` will contain the XML version of your JSON.

## 📝 Sample Input (`input.json`)
{
  "name": "Udhayan",
  "age": 21,
  "active": true,
  "skills": ["Java", "Spring"],
  "address": null
}

## 📝 Sample Output (`output.xml`)
"<object>
  <string name="name">Udhayan</string>
  <number name="age">21</number>
  <boolean name="active">true</boolean>
  <array name="skills">
    <string>Java</string>
    <string>Spring</string>
  </array>
  <null name="address"/>
</object>"

## 📦 Libraries Used
- Jackson Databind (v2.15.2)

## 🔧 Design Overview
- MainApp → CLI entry point  
- ConverterFactory → Returns XMLJSONConverterImpl instance (Factory Pattern)  
- XMLJSONConverterI → Interface defining the conversion method  
- XMLJSONConverterImpl → Reads JSON file and writes XML file  
- JsonToXmlBuilder → Recursively traverses JSON nodes and builds XML string  

## ✅ Notes
- Only supports valid JSON input.
- Top-level JSON must be an object or array.
- Output XML format follows the assignment specification.

## 📌 Author
Udhayan – Software Engineer / Student
