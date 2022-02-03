package ro.ubb.vvss.model;

public class TrunkStatus
{
    private boolean isOpen;

    public TrunkStatus()
    {
        isOpen = false;
    }

    public boolean isOpen()
    {
        return isOpen;
    }

    public void open()
    {
        isOpen = true;
    }

    public void close()
    {
        isOpen = false;
    }

}
