package edu.pja.mas.gonul.masfinal.Controller;

import edu.pja.mas.gonul.masfinal.Model.Aircraft;
import edu.pja.mas.gonul.masfinal.Services.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    @GetMapping("/aircraft")
    public String listAircrafts(Model model) {
        model.addAttribute("aircrafts", aircraftService.getAllAircrafts());
        return "aircraft";
    }

    @PostMapping("/addAircraft")
    public String addAircraft(Aircraft aircraft, RedirectAttributes redirectAttributes) {
        aircraftService.saveAircraft(aircraft);
        redirectAttributes.addFlashAttribute("message", "Aircraft added successfully!");
        return "redirect:/aircraft";
    }

    @PostMapping("/deleteAircraft")
    public String deleteAircraft(@RequestParam("aircraftId") Long aircraftId, RedirectAttributes redirectAttributes) {
        aircraftService.deleteAircraft(aircraftId);
        redirectAttributes.addFlashAttribute("message", "Aircraft deleted successfully!");
        return "redirect:/aircraft";
    }
}

