package dcu.ie.WasteTracker.Services;

import dcu.ie.WasteTracker.Entities.ReadingEntity;
import dcu.ie.WasteTracker.Entities.UserEntity;
import dcu.ie.WasteTracker.Models.ReadingModel;
import dcu.ie.WasteTracker.Models.UserModel;
import dcu.ie.WasteTracker.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers()
    {
        List<UserModel> userModels = userRepository.findAll();
        List<UserEntity> userEntities = new ArrayList<UserEntity>();
        userModels.sort(Comparator.comparing(UserModel::getTimestamp).reversed());
        userModels.forEach(userModel -> userEntities.add(new UserEntity(userModel)));
        return userEntities;
    }

    public UserEntity saveUser(UserEntity userEntity)
    {
        UserModel userModel = new UserModel(userEntity);
        userRepository.save(userModel);
        return userEntity;
    }
}
