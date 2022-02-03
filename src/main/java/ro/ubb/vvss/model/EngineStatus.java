package ro.ubb.vvss.model;

public class EngineStatus
{
    private boolean isOn;

    public EngineStatus()
    {
        isOn = false;
    }

    public boolean isOn()
    {
        return isOn;
    }

    public void turnOn()
    {
        isOn = true;
    }

    public void turnOff()
    {
        isOn = false;
    }

}
