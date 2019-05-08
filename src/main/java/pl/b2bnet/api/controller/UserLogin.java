package pl.b2bnet.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.b2bnet.api.Model.LoginDto;
import pl.b2bnet.api.service.LoginService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class UserLogin {
    private final LoginService loginService;
    @PostMapping
    public String login(@RequestBody LoginDto loginDto) {
        return loginService.login(loginDto);
    }
}
