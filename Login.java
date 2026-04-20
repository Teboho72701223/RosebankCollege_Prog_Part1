class Login{
    public static boolean loginStatus(String username, String password, String enteredUsername, String enteredPassword) {
        //This will return true and false after checking the username and password
        return enteredUsername.equals(username) && enteredPassword.equals(password);
    }


    public static String loginUser(Scanner input, String username, String password, String firstName, String lastName) {
        //Declare the username entered and password entered 
        String enteredUsername;
        String enteredPassword;

        //Use a loop to check if the user entered the correct username and password
        do {
            //Ask user for there username
            System.out.print("Enter your username: ");
            enteredUsername = input.nextLine();

            //Ask user for the password
            System.out.print("Enter your password: ");
            enteredPassword = input.nextLine();

            // Once the user enters the incorrect details print a message
            if (!loginStatus(username, password, enteredUsername, enteredPassword)) {
                System.out.println("Username or password is incorrect, please try again");
            }

        } while (!loginStatus(username, password, enteredUsername, enteredPassword));

        //Return the string that prints the welcome statment
        return "Welcome " + firstName + " " + lastName + ", it is nice to see you again";
    }
}