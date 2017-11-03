package CommandLineInterface;
import java.util.*;

public class CommandLineInterface
{
    private String mainMenuString;

    public CommandLineInterface(String mainMenuPrompt)
    {
        this.mainMenuString = mainMenuPrompt;
    }

    public int getMainMenuNumber()
    /*
        This method prints the menu and
        waits until the user enters a non-zero integer.
    */
    {
        int numericAnswer = 0;
        while(numericAnswer == 0)
        {
            numericAnswer = getInt(this.mainMenuString);
            if (numericAnswer == 0)
            {
                System.out.format("%s\n", "PROG: Please try again.");
            }
        }
        return numericAnswer;
    }

    public static String getLine(String prompt)
    {
        String stringAnswer = "";
        Scanner in = primingInput(prompt);
        stringAnswer = in.nextLine();
        return stringAnswer;
    }

    public static float getFloat(String prompt)
    {
        float floatAnswer = 0;
        Scanner in = primingInput(prompt);
        floatAnswer = in.nextFloat();
        return floatAnswer;
    }

    public static int getInt(String prompt)
    {
        int intAnswer = 0;
        Scanner in = primingInput(prompt);
        try
        {
            intAnswer = in.nextInt();
        }
        catch (java.util.InputMismatchException e)
        {
            System.out.format("%s\n", "ERROR: Invalid int value.");
            intAnswer = 0;
        }
        return intAnswer;
    }

    private static Scanner primingInput(String prompt)
    {
        Scanner in = new Scanner(System.in);
        System.out.format("%s\n", prompt);
        System.out.format(">?:");
        return in;
    }
}
