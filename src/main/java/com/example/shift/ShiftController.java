package com.example.shift;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShiftController {


    private final ShiftRepository repository;

    public ShiftController(ShiftRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/shifts")                      
    public String showShifts(Model model) {
        List<Shift> shifts = repository.findAll(); 
        model.addAttribute("shifts", shifts);  

        return "shifts";    
    }
    
    @GetMapping("/shifts/new")
    public String newShiftForm() {
    	return "shift-form";
    }
    
    @PostMapping("/shifts")
    public String createShift(
    		@RequestParam String date,
    		@RequestParam String name,
    		@RequestParam int startTime,
    		@RequestParam int endTime) {
    	
    	Shift shift = new Shift(date, name, startTime, endTime);
    	repository.save(shift);
    	return "redirect:/shifts";
    	
    }
    
    @PostMapping("/shifts/{id}/delete")
    public String deleteShift(@PathVariable Long id) {
    	repository.deleteById(id);
    	return "redirect:/shifts";
    }
    
    @GetMapping("/shifts/{id}/edit")
    public String editShiftForm(@PathVariable Long id, Model model) {
    	Shift shift = repository.findById(id).orElseThrow();
    	model.addAttribute("shift", shift);
    	return "shift-edit";
    }
    
    @PostMapping("shifts/{id}/edit")
    public String updateShift(
    		@PathVariable Long id,
    		@RequestParam String date,
    		@RequestParam String name,
    		@RequestParam int startTime,
    		@RequestParam int endTime) {
    	
    	Shift shift = repository.findById(id).orElseThrow();
    	shift.setDate(date);
    	shift.setName(name);
    	shift.setStartTime(startTime);
    	shift.setEndTime(endTime);
    	repository.save(shift);
    	
    	return "redirect:/shifts";
    	
    }
    
    
}