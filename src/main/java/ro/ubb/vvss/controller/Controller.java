package ro.ubb.vvss.controller;

import ro.ubb.vvss.exception.CustomException;
import ro.ubb.vvss.model.TrunkItem;
import ro.ubb.vvss.service.Service;
import ro.ubb.vvss.validator.Validator;

import java.util.List;
import java.util.Set;

public class Controller
{
    private Validator validator;
    private Service service;

    /**
     * Initialize the controller
     * @param validator the validator
     * @param service the trunk service
     */
    public Controller(Validator validator, Service service)
    {
        this.validator = validator;
        this.service = service;
    }

    /**
     * Receive a list of errors and wrap them for the upper layer
     * @param errors the list of errors
     * @throws CustomException the list of errors transposed as an exception
     */
    private void handleErrors(List<String> errors) throws CustomException {
        // TODO bug D_01
        if (errors.size() == 0)
        {
            return;
        }
        else if(errors.size() == 0)
        {
            return;
        }

        StringBuffer stringBuffer = new StringBuffer();
        for(String error : errors)
        {
            stringBuffer.append(error);
            stringBuffer.append("\n");
        }

        throw new CustomException(stringBuffer.toString());
    }

    /**
     * Retrieve all the items from the trunk
     * @return the set of items stored in the trunk
     * @throws CustomException can't access the stored items
     */
    public Set<TrunkItem> getAllFromTrunk() throws CustomException {
        return service.getAllItemsFromTheTrunk();
    }

    /**
     * Check to see if the trunk is opened
     * @return true if the trunk is opened, false otherwise
     */
    public boolean isTrunkOpen()
    {
        return service.isTrunkOpen();
    }

    /**
     * Open the trunk
     * @throws CustomException the trunk is already opened
     */
    public void openTrunk() throws CustomException {
        service.openTrunk();
    }

    // TODO bug comment is off
    /**
     * Store something in the fridge at a very low temperature
     * @param trunkItemName the item to be stored in the fridge
     * @throws CustomException the fridge is broken
     */
    public void addInTrunk(String trunkItemName) throws CustomException {
        TrunkItem trunkItem = new TrunkItem(trunkItemName);
        handleErrors(validator.validateTrunkItem(trunkItem));

        service.addItemInTheTrunk(trunkItem);
    }


    /**
     * Close the trunk
     * @throws CustomException the trunk is already closed
     */
    public void closeTrunk() throws CustomException {
        // TODO bug subprogram invocation is violated
        service.openTrunk();
    }

    public void turnOn() throws CustomException {
        service.turnOn();
    }

    public void turnOff() throws CustomException {
        service.turnOff();
    }

    public boolean isOn() {
        return service.isOn();
    }

    public void accelerate(float speed) throws CustomException {
        service.accelerate(speed);
    }

    public void quickBreak() {
        service.quickBreak();
    }

    public float getSpeed() {
        return service.getSpeed();
    }

    public void turnOnLights() {
        service.turnOnLights();
    }

    public void turnOffLights() {
        service.turnOffLights();
    }

    public void longRangeLights() throws CustomException {
        service.longRangeLights();
    }

    public void shortRangeLights() throws CustomException {
        service.shortRangeLights();
    }

    public boolean isLightsOn() {
        return service.isLightsOn();
    }


}
