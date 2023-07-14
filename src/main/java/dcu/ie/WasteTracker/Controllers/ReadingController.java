package dcu.ie.WasteTracker.Controllers;
import java.io.IOException;
import java.net.URI;
import java.util.List;

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

    @GetMapping("/getAll")
    public ResponseEntity<List<ReadingModel>> getAllReadings() {
        System.out.println("--- Getting readings ---");
        return ResponseEntity.ok(readingService.getAllReadings());
    }

    @PostMapping("/create")
    public ResponseEntity<ReadingModel> saveReading(@RequestBody ReadingModel readingModel) throws IOException
    {
        System.out.println("--- Saving reading ---");
        return ResponseEntity.ok(readingService.saveReading(readingModel));
    }
}
