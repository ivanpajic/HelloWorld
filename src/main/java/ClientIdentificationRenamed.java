public class ClientIdentification {
    private String identification;

    public ClientIdentification(String identification) {
        this.identification = identification;
    }


    public String getIdentification() {

// change here on main branch
        return identification;
    }

    // change to push
    public void deleteIden
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

    public int calculateAddition(int a, int b) {
        return a + b;
    }


}