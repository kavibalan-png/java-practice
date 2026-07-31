package com.lifeline.bbms.controller;

import com.lifeline.bbms.entity.Donor;
import com.lifeline.bbms.service.DonorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donors")
@RequiredArgsConstructor
public class DonorController {

    private final DonorService donorService;

    @GetMapping
    public List<Donor> all(@RequestParam(required = false) String name,
                            @RequestParam(required = false) String bloodGroup) {
        return (name != null || bloodGroup != null) ? donorService.search(name, bloodGroup) : donorService.findAll();
    }

    @GetMapping("/{id}")
    public Donor get(@PathVariable Long id) { return donorService.findById(id); }

    @PostMapping
    public Donor create(@RequestBody Donor donor) { return donorService.register(donor); }

    @PutMapping("/{id}")
    public Donor update(@PathVariable Long id, @RequestBody Donor donor) { return donorService.update(id, donor); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { donorService.delete(id); }
}
