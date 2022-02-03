package ro.ubb.vvss.model.boardCommands.lights;

public class LightSwitch
{
    private Lights lights;

    public LightSwitch(Lights lights)
    {
        this.lights = lights;
    }

    public void turnOn()
    {
        lights.turnOn();
    }

    public void turnOff()
    {
        lights.turnOff();
    }

    public boolean isOn()
    {
        return lights.isOn();
    }

    public void longRange()
    {
        lights.setRange(LightsRange.LONG);
    }

    public void shortRange()
    {
        lights.setRange(LightsRange.LONG);
    }
}
