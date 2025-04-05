/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joaon
 */
import java.util.HashMap;

public class ServerNode {
    private HashMap<String, ClientNode> clients = new HashMap<>();

    // Adding a new client
    public void registerClient(ClientNode client) {
        clients.put(client.getClientID(), client);
    }

    // Remove a client from the network
    public void removeClient(String clientID) {
        clients.remove(clientID);
    }

    // Take message from one client and send it to another
    public void sendMessage(String senderID, String receiverID, String message) {
        ClientNode receiver = clients.get(receiverID);
        if (receiver != null) {
            receiver.receive(senderID, message);
        } else {
            System.out.println("Client " + receiverID + " are not found.");
        }
    }
}

