package seoan.backend.controller;

import seoan.backend.Model.User;
import seoan.backend.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MemberController {

    @Autowired
    private MemberService memberService;

    //create user
    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return memberService.createUser(user);
    }
}
