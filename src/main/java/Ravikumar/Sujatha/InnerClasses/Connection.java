package Ravikumar.Sujatha.InnerClasses;

/**
 * Created by sujatharavikumar on 9/27/16.
 */
public interface Connection {

    String getIP();
    int getPort();
    String getProtocol();
    String connect();
    void close();

}
