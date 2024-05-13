package edu.pja.mas.gonul.masfinal.Controller;

import edu.pja.mas.gonul.masfinal.Services.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    @GetMapping("/aircraft/{id}/maintenance")
    public String viewMaintenance(@PathVariable("id") Long aircraftId, Model model) {
        model.addAttribute("maintenances", maintenanceService.getMaintenanceByAircraftId(aircraftId));
        model.addAttribute("aircraftId", aircraftId);
        return "maintenance";
    }
}
