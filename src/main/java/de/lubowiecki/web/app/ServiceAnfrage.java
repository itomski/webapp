package de.lubowiecki.web.app;

public class ServiceAnfrage {

    private String kundenName;
    private String email;
    private String text;

    public ServiceAnfrage() {
    }

    public ServiceAnfrage(String kundenName, String email, String text) {
        this.kundenName = kundenName;
        this.email = email;
        this.text = text;
    }

    public String getKundenName() {
        return kundenName;
    }

    public void setKundenName(String kundenName) {
        this.kundenName = kundenName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
