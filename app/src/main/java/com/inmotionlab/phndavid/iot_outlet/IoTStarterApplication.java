package com.inmotionlab.phndavid.iot_outlet;

import android.app.Application;
import android.content.Context;
import android.provider.Settings;

import com.inmotionlab.phndavid.iot_outlet.iot.IoTClient;
import com.inmotionlab.phndavid.iot_outlet.utils.Constants;
import com.inmotionlab.phndavid.iot_outlet.utils.MyIoTActionListener;
import com.inmotionlab.phndavid.iot_outlet.utils.MyIoTCallbacks;

import org.eclipse.paho.client.mqttv3.MqttException;

import javax.net.SocketFactory;

/**
 * Created by phndavid on 28/04/16.
 */
public class IoTStarterApplication extends Application {
    private IoTClient iotClient;
    Context context;
    private MyIoTCallbacks myIoTCallbacks;
    // Values needed for connecting to IoT
    private Constants.ConnectionType connectionType;
    // Application state variables
    private boolean connected = false;

    /**
     * Called when the application is created. Initializes the application.
     */
    @Override
    public void onCreate() {
        super.onCreate();
        myIoTCallbacks = MyIoTCallbacks.getInstance(this);
        context = getApplicationContext();
        iotClient = IoTClient.getInstance(context,"o79sac","device01","Simulacion","qwert123");
        MyIoTActionListener listener = new MyIoTActionListener(context, Constants.ActionStateStatus.CONNECTING);
        SocketFactory factory = null;
        try {
            iotClient.connectDevice(myIoTCallbacks,listener,factory);
        }catch (MqttException e){
            System.out.print(e);
        }
    }
    // Getters and Setters
    public void setConnectionType(Constants.ConnectionType type) {
        this.connectionType = type;
    }
    public Constants.ConnectionType getConnectionType() {
        return this.connectionType;
    }
    public boolean isConnected() {
        return connected;
    }
    public void setConnected(boolean connected) {
        this.connected = connected;
    }
    public MyIoTCallbacks getMyIoTCallbacks() {
        return myIoTCallbacks;
    }
}
