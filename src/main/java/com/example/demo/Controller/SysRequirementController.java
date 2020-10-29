package com.example.demo.Controller;

import com.example.demo.Model.SysRequirement;
import com.example.demo.Repository.SysRequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sysrequirement")
public class SysRequirementController {

    @Autowired
    SysRequirementRepository sysRequirementRepository;

    @GetMapping("")
    public ResponseEntity<List<SysRequirement>> fetchAll() {
        List<SysRequirement> sysRequirements = sysRequirementRepository.findAll();

        if(sysRequirements.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(sysRequirements, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<SysRequirement> createSysRequirement(@RequestBody SysRequirement sysRequirement){
        try {
            SysRequirement _sysRequirement = sysRequirementRepository.save(new SysRequirement(sysRequirement.getId(),
                    sysRequirement.getCpu(), sysRequirement.getGpu(), sysRequirement.getMemory(), sysRequirement.getStorage(),
                    sysRequirement.getOs()));

            return new ResponseEntity<>(_sysRequirement, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SysRequirement> updateSysRequirement(@PathVariable("id") int id,
                                                               @RequestBody SysRequirement sysRequirement) {
        Optional<SysRequirement> sysRequirementData = sysRequirementRepository.findById(id);

        if (sysRequirementData.isPresent()) {
            SysRequirement _sysRequirement = sysRequirementData.get();
            _sysRequirement.setCpu(sysRequirement.getCpu());
            _sysRequirement.setGpu(sysRequirement.getGpu());
            _sysRequirement.setMemory(sysRequirement.getMemory());
            _sysRequirement.setStorage(_sysRequirement.getStorage());
            _sysRequirement.setOs(sysRequirement.getOs());

            return new ResponseEntity<>(sysRequirementRepository.save(_sysRequirement), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
