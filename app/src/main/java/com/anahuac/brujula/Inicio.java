package com.anahuac.brujula;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Inicio extends AppCompatActivity implements SensorEventListener {
    private SensorManager compassSensorManager;
    private ImageView compass;
    private TextView txt_degrees;
    float[] lector_acelerometro;
    float[] lector_magnetic;
    Float eje_referencia;
    Sensor acelerometro;
    Sensor magnetometro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        compassSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        acelerometro = compassSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnetometro = compassSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

    }

    protected void onResume(){
        super.onResume();
        compassSensorManager.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_UI);
        compassSensorManager.registerListener(this, magnetometro, SensorManager.SENSOR_DELAY_UI);

    }

    protected void onPause(){
        super.onPause();
        compassSensorManager.unregisterListener(this);
    }

    private int i=0;
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        compass = (ImageView) findViewById(R.id.image);
        txt_degrees = (TextView) findViewById(R.id.texto);
        txt_degrees.setText(i+"");
        i++;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
