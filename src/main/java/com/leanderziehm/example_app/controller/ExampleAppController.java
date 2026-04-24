package com.leanderziehm.example_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leanderziehm.example_app.model.ExampleEntity;
import com.leanderziehm.example_app.service.ExampleService;
import com.leanderziehm.example_app.utils.Utils;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ExampleAppController {

    @Autowired
    ExampleService exampleService;

    @GetMapping("/add")
    public String addExample() {
        return exampleService.addExample().toString();
    }

    @DeleteMapping("/delete")
    public String removeExample(@RequestParam(name="id",required = false) String idString) {
        System.out.println(idString);
        Integer id = Utils.parseOrDefault(idString, null);
        if (id == null) {
            return "No valid id: " + idString;
        }
        return exampleService.removeExampleById(id);
    }

    @PostMapping("/create")
    public String createExample(@RequestBody ExampleEntity exampleEntity){
        return exampleService.addExample(exampleEntity).toString();
    }

    @PutMapping("/replace/{id}")
    public String updateExample(@RequestBody ExampleEntity newEntity,@PathVariable Integer id){
        return exampleService.replaceExampleById(id,newEntity).toString();
    }

    // @PatchMapping("/update/{id}")
    // public String updateExample(@RequestBody ExampleEntity exampleEntity,@PathVariable Integer id){
    //     return exampleService.updateExampleById(id,exampleEntity).toString();
    // }

    @GetMapping("/list")
    public String listExamples() {
        return exampleService.listExamples().toString();
    }

    // @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    // public void method(HttpServletResponse httpServletResponse) {
    //     String url = "/index.html"; //"/swagger-ui/index.html"; 
    //     httpServletResponse.setHeader("Location", url);
    //     httpServletResponse.setStatus(302);
    // }

}
