package Ravikumar.Sujatha.InnerClasses;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;


/**
 * Created by sujatharavikumar on 9/27/16.
 */
public class ConnectionManagerTest {

    @Test
    public void connectionCountTest(){
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.getConnection("172.16.254.1", 8080);
        Assert.assertEquals(1, ConnectionManager.connectionCount);
    }


    @Test
    public void moreThanFiveConnectionsTest(){
        ConnectionManager connectionManager1 = new ConnectionManager();
        ConnectionManager connectionManager2 = new ConnectionManager();
        ConnectionManager connectionManager3 = new ConnectionManager();
        ConnectionManager connectionManager4 = new ConnectionManager();
        ConnectionManager connectionManager5 = new ConnectionManager();
        ConnectionManager connectionManager6 = new ConnectionManager();

        Connection firstConnection = connectionManager1.getConnection("172.16.254.1", 8080);
        Connection secondConnection = connectionManager2.getConnection("172.45.42.2","TCP",25);
        Connection thirdConnection = connectionManager3.getConnection("172.46.42.2","SMTP",500);
        Connection fourthConnection = connectionManager4.getConnection("172.45.43.2","IP",290);
        Connection fifthConnection = connectionManager5.getConnection("172.45.42.5","FTP",20);
        Connection sixthConnection = connectionManager6.getConnection("172.45.42.5","FTP",20);

        Assert.assertEquals(5, ConnectionManager.connectionCount);
    }


    @Test
    public void getConnectionTest(){
        ConnectionManager connectionManager1 = new ConnectionManager();
        Connection firstConnection = connectionManager1.getConnection("172.16.254.1", 8080);
        String actualIP = firstConnection.getIP();
        String expectedIP = "172.16.254.1";
        int actualPort = firstConnection.getPort();
        int expectedPort = 8080;
        String actualProtocol = firstConnection.getProtocol();
        String expectedProtocol = "HTTP";
        Assert.assertTrue(actualIP.equals(expectedIP));
        Assert.assertTrue(actualPort == expectedPort);
        Assert.assertTrue(actualProtocol.equals(expectedProtocol));

    }

    @Test
    public void getConnectionWithProtocolTest(){
        ConnectionManager connectionManager1 = new ConnectionManager();
        Connection firstConnection = connectionManager1.getConnection("172.46.42.2","SMTP",500);
        String actualIP = firstConnection.getIP();
        String expectedIP = "172.46.42.2";
        int actualPort = firstConnection.getPort();
        int expectedPort = 500;
        String actualProtocol = firstConnection.getProtocol();
        String expectedProtocol = "SMTP";
        Assert.assertTrue(actualIP.equals(expectedIP));
        Assert.assertTrue(actualPort == expectedPort);
        Assert.assertTrue(actualProtocol.equals(expectedProtocol));

    }

    @Test
    public void closeConnectionTest(){
        ConnectionManager connectionManager1 = new ConnectionManager();
        Connection firstConnection = connectionManager1.getConnection("172.46.42.2","SMTP",500);
        firstConnection.close();
        Assert.assertEquals(0, ConnectionManager.connectionCount);
    }

}
