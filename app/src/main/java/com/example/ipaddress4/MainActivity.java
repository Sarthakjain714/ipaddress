package com.example.ipaddress4;

import static androidx.core.content.ContentProviderCompat.requireContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class MainActivity extends AppCompatActivity {
    EditText email, password;
    Button submit;
    TextView loginkrnahai;
    String ip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        submit=findViewById(R.id.submit);
        loginkrnahai=findViewById(R.id.loginkrnahai);
        loginkrnahai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),login.class);
                startActivity(intent);
                finish();
            }
        });
        ip=findip.getip();
        Log.d("ipaddress", "onCreate: "+ip);
        loginkrnahai.setText(ip);

//        WifiManager manager=(WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
//        ip=Formatter.formatIpAddress(manager.getConnectionInfo().getIpAddress());


//        StrictMode.ThreadPolicy gfgPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(gfgPolicy);
//        byte[] ip = new byte[0];
//        try {
//            InetAddress address = InetAddress.getLocalHost();
//            ip = address.getAddress();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        String ipAddress = getIpAddress(ip);
//        System.out.println("IP Address = " + ipAddress);
//
//        try {
//            InetAddress address = InetAddress.getByName("google.com");
//            ip = address.getAddress();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        ipAddress = getIpAddress(ip);
//        System.out.println("IP Address = " + ipAddress);
////        ip=getIpAddress();
//        loginkrnahai.setText(""+ipAddress);

    }

//    private static String getIpAddress(byte[] rawBytes) {
//        int i = 4;
//        StringBuilder ipAddress = new StringBuilder();
//        for (byte raw : rawBytes) {
//            ipAddress.append(raw & 0xFF);
//            if (--i > 0) {
//                ipAddress.append(".");
//            }
//        }
//        return ipAddress.toString();
//    }

}
