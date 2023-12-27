package com.logistic.assigment.Controller;
import com.logistic.assigment.model.Load;
import com.logistic.assigment.service.LoadService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;





@RestController
@CrossOrigin
@Validated
@RequestMapping("/api/load")
public class LoadController {

    @Autowired
    private LoadService loadService;

    @PostMapping
    public ResponseEntity<String> createLoad(@RequestBody Load load) {
        Load createdLoad = loadService.createLoad(load);

        if (createdLoad != null) {
            // Load submitted successfully
            return ResponseEntity.ok("Load submitted successfully. Load ID: " + createdLoad.getId());
        } else {
            // Load submission failed
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to submit load.");
        }
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitLoad(@RequestBody Load load) {
        if (load.getShipperId() != null) {
            // Load submitted successfully
            return ResponseEntity.ok("Load submitted successfully. Shipper ID: " + load.getShipperId());
        } else {
            // Handle the case when shipperId is missing or not provided
            return ResponseEntity.badRequest().body("shipperId is required");
        }
    }

    @GetMapping
    public List<Load> getLoadsByShipperId(@RequestParam String shipperId) {
        return loadService.findByShipperId(shipperId);
    }

    @GetMapping("/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable Long loadId) {
        Optional<Load> load = loadService.getLoadById(loadId);
        return load.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{loadId}")
    public ResponseEntity<String> updateLoad(@PathVariable Long loadId, @RequestBody Load updateLoad) {
        Load updatedLoad = loadService.updateLoad(loadId, updateLoad);
        if (updatedLoad != null) {
            return ResponseEntity.ok("Load details updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{loadId}")
    public ResponseEntity<String> deleteLoad(@PathVariable Long loadId) {
        loadService.deleteLoad(loadId);
        return ResponseEntity.ok("Load deleted successfully");
    }
}
