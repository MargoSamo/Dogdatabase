package com.mariia.dog;

import java.sql.*;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DogDatabase {

    public static void main(String[] args) {
        // Given
        var dogs = Arrays.asList(
          new Dog(UUID.randomUUID().toString(), ThreadLocalRandom.current().nextInt(1, 20)),
          new Dog(UUID.randomUUID().toString(), ThreadLocalRandom.current().nextInt(1, 20)),
          new Dog(UUID.randomUUID().toString(), ThreadLocalRandom.current().nextInt(1, 20)),
          new Dog(UUID.randomUUID().toString(), ThreadLocalRandom.current().nextInt(1, 20)),
          new Dog(UUID.randomUUID().toString(), ThreadLocalRandom.current().nextInt(1, 20)),
          new Dog(UUID.randomUUID().toString(), ThreadLocalRandom.current().nextInt(1, 20)),
          new Dog(UUID.randomUUID().toString(), ThreadLocalRandom.current().nextInt(1, 20)),
          new Dog(UUID.randomUUID().toString(), ThreadLocalRandom.current().nextInt(1, 20)),
          new Dog(UUID.randomUUID().toString(), ThreadLocalRandom.current().nextInt(1, 20)),
          new Dog(UUID.randomUUID().toString(), ThreadLocalRandom.current().nextInt(1, 20)),
          new Dog(UUID.randomUUID().toString(), ThreadLocalRandom.current().nextInt(1, 20)),
          new Dog(UUID.randomUUID().toString(), ThreadLocalRandom.current().nextInt(1, 20))
        );

        //System.out.println(dogs);

       try{
            String url = "jdbc:mysql://localhost/dogs?allowPublicKeyRetrieval=true&useSSL=false";
            String username = "root";
            String password = "mariSQL66441";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            String sqlCommand = "CREATE TABLE breeds (Id INT PRIMARY KEY AUTO_INCREMENT, BreedName VARCHAR(20), Age INT)";

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
//                statement.executeUpdate(sqlCommand);
                System.out.println("Database has been created!");

                /*Statement statement = conn.createStatement();
                int rows = statement.executeUpdate("INSERT Breeds(BreedName, Age) VALUES ('Collie', 3)," +
                        "('Labrador', 4), ('Miniature schnauzer', 12)");
                System.out.printf("Added %d rows", rows);*/

                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO breeds (BreedName, Age) VALUES (?, ?)");

                for (int i = 0; i < dogs.size(); i++) {
                    Dog dog = dogs.get(i);
                    stmt.setString(1, dog.getBreed().substring(0, 19));
                    stmt.setInt(2, dog.getAge());

                    stmt.addBatch();
                }

                stmt.executeBatch();
            }
        }
        catch(Exception exception){
            System.out.println("Connection failed...");
            exception.printStackTrace();
        }
    }
}
