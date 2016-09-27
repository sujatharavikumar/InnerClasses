package Ravikumar.Sujatha.InnerClasses;

/**
 * Created by sujatharavikumar on 9/27/16.
 */
public class ConnectionManager {

    private int connectionLimit;
    public static int connectionCount = 0;

    public ConnectionManager(){
        connectionLimit = 5;
    }


    public Connection getConnection(String ip, int portNumber){
        connectionCount++;
        if (connectionCount>5){
            System.out.println("You cannot have more than 5 connections");
            return null;
        }
        ConnectionManager.ManagedConnection managedObject1 = new ManagedConnection(ip,portNumber);
        String connectionStatus = managedObject1.connect();
        System.out.println(connectionStatus);
        return managedObject1;

    }


    public Connection getConnection(String ip, String protocol, int portNumber){
        connectionCount++;
        if (connectionCount>5){
            connectionCount--;
            System.out.println("You cannot have more than 5 connections");
            return null;
        }
        ConnectionManager.ManagedConnection managedObject2 = new ManagedConnection(ip,protocol,portNumber);
        System.out.println(managedObject2.connect());
        return managedObject2;
    }




    private class ManagedConnection implements Connection{

        public String IP;
        public int portNumber;
        public String protocol;
        boolean isConnectionOpen = false;

        public ManagedConnection(String ip, int port){
            IP = ip;
            portNumber = port;
            protocol = "HTTP";
        }


        public ManagedConnection(String ip, String protocol, int port){
            IP = ip;
            portNumber = port;
            this.protocol = protocol;
        }


        public String getIP() {
            if(isConnectionOpen)
                return IP;

            else
                return "No IP for a closed connection";
        }

        public int getPort() {
            if (isConnectionOpen)
                return portNumber;
            else
                return 0;
        }

        public String getProtocol() {
            if(isConnectionOpen)
                return protocol;
            else
                return "No protocol for a closed connection";
        }

        public String connect() {
            isConnectionOpen = true;
            return "Connection " +connectionCount+ " established";
        }

        public void close() {
            connectionCount--;
            isConnectionOpen = false;
            System.out.println("Connection successfully closed");


        }
    }


}
