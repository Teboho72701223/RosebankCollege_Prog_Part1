import java.util.Scanner;
public class Main{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Declaration
        int choice;

        //Initialisation
        String userFirstName = "";
        String userLastName = "";
        String storedUsername = "";
        String storedPassword = "";
        String cellPhoneNum = "";
        String passwordEntered = "";
        String usernameEntered = "";

        //Using a do-while loop to ask the user the options that were displayed till the choose the correct option
        do {
            //Ask the user to enter a value depending on the status if the have a account or don't have a account
            System.out.println("\n--- MENU ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("-1. Exit");
            System.out.print("Choose an option: ");

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                // Calling the method "regiserUser" from the class "Regitser" in order for the user to register
                String result = Register.registerUser(userFirstName, userLastName, cellPhoneNum, passwordEntered, usernameEntered);

                // Split returned string in to just first name, last name, username and password
                String[] data = result.split("\\|");

                //Store the values that was entered by the user inside a variable
                userFirstName = data[0];
                userLastName = data[1];
                storedUsername = data[2];
                storedPassword = data[3];
            } 

            else if (choice == 2) {
                // Calling the method "loginUser" from the class "Login" for the user tok login
                String message = Login.loginUser(input, storedUsername, storedPassword, userFirstName, userLastName);
                System.out.println(message);
            } 

            else if (choice == -1) {
                //Display a message once the user has exited the progam
                System.out.println("Goodbye!");
                break
            }

            else {
                //Display a message one the user has entered the incorrect value
                System.out.println("Invalid choice.");
            }

        } while (choice != -1);
    }
}