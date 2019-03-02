package model;

import coppelia.remoteApi;
import viewmodel.ViewModel;

public class VrepController {

    private remoteApi vrep;
    public int clientID=-1;
    private int handleNum[] = {18 ,21 ,24 ,27 ,30 ,32};
    private VrepController()
    {
        vrep = new remoteApi();
        vrep.simxFinish(-1); // just in case, close all opened connections
    }

    private static VrepController instance = null;
    public static VrepController getInstance()
    {
        if (instance == null)
        {
            System.out.println("Program started");
            instance = new VrepController();
            return instance;
        }
        return instance;
    }

    public void connect()
    {
        ViewModel.setStatus("Connecting...");

        clientID = vrep.simxStart("127.0.0.1",19999,true,true,5000,5);
        if (clientID!=-1)
        {
            ViewModel.setStatus("Connected to remote API server");
        }
        else
        {
            ViewModel.setStatus("Failed connecting to remote API server");
        }
    }

    public void disConnect()
    {
        ViewModel.setStatus("Disconnecting...");
        // Now close the connection to V-REP:
        vrep.simxFinish(clientID);
        ViewModel.setStatus("Disconnected");
    }

    public void changeJointPosValue(int jointNum,float value)
    {
        vrep.simxSetJointTargetPosition(clientID,handleNum[jointNum], (float) Math.toRadians(value),vrep.simx_opmode_streaming);
    }
}
