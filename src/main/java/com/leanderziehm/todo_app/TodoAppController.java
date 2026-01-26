package com.leanderziehm.todo_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoAppController {

    @GetMapping("/")
    public static String getIndex(){
        return "hi v0.0.1";
    }

}
