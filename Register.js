public class Register{
    //Checks if the username is in the correct format
    public static Boolean checkUsername(String username) {
        //Check if the username has five characters or not
        Boolean numOfChar = username.length() >= 5;

        //Check for the underscore
        Boolean hasUnderscore = false;

        //Looks at each charater to check what is the character at the index
        //Referencing
        for (int index = 0; index < username.length(); index++){
            String eachChar = String.valueOf(username.charAt(index));

            //Check if the underscore is there if there the hasUnderscore changes to true
            if (eachChar.equals("_")){
                hasUnderscore = true;
                break;
            }
        }

        //Return the boolean false or true
        return numOfChar && hasUnderscore;
    }


    public static Boolean checkPasswordComplexity(String password){
        //Cheaks for eight chararters
        Boolean numOfChar = password.length() >= 8;

        //Flag capitalLetter as false
        Boolean capitalLetter = false;

        //Flag capitalLetter as false
        Boolean num = false;

        //Flag capitalLetter as false
        Boolean specialChar = false;

        //User for loop to check all the charaters of the password and change to true if the conditions
        for (int index = 0; index < password.length(); index++) {
            char eachChar = password.charAt(index);
        
            //Set capitalLetter as true if the condition is true
            if (Character.isUpperCase(eachChar)) {
                capitalLetter = true;
            }
            
            //Set num as true if the condition is true
            if (Character.isDigit(eachChar)) {
                num = true;
            }
        
            //Set specialChar as true if the condition is true
            if (!Character.isLetterOrDigit(eachChar)) {
                specialChar = true;
            }
        }

        //Return the boolean false or true
        return numOfChar && capitalLetter && num && specialChar;
    }

    public static Boolean checkCellPhoneNumber(String cellPhoneNum){
        Scanner input = new Scanner(System.in);
        
        //Flagging 
        boolean countryCode = cellPhoneNum.startsWith("+27");
        boolean lengthOfCellNum = cellPhoneNum.length() == 12;

        //Make a loop to make sure the user inputs the correct number
        while (!(countryCode && lengthOfCellNum)){
            System.out.println("Cellphone number incorrectly formatted or does not contain international code");
            
            System.out.println(" ");
            
            System.out.print("Enter your number again: ");
            cellPhoneNum = input.nextLine();
            
            //Checks if these to condition are met or not
            countryCode = cellPhoneNum.startsWith("+27");
            lengthOfCellNum = cellPhoneNum.length() == 12;
            
        }

        //Return the boolean false or true
        return countryCode && lengthOfCellNum;
    }

    public static String registerUser(String userFirstName, String userLastName, String cellPhoneNum, String passwordEntered, String usernameEntered){
        Scanner input = new Scanner(System.in);
        System.out.println("Thank you for using or app, Enter your details");
        
        //Ask the user to enter their first name
        System.out.println(" ");
        System.out.print("Enter your first name: ");
        userFirstName = input.nextLine();
        System.out.println("-------------------------");
        
        //Ask the user to enter their last name
        System.out.println(" ");
        System.out.print("Enter your last name: ");
        userLastName = input.nextLine();
        System.out.println("-------------------------");
    
        //Ask the user to enter their phone number
        System.out.println(" ");
        System.out.println("Please enter your cellphone number, the cellphone number must contain");
        System.out.println("- International country code");
        System.out.println("- Ten character long number");
        System.out.print("Enter your cellphone number: ");
        cellPhoneNum = input.nextLine();
        checkCellPhoneNumber(cellPhoneNum);
        System.out.println("-------------------------");


        //Ask the user to enter the username and the conditions for the username
        System.out.println(" ");
        System.out.println("Please enter a username, the username must have:");
        System.out.println("- Five characters");
        System.out.println("- Underscore");
        System.out.print("Enter your username: ");
        usernameEntered = input.nextLine();
        System.out.println("-------------------------");
        //Use the if statement to check if username mets the formating conditions
        if (!(checkUsername(usernameEntered))) {
            //Use loop till the user enters the correct format
            while (!(checkUsername(usernameEntered))){
                System.out.println(" ");
                System.out.println("-------------------------");
                System.out.println("Username is not correctly ensure that your username cntains an underscore and is no more than five charaters in length");
                System.out.print("Enter your username: ");
                usernameEntered = input.nextLine();

                checkUsername(usernameEntered);
            }
        }
        //if conditions are met display a succes message
        if (checkUsername(usernameEntered)){
            System.out.println("Username successfully captured");
        }

        //Ask the user to enter there password and the formatting of the password
        System.out.println(" ");
        System.out.println("Please enter a password, the password must have:");
        System.out.println("- Eight or more charaters");
        System.out.println("- A capital letter");
        System.out.println("- A number");
        System.out.println("- A special character");
        System.out.print("Enter your password: ");
        passwordEntered = input.nextLine();
        System.out.println("-------------------------");
        
        //Use the if statement to check if password mets the formating conditions
        if (!(checkPasswordComplexity(passwordEntered))){
            //Use loop till the user enters the correct format
            while (!(checkPasswordComplexity(passwordEntered))){
                System.out.println(" ");
                System.out.println("-------------------------");
                System.out.println("Password is not correctly formatted, please ensure that your username contains eight chararters, capital letter, number and special character");
                System.out.print("Enter password again: ");
                passwordEntered = input.nextLine();

                checkPasswordComplexity(passwordEntered);
            }
        }
        //if conditions are met display a succes message
        if (checkPasswordComplexity(passwordEntered)){
            System.out.println("Password successfully captured");
        }
        
        // Combine EVERYTHING into one string
        return userFirstName + "|" + userLastName + "|" + usernameEntered + "|" + passwordEntered;
    }
}