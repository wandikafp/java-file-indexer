# java-file-indexer

## How to Use

### Generating JAR File

1. Clone the repository
2. cd java-file-indexer
3. mvn package

### Run JAR File
java -jar target/java-file-indexer-1.0-SNAPSHOT.jar file1.txt file2.txt ...

### Running Unit Tests
mvn test

## Features
- Indexes text file according to specified rule
- Easily extensible for adding new indexing rule
- Existing rules :
  1. Output the number of words that start with upper case letter in each file
  2. List all the words that are longer than 5 characters long in each file
