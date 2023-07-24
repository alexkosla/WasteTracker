package dcu.ie.WasteTracker.Services;

import dcu.ie.WasteTracker.Entities.ReadingEntity;
import dcu.ie.WasteTracker.Entities.UserEntity;
import dcu.ie.WasteTracker.Models.ReadingModel;
import dcu.ie.WasteTracker.Models.UserModel;
import dcu.ie.WasteTracker.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> getAllUsers()
    {
        return userRepository.findAll();
    }

    public UserModel saveUser(UserEntity userEntity)
    {
        UserModel userModel = new UserModel(userEntity);
        userRepository.save(userModel);
        return userModel;
    }
}
