package dcu.ie.WasteTracker.Controllers;

import dcu.ie.WasteTracker.Entities.ReadingEntity;
import dcu.ie.WasteTracker.Entities.UserEntity;
import dcu.ie.WasteTracker.Models.ReadingModel;
import dcu.ie.WasteTracker.Models.UserModel;
import dcu.ie.WasteTracker.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(@Autowired UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        System.out.println("--- Getting users ---");
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @PostMapping("/create")
    @CrossOrigin(origins ="*")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity userEntity) throws IOException
    {
        System.out.println("--- Saving user ---");
        return new ResponseEntity<UserEntity>(userService.saveUser(userEntity), HttpStatus.CREATED);
    }
}