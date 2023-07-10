package dcu.ie.WasteTracker.Controllers;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getReadings")
    public ResponseEntity<List<ReadingModel>> getAllReadings() {
        System.out.println("--- Getting readings ---");
        return ResponseEntity.ok(readingService.getAllReadings());
    }
}
