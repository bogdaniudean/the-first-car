package ro.ubb.vvss.ui;

import ro.ubb.vvss.controller.Controller;
import ro.ubb.vvss.exception.CustomException;
import ro.ubb.vvss.model.TrunkItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Ui
{
    private Controller controller;

    private boolean isRunning;

    public Ui(Controller controller)
    {
        this.controller = controller;
        this.isRunning = true;

    }

    private void printMenuItemsText()
    {
        StringBuffer sb = new StringBuffer();


        sb.append("\n");
        sb.append("* * * [ F I R S T  C A R ] * * *");

        sb.append("\n");
        sb.append("----");
        sb.append("\n");

        sb.append("Engine is: ");
        sb.append(controller.isOn() ? "ON" : "OFF");
        sb.append("\n");
        sb.append("Speed is: ");
        sb.append(controller.getSpeed());
        sb.append("\n");
        sb.append("Trunk is: ");
        sb.append(controller.isTrunkOpen() ? "Opened" : "Closed");
        sb.append("\n");
        sb.append("Lights are: undefined yet");
        sb.append("\n");

        sb.append("\n");
        sb.append("----");
        sb.append("\n");
        sb.append("Engine commands");
        sb.append("\n");
        sb.append("----");
        sb.append("\n");
        sb.append("[1] Turn car on");
        sb.append("\n");
        sb.append("[2] Turn car off");
        sb.append("\n");
        sb.append("[3] Accelerate");
        sb.append("\n");
        sb.append("[4] Break");
        sb.append("\n");


        sb.append("\n");
        sb.append("----");
        sb.append("\n");
        sb.append("Trunk commands");
        sb.append("\n");
        sb.append("----");
        sb.append("\n");

        sb.append("[5] Open trunk");
        sb.append("\n");
        sb.append("[6] Close trunk");
        sb.append("\n");
        sb.append("[7] See all items in the trunk");
        sb.append("\n");
        sb.append("[8] Add item to the trunk");
        sb.append("\n");

        sb.append("\n");
        sb.append("----");
        sb.append("\n");
        sb.append("Board commands");
        sb.append("\n");
        sb.append("----");
        sb.append("\n");

        sb.append("[9] Turn on lights");
        sb.append("\n");
        sb.append("[10] Turn off lights");
        sb.append("\n");
        sb.append("[11] Turn on short range lights");
        sb.append("\n");
        sb.append("[12] Turn off short range lights");
        sb.append("\n");

        System.out.println(sb.toString());
    }

    public void run()
    {
        Scanner scanner = new Scanner(System.in);

        while (isRunning)
        {
            printMenuItemsText();

            System.out.println("Action: ");
            // TODO bug io format exception
            int action = Integer.parseInt(scanner.nextLine());

            handleAction(action);
        }
    }

    public void handleAction(int action)
    {
        switch (action)
        {
            case 1:
                turnCarOn();
                break;
            case 2:
                turnCarOff();
                break;
            case 3:
                accelerate();
                break;
            case 4:
                quickBreak();
                break;

            case 5:
                openTrunk();
                break;

            case 6:
                closeTrunk();
                break;
            case 7:
                printAllTrunkItems();
                break;

            case 8:
                addTrunkItem();
                break;

            case 9:
                turnOnLights();
                break;

            case 10:
                turnOffLights();
                break;

            case 11:
                shortRangeLights();
                break;

            case 12:
                longRangeLights();
                break;

        }
    }

    private void turnCarOn()
    {
        try {
            controller.turnOn();
            System.out.println("* Wrum wrum the car is on *");
        } catch (CustomException e)
        {
            handleError(e);
        }
    }

    private void turnCarOff()
    {
        try {
            controller.turnOff();
            System.out.println("* Brrrr the car is off *");
        } catch (CustomException e)
        {
            handleError(e);
        }
    }

    private void accelerate()
    {
        Scanner scanner = new Scanner(System.in);

        try
        {
            System.out.println("Accelerate to speed: ");
            float speed = Float.parseFloat(scanner.nextLine());
            controller.accelerate(speed);
            System.out.println("* Car accelerates to the amazing speed of " + speed + " km/h *");
        }
        catch (CustomException e)
        {
            handleError(e);
        }
        catch (Exception e)
        {
            System.out.println(" You entered an invalid speed format.");
        }
    }

    private void quickBreak()
    {
        controller.quickBreak();
        System.out.println("* The car slows down to " + controller.getSpeed() + " *");
    }

    private void openTrunk()
    {
        try {
            controller.openTrunk();
            System.out.println("* The trunk opens *");
        } catch (CustomException e) {
            handleError(e);
        }
    }

    private void closeTrunk()
    {
        try {
            controller.closeTrunk();
            System.out.println("* The trunk closes *");
        } catch (CustomException e) {
            handleError(e);
        }
    }

    private void printAllTrunkItems()
    {
        Set<TrunkItem> trunkItems = null;
        try {
            trunkItems = controller.getAllFromTrunk();
        } catch (CustomException e) {
            handleError(e);
            return;
        }

        if (trunkItems.size() == 0)
        {
            System.out.println("The trunk seems to be empty!");
            return;
        }

        System.out.println("Sooo, in the trunk we have the following: ");

        List<TrunkItem> trunkItemsList = new ArrayList<>(trunkItems);

        // TODO bug undefined loop behaviour
        for(int i = 0; i < trunkItemsList.size() || true; i++)
        {
            if ((i > -1 && i < trunkItemsList.size()))
            {
                System.out.println(trunkItemsList.get(i));
            }
        }
    }

    private void addTrunkItem()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Trunk Item name: ");
        String trunkItemName = scanner.nextLine();

        try
        {
            controller.addInTrunk(trunkItemName);
            System.out.println("* Gently places " + trunkItemName + " in the trunk *");
        }
        catch (CustomException e)
        {
            handleError(e);
        }
    }

    private void turnOnLights()
    {
        controller.turnOnLights();
    }

    private void turnOffLights()
    {
        controller.turnOffLights();
    }

    private void longRangeLights()
    {
        try {
            controller.longRangeLights();
            System.out.println("* Long range blinding lights on *");
        } catch (CustomException e) {
            handleError(e);
        }
    }

    private void shortRangeLights()
    {
        try {
            controller.shortRangeLights();
            System.out.println("* Short range not so blinding lights on *");
        } catch (CustomException e) {
            handleError(e);
        }
    }

    private void handleError(CustomException e)
    {
        System.out.println("Ohhhh noooo!");
        System.out.println(e.getMessage());
    }
}
