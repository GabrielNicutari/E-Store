package com.example.demo.Controller;

import com.example.demo.Model.SysRequirement;
import com.example.demo.Repository.SysRequirementRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {
        "http://localhost:8081",
        "http://localhost:3000",
        "https://next-level-web-client.herokuapp.com/",
        "http://nextlevelclient-env.eba-3tw249tp.us-east-1.elasticbeanstalk.com:8081"
})
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

        SysRequirement _sysRequirement = sysRequirementRepository.save(new SysRequirement(sysRequirement.getId(),
                sysRequirement.getCpu(), sysRequirement.getGpu(), sysRequirement.getMemory(), sysRequirement.getStorage(),
                sysRequirement.getOs()));

        return new ResponseEntity<>(_sysRequirement, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SysRequirement> updateSysRequirement(@PathVariable("id") int id,
                                                               @RequestBody SysRequirement sysRequirement) {
        SysRequirement _sysRequirement = sysRequirementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found system requirements with id" + id));

        _sysRequirement.setCpu(sysRequirement.getCpu());
        _sysRequirement.setGpu(sysRequirement.getGpu());
        _sysRequirement.setMemory(sysRequirement.getMemory());
        _sysRequirement.setStorage(sysRequirement.getStorage());
        _sysRequirement.setOs(sysRequirement.getOs());

        return new ResponseEntity<>(sysRequirementRepository.save(_sysRequirement), HttpStatus.OK);
    }
}
