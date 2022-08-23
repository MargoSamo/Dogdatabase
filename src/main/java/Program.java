public class Program {

        public static void main(String[] args) {
            //java -classpath mysql-connector-java-8.0.30.jar Program
            //java -cp "mysql-connector-java-8.0.30.jarl." Program.java
            try{
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                System.out.println("Connection succesfull!");
            }
            catch(Exception exception){
                System.out.println("Connection failed...");

                exception.printStackTrace();
            }
        }
    }
