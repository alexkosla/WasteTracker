package dcu.ie.WasteTracker.Services;
import java.util.List;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import dcu.ie.WasteTracker.Models.ReadingModel;
import dcu.ie.WasteTracker.Repositories.ReadingRepository;

@Service
public class ReadingService {
    private final ReadingRepository readingRepository;

    public ReadingService(ReadingRepository readingRepository)
    {
        this.readingRepository = readingRepository;
    }

    public List<ReadingModel> getAllReadings()
    {
        return readingRepository.findAll();
    }

    public ReadingModel saveReading(ReadingModel readingModel)
    {
        readingRepository.save(readingModel);
        return readingModel;
    }
}
