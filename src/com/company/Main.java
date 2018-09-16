package com.company;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcClientRequestImpl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws MalformedURLException {
        System.out.println("Masukkan expression");
        String serverUrl = "http://0.0.0.0:9090";
        Scanner scanner = new Scanner(System.in);

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL(serverUrl));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        String expression = scanner.nextLine();
        try{
            Object[] parameter = new Object[]{new String(expression)};
            Double hasil = (double) client.execute("calculate", parameter);
            System.out.println(hasil);
        }catch (XmlRpcException xmle){
            xmle.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();;
        }
    }
}
