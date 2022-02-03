package ro.ubb.vvss.model;

import ro.ubb.vvss.exception.CustomException;

public class AccelerationStatus
{
    private float speed;

    public AccelerationStatus()
    {
        speed = 0;
    }

    public void setSpeed(float speed) throws CustomException {
        if (speed < -1 || speed > 1001)
        {
            throw new CustomException("Impossible speed! Not even the stone age people can reach " + speed + " km/h!");
        }

        this.speed = speed;
    }

    public float getSpeed()
    {
        return speed;
    }

    public void quickBreak()
    {
        this.speed = 0;
    }

    public boolean isMoving()
    {
        return speed > 0;
    }

}
