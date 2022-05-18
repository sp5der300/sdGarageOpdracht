package nl.bd.sdbackendeindopdracht.services;

import nl.bd.sdbackendeindopdracht.models.Parts;
import nl.bd.sdbackendeindopdracht.models.requestModels.PartsRequest;
import nl.bd.sdbackendeindopdracht.repos.PartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartsService {

    public final PartsRepository partsRepository;

    @Autowired
    public PartsService(PartsRepository partsRepository) {
        this.partsRepository = partsRepository;
    }

    public Parts addNewPart(PartsRequest parts){
        Parts part1 = Parts.builder()
                .partName(parts.getPartName())
                .partPrice(parts.getPartPrice())
                .build();
        return partsRepository.save(part1);
    }

    public List<Parts> getAllParts(){
        return partsRepository.findAll();
    }

    public void deleteParts(Long id){
        partsRepository.deleteById(id);
    }

    public Parts editParts(PartsRequest parts, Long partsId) {
        Parts partsFromDatabase;
        if (partsRepository.findById(partsId).isEmpty()) {
            throw new RuntimeException("Order is empty or does not exist.");
        } else {
            partsFromDatabase = partsRepository.findById(partsId).get();
            partsFromDatabase.setPartName(parts.getPartName());
            partsFromDatabase.setPartPrice(parts.getPartPrice());
        }
        return partsRepository.save(partsFromDatabase);
    }

}
