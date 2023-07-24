package dcu.ie.WasteTracker.Repositories;
import java.util.List;
import dcu.ie.WasteTracker.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<UserModel, Integer>{
    List<UserModel> findAll();
}