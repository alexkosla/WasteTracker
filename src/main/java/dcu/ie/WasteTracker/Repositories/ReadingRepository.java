package dcu.ie.WasteTracker.Repositories;

import java.util.List;
import dcu.ie.WasteTracker.Models.ReadingModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ReadingRepository extends JpaRepository<ReadingModel, Integer>{
    List<ReadingModel> findAll();
}
