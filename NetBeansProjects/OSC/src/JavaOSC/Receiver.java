/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaOSC;

import com.illposed.osc.*;

class Receiver {

  public static void main(String[] args) throws java.net.SocketException {
    int receiverPort = 8000;
    OSCPortIn receiver = new OSCPortIn(receiverPort);
    
    OSCListener handler1 = new OSCListener() {
      public void acceptMessage(java.util.Date time, OSCMessage message) {
        System.out.println("Handler1 called with address " + message.getAddress());
      }
    };
    
    // A second message handler
    OSCListener handler2 = new OSCListener() {
      public void acceptMessage(java.util.Date time, OSCMessage message) {
        System.out.println("Handler2 called with address  " + message.getAddress());
      }
    };
    
    receiver.addListener("/a", handler1);
    receiver.addListener("/b", handler1);
    receiver.addListener("/c", handler2);
    
    System.out.println("Server is listening on port " + receiverPort + "...");
    receiver.startListening();
  }
}