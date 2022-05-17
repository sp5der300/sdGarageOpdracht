package nl.bd.sdbackendeindopdracht.controllers;

import nl.bd.sdbackendeindopdracht.models.Parts;
import nl.bd.sdbackendeindopdracht.models.requestModels.PartsRequest;
import nl.bd.sdbackendeindopdracht.services.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/v1/parts")

public class PartsController {

    private final PartsService partsService;

    @Autowired
    public PartsController(PartsService partsService){
        this.partsService = partsService;
    }

    @GetMapping("/getAllParts")
    public List<Parts> getAllParts(){
        return partsService.getAllParts();
    }

    @PostMapping("/newParts")
    public Parts newParts(@RequestBody PartsRequest parts){
        return partsService.addNewPart(parts);
    }

    @PutMapping("/editParts/parts={partsId}")
    public Parts editParts(@RequestBody PartsRequest parts, @PathVariable("partsId") Long partsId){
        return partsService.editParts(parts, partsId);
    }


}
