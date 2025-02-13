public class Client {
    private String identification;

    public Client(String identification) {
        this.identification = identification;
    }


    public String getIdentification() {


        return identification;
    }
// change in client
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public boolean isValidIdentification() {
        return identification != null && !identification.isEmpty();
    }

    @Override
    public String toString() {
        return "Client{" + "identification='" + identification + '\'' + '}';
    }



}