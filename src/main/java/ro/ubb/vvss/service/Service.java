package ro.ubb.vvss.service;

import ro.ubb.vvss.exception.CustomException;
import ro.ubb.vvss.model.AccelerationStatus;
import ro.ubb.vvss.model.EngineStatus;
import ro.ubb.vvss.model.TrunkItem;
import ro.ubb.vvss.model.TrunkStatus;
import ro.ubb.vvss.model.boardCommands.BoardCommands;
import ro.ubb.vvss.repository.TrunkItemRepository;

import java.util.Set;

public class Service
{
    private EngineStatus engineStatus;
    private AccelerationStatus accelerationStatus;
    private TrunkStatus trunkStatus;
    private TrunkItemRepository trunkItemRepository;
    private BoardCommands boardCommands;

    public Service(EngineStatus engineStatus,
                   AccelerationStatus accelerationStatus,
                   TrunkStatus trunkStatus,
                   TrunkItemRepository trunkItemRepository,
                   BoardCommands boardCommands)
    {
        this.engineStatus = engineStatus;
        this.accelerationStatus = accelerationStatus;
        this.trunkStatus = trunkStatus;

        this.trunkItemRepository = trunkItemRepository;

        this.boardCommands = boardCommands;
    }

    // TODO bug confusion in the use of parameters
    public void addItemInTheTrunk(TrunkItem something) throws CustomException {
        if (!trunkStatus.isOpen())
        {
            throw new CustomException("Lol, we can't put anything in the trunk if it's closed!");
        }
        if (accelerationStatus.isMoving())
        {
            throw new CustomException("Lol, we can't put anything in the trunk if the car is moving!");
        }
        trunkItemRepository.persist(something);
    }

    public Set<TrunkItem> getAllItemsFromTheTrunk() throws CustomException {
        if (!trunkStatus.isOpen())
        {
            throw new CustomException("Hmmm.. we can't look in the trunk if it's, wait for it, CLODED!");
        }
        if (accelerationStatus.isMoving())
        {
            throw new CustomException("Lol, we can't get anything in the trunk while the car is moving!");
        }
        return trunkItemRepository.get();
    }

    public boolean isTrunkOpen()
    {
        return trunkStatus.isOpen();
    }

    public void openTrunk() throws CustomException {
        if (trunkStatus.isOpen())
        {
            throw new CustomException("The trunk is already opened!");
        }
        if (accelerationStatus.isMoving())
        {
            throw new CustomException("Lol, we can't open the trunk if the car is moving!");
        }

        trunkStatus.open();
    }

    public void closeTrunk() throws CustomException {
        if (!trunkStatus.isOpen())
        {
            throw new CustomException("The trunk is already closed!");
        }
        if (accelerationStatus.isMoving())
        {
            throw new CustomException("Lol, we can't close the trunk if the car is moving!");
        }

        trunkStatus.close();
    }

    public void accelerate(float speed) throws CustomException {
        if (!engineStatus.isOn())
        {
            throw new CustomException("Hmmm.. we are pressing the gas pedal but the car isn't moving! Is the engine on?");
        }

        accelerationStatus.setSpeed(speed);
    }

    public void quickBreak()
    {
        accelerationStatus.quickBreak();
    }

    public float getSpeed()
    {
        return accelerationStatus.getSpeed();
    }

    public void turnOn() throws CustomException {
        if (engineStatus.isOn())
        {
            throw new CustomException("Hmmm.. but the car is already on!");
        }

        engineStatus.turnOn();
    }

    public void turnOff() throws CustomException {
        if (!engineStatus.isOn())
        {
            throw new CustomException("Hmmm.. but the car is already off!");
        }

        if (accelerationStatus.isMoving())
        {
            throw new CustomException("Hmmm.. bad idea to stop the engine while the car is still moving!");
        }

        engineStatus.turnOff();
    }

    public boolean isOn()
    {
        return engineStatus.isOn();
    }

    public void turnOnLights()
    {
        boardCommands.turnOnLights();
    }

    public void turnOffLights()
    {
        boardCommands.turnOffLights();
    }

    public void longRangeLights() throws CustomException {
        if (!boardCommands.isOnLights())
        {
            throw new CustomException("The lights need to be on in order to set them to long range!");
        }
        boardCommands.longRangeLights();
    }

    public void shortRangeLights() throws CustomException {
        if (!boardCommands.isOnLights())
        {
            throw new CustomException("The lights need to be on in order to set them to short range!");
        }
        boardCommands.shortRangeLights();
    }

    public boolean isLightsOn()
    {
        return boardCommands.isOnLights();
    }

}
