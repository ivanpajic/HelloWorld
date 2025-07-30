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

    // change on BetaBranch
    public boolean isValidIdentification() {
        return identification != null && !identification.isEmpty();
    }

    @Override
    public String toString() {
        return "Client{" + "identification='" + identification + '\'' + '}';
    }
// change



}