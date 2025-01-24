/**
 * Represents a client with an identification value.
 * This class provides functionalities to get, set, and validate the identification.
 */
/**
 * Represents a client with an identification attribute.
 */
public class Client {
    private String identification;

    public Client(String identification) {
        this.identification = identification;
    }


    public String getIdentification() {


        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public boolean isValidIdentification() {
        System.out.println(identification);
        return identification != null && !identification.isEmpty();
    }

    @Override
    public String toString() {
        return "Client{" + "identification='" + identification + '\'' + '}';
    }



}
