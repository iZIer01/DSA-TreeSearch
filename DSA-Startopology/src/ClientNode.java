/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joaon
 */
public class ClientNode {

    private String cleintID;
    private ServerNode server;
    
    
    //Greting a constuctor that will create a set up for the Client and Sever
    public void ClientNode(String clientID, ServerNode server){
        this.cleintID = clientID;
        this.server = server;
    }
    
    //Now creationg a function to send message to another client
    public void send(String receiverID, String message){
        server.sendMessage(this.cleintID, receiverID, message);
    }
    
    //Now creating a function to receive the message and diplay it
    public void receive(String senderID, String message){
        System.out.println("Message From: " + senderID + "\n" + message);
    }
    
    //Geting client ID
    public String getClientID(){
        return cleintID;
    }

}
