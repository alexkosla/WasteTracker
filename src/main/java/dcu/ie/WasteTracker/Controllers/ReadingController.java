package dcu.ie.WasteTracker.Controllers;
import java.io.IOException;
import java.net.URI;
import java.util.List;

import dcu.ie.WasteTracker.Entities.DailyAverageEntity;
import dcu.ie.WasteTracker.Entities.ReadingEntity;
import dcu.ie.WasteTracker.Entities.ReadingEventEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.PostMapping;

import dcu.ie.WasteTracker.Models.ReadingModel;
import dcu.ie.WasteTracker.Services.ReadingService;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("readings")
public class ReadingController {
    private final ReadingService readingService;

    public ReadingController(@Autowired ReadingService readingService)
    {
        this.readingService = readingService;
    }

    // getAllReadings: gets the list of all readings saved to the db
    @GetMapping("/getAll")
    public ResponseEntity<List<ReadingModel>> getAllReadings() {
        System.out.println("--- Getting readings ---");
        return ResponseEntity.ok(readingService.getAllReadings());
    }

    // getDaily: gets a list of readings, but filtered so that only the
    // last submitted reading on each day is included
    @GetMapping("/getDaily")
    public ResponseEntity<List<ReadingEventEntity>> getDaily() {
        System.out.println("--- Getting daily readings ---");
        return ResponseEntity.ok(readingService.getDaily());
    }

    // getDailyChanges: gets the average change in bin fullness on each day of the week
    @GetMapping("/getDailyChanges")
    public ResponseEntity<DailyAverageEntity> getDailyChanges() {
        System.out.println("--- Getting daily changes ---");
        return ResponseEntity.ok(readingService.getDailyChanges());
    }

    // saveReading: saves a new reading to the db, used by the RPI taking readings
    @PostMapping("/create")
    @CrossOrigin(origins ="*")
    public ResponseEntity<ReadingModel> saveReading(@RequestBody ReadingEntity readingEntity) throws IOException
    {
        System.out.println("--- Saving reading ---");
        return ResponseEntity.ok(readingService.saveReading(readingEntity));
    }
}
