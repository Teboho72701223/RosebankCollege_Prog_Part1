import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class Message {

    // Attributes
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;
    private String messageHash;

    // Static variable
    private static int totalMessages = 0;

    // Constructor
    public Message(int messageNumber, String recipient, String message) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;

        // Generate random ID
        Random random = new Random();

        long randomNum =
                1000000000L +
                (long)(random.nextDouble() * 9000000000L);

        this.messageID = String.valueOf(randomNum);

        // Generate hash
        this.messageHash = createMessageHash();
    }

    // Check Message ID
    public Boolean checkMessageID() {

        return messageID.length() <= 10;
    }

    // Check recipient cell number
    public static String checkRecipientCell(String recipientNum) {
        Scanner input = new Scanner(System.in);
        
        //Flagging 
        boolean countryCode = recipientNum.startsWith("+27");
        boolean lengthOfCellNum = recipientNum.length() == 12;

        //Make a loop to make sure the user inputs the correct number
        while (!(countryCode && lengthOfCellNum)){
            System.out.println("Cell phone number incorrectly formatted.");
            
            System.out.println(" ");
            
            System.out.print("Enter your number again: ");
            recipientNum = input.nextLine();
            
            //Checks if these to condition are met or not
            countryCode = recipientNum.startsWith("+27");
            lengthOfCellNum = recipientNum.length() == 12;
            
        }

        //Return a string giving the status of the number
        return "Cell phone number successfully captured.";
    }

    // Create message hash
    public String createMessageHash() {

        String[] words = message.split(" ");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        String firstTwoDigits = messageID.substring(0, 2);

        return (firstTwoDigits + ":" + messageNumber + ":" + firstWord + lastWord).toUpperCase();
    }

    // Send/store/disregard message
    public String SentMessage() {

        Scanner input = new Scanner(System.in);

        System.out.println("\nChoose an option:");
        System.out.println("1. Send Message");
        System.out.println("2. Disregard Message");
        System.out.println("3. Store Message");

        int choice = input.nextInt();
        input.nextLine();

        if (choice == 1){
            totalMessages++;
            return "Message successfully sent";
        }

        else if (choice == 2){
            return "Press 0 to delete message";
        }

        else if (choice == 3){
            storeMessage();
            totalMessages++;
            return "Message successfully stored";
        }

        else {
            return "Invalid option";
        }
    }

    // Print all message details
    public String printMessages() {

        return "\nMessage ID: " + messageID
                + "\nMessage Hash: " + messageHash
                + "\nRecipient: " + recipient
                + "\nMessage: " + message;
    }

    // Return total messages
    public int returnTotalMessages() {

        return totalMessages;
    }

    // Store message in JSON file
    public void storeMessage() {

        try {

            FileWriter file =
                    new FileWriter("messages.json", true);

            file.write("{\n");
            file.write("\"MessageID\": \"" + messageID + "\",\n");
            file.write("\"MessageHash\": \"" + messageHash + "\",\n");
            file.write("\"Recipient\": \"" + recipient + "\",\n");
            file.write("\"Message\": \"" + message + "\"\n");
            file.write("}\n");

            file.close();

        }

        catch (IOException e) {

            System.out.println("Error storing message.");
        }
    }

    // Check message length
    public boolean checkMessageLength() {

        return message.length() <= 250;
    }
}