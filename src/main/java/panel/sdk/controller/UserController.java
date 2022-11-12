package panel.sdk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import panel.sdk.model.User;
import panel.sdk.payload.ApiResponse;
import panel.sdk.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{userID}")
    public void getUserByID(@PathVariable Long userID){

    }

    @PostMapping("/user")
    public ApiResponse createUser(@RequestBody User user){
        if(user ==null || user.getUserID()==null || user.getUserName()==null){
            return new ApiResponse(false, "user ID or name is null");
        }else{
            boolean result = userRepository.InsertUser(user);
            return new ApiResponse(true, "");
        }

    }



    @GetMapping("/user/auth")
    public ApiResponse getUserByID(@RequestParam(value = "cardNo") String cardNo){
        if(cardNo==null){
            return new ApiResponse(false, "cardNo is empty");
        }else{
            User user = userRepository.getUserByCardNo(cardNo);
            if(user==null){
                return new ApiResponse(false, "User not found");
            }else{
                return new ApiResponse(false, "Success");
            }
        }
    }
}
