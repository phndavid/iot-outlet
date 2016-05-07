package com.inmotionlab.phndavid.iot_outlet.activities;

import android.content.Context;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.IccOpenLogicalChannelResponse;
import android.widget.TextView;

import com.inmotionlab.phndavid.iot_outlet.IoTStarterApplication;
import com.inmotionlab.phndavid.iot_outlet.R;
import com.inmotionlab.phndavid.iot_outlet.iot.IoTClient;
import com.inmotionlab.phndavid.iot_outlet.utils.Constants;
import com.inmotionlab.phndavid.iot_outlet.utils.MyIoTActionListener;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class IoTActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_io_t);
        textView = (TextView) findViewById(R.id.status_connect);
        IoTStarterApplication app = (IoTStarterApplication) getApplication();
        boolean status = app.isConnected();
        textView.setText("Estado de la conexión..."+status);
     }
    @Override
    protected void onResume() {
        super.onResume();



    }
}
