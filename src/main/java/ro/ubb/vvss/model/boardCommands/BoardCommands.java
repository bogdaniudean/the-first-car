package ro.ubb.vvss.model.boardCommands;

import lombok.SneakyThrows;
import ro.ubb.vvss.exception.CustomException;
import ro.ubb.vvss.model.boardCommands.lights.LightSwitch;

public class BoardCommands
{
    private LightSwitch lightSwitch;

    public BoardCommands(LightSwitch lightSwitch)
    {
        this.lightSwitch = lightSwitch;
    }

    @SneakyThrows
    public void turnOnLights()
    {
        throw new CustomException("This was not implemented yet");
    }

    @SneakyThrows
    public void turnOffLights()
    {
        throw new CustomException("This was not implemented yet");
    }

    @SneakyThrows
    public boolean isOnLights()
    {
        throw new CustomException("This was not implemented yet");
    }

    @SneakyThrows
    public void longRangeLights()
    {
        throw new CustomException("This was not implemented yet");
    }

    @SneakyThrows
    public void shortRangeLights()
    {
        throw new CustomException("This was not implemented yet");
    }
}
