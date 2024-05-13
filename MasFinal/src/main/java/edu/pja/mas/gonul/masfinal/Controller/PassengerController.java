package edu.pja.mas.gonul.masfinal.Controller;

import edu.pja.mas.gonul.masfinal.Model.Passenger;
import edu.pja.mas.gonul.masfinal.Model.Ticket;
import edu.pja.mas.gonul.masfinal.Services.PassengerService;
import edu.pja.mas.gonul.masfinal.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PassengerController {

    @Autowired
    private PassengerService passengerService;
    @Autowired
    private TicketService ticketService;

    @GetMapping("/passengers")
    public String listPassengers(Model model) {
        model.addAttribute("passengers", passengerService.listAllPassengers());
        return "passengers";
    }

    @PostMapping("/addPassenger")
    public String addPassenger(Passenger passenger, RedirectAttributes redirectAttributes) {
        passengerService.savePassenger(passenger);
        redirectAttributes.addFlashAttribute("message", "Passenger added successfully!");
        return "redirect:/passengers";
    }

    @PostMapping("/deletePassenger")
    public String deletePassenger(@RequestParam("passengerId") Long passengerId, RedirectAttributes redirectAttributes) {
        passengerService.deletePassenger(passengerId);
        redirectAttributes.addFlashAttribute("message", "Passenger deleted successfully!");
        return "redirect:/passengers";
    }

    
    @GetMapping("/passengerDetails")
    public String showPassengerDetails(@RequestParam("id") Long passengerId, Model model) {
        Passenger passenger = passengerService.getPassengerById(passengerId);
        List<Ticket> tickets = ticketService.getTicketsByPassengerId(passengerId);

        model.addAttribute("passenger", passenger);
        model.addAttribute("tickets", tickets);

        return "passengerDetails";
    }


    }

