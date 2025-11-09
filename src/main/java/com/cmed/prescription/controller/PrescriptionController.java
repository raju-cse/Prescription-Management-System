package com.cmed.prescription.controller;

import com.cmed.prescription.model.Prescription;
import com.cmed.prescription.service.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class PrescriptionController {

    private final PrescriptionService service;

    public PrescriptionController(PrescriptionService service) {
        this.service = service;
    }

    @GetMapping({"/","/prescriptions"})
    public String list(@RequestParam(value = "start", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                       @RequestParam(value = "end", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end,
                       Model model) {
        if (start == null || end == null) {
            YearMonth ym = YearMonth.now();
            start = ym.atDay(1);
            end = ym.atEndOfMonth();
        }
        List<Prescription> list = service.listBetween(start, end);
        model.addAttribute("prescriptions", list);
        model.addAttribute("start", start);
        model.addAttribute("end", end);
        return "list";
    }

    @GetMapping("/prescriptions/new")
    public String createForm(Model model) {
        model.addAttribute("prescription", new Prescription());
        return "form";
    }

    @PostMapping("/prescriptions")
    public String save(@Valid @ModelAttribute("prescription") Prescription prescription, BindingResult br, Model model) {
        if (br.hasErrors()) {
            return "form";
        }
        service.save(prescription);
        return "redirect:/prescriptions";
    }

    @GetMapping("/prescriptions/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Prescription p = service.findById(id);
        model.addAttribute("prescription", p);
        return "form";
    }

    @PostMapping("/prescriptions/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/prescriptions";
    }

    // REST API
    @GetMapping("/api/v1/prescription")
    @ResponseBody
    public List<Prescription> apiList() {
        return service.findAll();
    }

    // Report page
    @GetMapping("/report")
    public String report(@RequestParam(value = "start", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                         @RequestParam(value = "end", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end,
                         Model model) {
        if (start == null || end == null) {
            YearMonth ym = YearMonth.now();
            start = ym.atDay(1);
            end = ym.atEndOfMonth();
        }
        List<Object[]> counts = service.dayWiseCount(start, end);
        // convert to map[string,int] for template
        List<Map<String,Object>> data = counts.stream().map(o -> {
            Map<String,Object> m = new HashMap<>();
            m.put("date", o[0].toString());
            m.put("count", ((Number)o[1]).intValue());
            return m;
        }).collect(Collectors.toList());
        model.addAttribute("data", data);
        model.addAttribute("start", start);
        model.addAttribute("end", end);
        return "report";
    }

    // Page to consume external API
    @GetMapping("/external-api")
    public String externalApiPage() {
        return "external";
    }
}
