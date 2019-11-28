/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaOSC;

import com.illposed.osc.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

class Sender {

  public static void main(String[] args) throws UnknownHostException, SocketException, java.io.IOException, InterruptedException {
  
    InetAddress remoteIP = InetAddress.getLocalHost();
    int remotePort = 8000;
    OSCPortOut sender = new OSCPortOut(remoteIP, remotePort);
    
    String address1 = "/a";
    String address2 = "/b";
    String address3 = "/c";
    
    ArrayList<Object> values1 = new ArrayList<Object>();
    values1.add(new Integer(3));
    values1.add("Hello World");
    
    ArrayList<Object> values2 = new ArrayList<Object>();
    values2.add(new Integer(3));
    values2.add(new Float(3.14));
    values2.add("Hello Sender!");
    
    OSCMessage message1 = new OSCMessage(address1, values1);
    OSCMessage message2 = new OSCMessage(address2, values2);
    OSCMessage message3 = new OSCMessage(address3, values1);
   
    sender.send(message1);
    sender.send(message2);
    sender.send(message3);
  }
}