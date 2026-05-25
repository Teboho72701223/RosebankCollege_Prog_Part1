class Login{
    public static boolean loginStatus(String username, String password, String enteredUsername, String enteredPassword) {
        //This will return true and false after checking the username and password
        return enteredUsername.equals(username) && enteredPassword.equals(password);
    }


    public static boolean loginUser(Scanner input, String username, String password, String firstName, String lastName) {
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
        System.out.println("Welcome " + firstName + " " + lastName + ", it is nice to see you again");
        return true;
    }

    public static void quickChat(Scanner input) {

        System.out.println("\nWelcome to QuickChat");

        System.out.print("How many messages would you like to send: ");
        int numMessages = input.nextInt();
        input.nextLine();

        int messageCount = 0;

        while(true){
            System.out.println("\n--- QuickChat Menu---");
            System.out.println("1. Send Messages");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Quit");

            int option = input.nextInt();
            input.nextLine();

            if(option == 1){

                if(messageCount >= numMessages){
                    System.out.println("You have reached your message limit.");
                    continue;
                }

                System.out.print("Enter recipient number: ");
                String recipient = input.nextLine();
                // Check recipient
                System.out.println(message.checkRecipientCell(recipient));

                System.out.print("Enter your message: ");
                String messageText = input.nextLine();

                Message message = new Message(messageCount, recipient, messageText);

                // Check message length
                if(!message.checkMessageLength()){
                    System.out.println("Please enter a message of less than 250 characters.");
                }

                else{
                    System.out.println("Message sent");
                    System.out.println(message.SentMessage());
                    System.out.println(message.printMessages());
                    messageCount++;
                }
            }

            else if(option == 2){
                System.out.println("Coming Soon.");
            }

            else if(option == 3){
                System.out.println("Total messages sent: " + messageCount);
                System.out.println("Goodbye!");
                break;
            }

            else{
                System.out.println("Invalid option.");
            }
        }
    }
}