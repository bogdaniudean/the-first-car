package ro.ubb.vvss.model.boardCommands.lights;

import lombok.SneakyThrows;
import ro.ubb.vvss.exception.CustomException;

public class Lights
{
    public Bulb bulb;

    public Lights(Bulb bulb)
    {
        this.bulb = bulb;
    }

    @SneakyThrows
    public void turnOn()
    {
        throw new CustomException("This was not implemented yet");
    }

    @SneakyThrows
    public void turnOff()
    {
        throw new CustomException("This was not implemented yet");
    }

    @SneakyThrows
    public boolean isOn()
    {
        throw new CustomException("This was not implemented yet");
    }

    @SneakyThrows
    public void setRange(LightsRange lightsRange)
    {
        throw new CustomException("This was not implemented yet");
    }

    @SneakyThrows
    public LightsRange getRange()
    {
        throw new CustomException("This was not implemented yet");
    }



}
