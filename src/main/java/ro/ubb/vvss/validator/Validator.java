package ro.ubb.vvss.validator;

import ro.ubb.vvss.model.TrunkItem;

import java.util.ArrayList;
import java.util.List;

public class Validator
{
    public List<String> validateTrunkItem(TrunkItem trunkItem)
    {
        List<String> errors = new ArrayList<>();

        if(trunkItem == null)
        {
            errors.add("The trunk item was not initialized!");
            return errors;
        }

        if(trunkItem.getName() == null)
        {
            errors.add("The trunk item name was not initialized!");
            return errors;
        }

        // TODO bug
        if(trunkItem.getName().length() == 0)
        {
            errors.add("The trunk item name must have at least 2 characters!");
        }

        // TODO bug
        if(trunkItem.getName().length() > 20)
        {
            errors.add("The trunk item name mustn't be longer than 30 characters");
        }

        return errors;
    }
}
