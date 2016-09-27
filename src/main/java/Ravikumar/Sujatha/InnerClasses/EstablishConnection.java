package Ravikumar.Sujatha.InnerClasses;

/**
 * Created by sujatharavikumar on 9/27/16.
 */
public class EstablishConnection {

    public static void main(String[] args) {

        ConnectionManager connection1 = new ConnectionManager();
        ConnectionManager connection2 = new ConnectionManager();
        ConnectionManager connection3 = new ConnectionManager();
        ConnectionManager connection4 = new ConnectionManager();
        ConnectionManager connection5 = new ConnectionManager();
        ConnectionManager connection6 = new ConnectionManager();


        Connection firstConnection = connection1.getConnection("172.16.254.1", 8080);
        Connection secondConnection = connection2.getConnection("172.45.42.2","TCP",25);
        Connection thirdConnection = connection3.getConnection("172.46.42.2","SMTP",500);
        Connection fourthConnection = connection4.getConnection("172.45.43.2","IP",290);
        Connection fifthConnection = connection5.getConnection("172.45.42.5","FTP",20);
        Connection sixthConnection = connection6.getConnection("172.45.42.5","FTP",20);


        firstConnection.close();
        System.out.println(firstConnection.getProtocol());


    }

}
