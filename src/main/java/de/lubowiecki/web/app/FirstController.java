package de.lubowiecki.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller // Macht die Klasse über den Webserver erreichbar
public class FirstController {

    private List<ServiceAnfrage> anfragen = new ArrayList<>();

    @RequestMapping("") // Diese Methode ist unter http://localhost/ erreichbar
    public String index(Model ui) { // Name der Methode ist frei wählbar
        // Model ist ein Transportobjekt, das Daten aus der Methode an das HTML-Template übergibt
        ui.addAttribute("headline", "Startseite");
        ui.addAttribute("content", "Herzlich Willkommen bei uns auf der Seite.");
        return "start"; // Name der HTML-Vorlage (resources/templates/start.html)
    }

    // Verarbeitet alle HTTP-Methoden (GET, POST, HEAD etc.)
    @RequestMapping("/service") // Diese Methode ist unter http://localhost/service erreichbar
    public String service(Model ui) {
        ui.addAttribute("headline", "Stellen Sie hier ihre Anfrage");
        ui.addAttribute("anfragen", anfragen); // Liste wird an das HTML-Template übermittelt
        return "form";
    }

    // Verarbeitet POST-HTTP-Methode
    @PostMapping("/service/save")
    public String save(String name, String email, String text) { // Namen der Formularfelder
        anfragen.add(new ServiceAnfrage(name, email, text));
        return "redirect:/service"; // Umleitung auf /service
    }
    @RequestMapping("/about") // Diese Methode ist unter http://localhost/about erreichbar
    public String about(Model ui) {
        ui.addAttribute("headline", "Bisschen was über uns...");
        ui.addAttribute("content", "Wir sind die Guten.");
        return "start";
    }

    @RequestMapping("/contact") // Diese Methode ist unter http://localhost/contact erreichbar
    public String contact(Model ui) {
        ui.addAttribute("headline", "So erreichen Sie uns");
        ui.addAttribute("content", "Schreiben Sie uns einfach eine E-Mail...");
        return "start";
    }
}
