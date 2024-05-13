package edu.pja.mas.gonul.masfinal.Controller;

import edu.pja.mas.gonul.masfinal.Model.Flight;
import edu.pja.mas.gonul.masfinal.Model.InternationalFlight;
import edu.pja.mas.gonul.masfinal.Model.LocalFlight;
import edu.pja.mas.gonul.masfinal.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/flights")
    public String listFlights(Model model) {
        List<Flight> flights = flightService.getAllFlights();
        model.addAttribute("flights", flights);
        return "flights";
    }

    @PostMapping("/addFlights")
    public String addFlight(@RequestParam String flightType,
                            @RequestParam String origin,
                            @RequestParam String destination,
                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureTime,
                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime arrivalTime,
                            RedirectAttributes redirectAttributes) {
        Flight flight;

        if ("InternationalFlight".equals(flightType)) {
            flight = new InternationalFlight();
        } else {
            flight = new LocalFlight();
        }

        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setDepartureTime(departureTime);
        flight.setArrivalTime(arrivalTime);

        flightService.saveFlight(flight);
        redirectAttributes.addFlashAttribute("message", "Flight added successfully!");
        return "redirect:/flights";
    }

    @PostMapping("/deleteFlights")
    public String deleteFlight(@RequestParam("flightId") Long flightId, RedirectAttributes redirectAttributes) {
        flightService.deleteFlight(flightId);
        redirectAttributes.addFlashAttribute("message", "Flight deleted successfully!");
        return "redirect:/flights";
    }


}
