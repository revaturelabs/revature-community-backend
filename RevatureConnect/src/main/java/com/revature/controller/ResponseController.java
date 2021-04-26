package com.revature.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Response;
import com.revature.service.ResponseService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class ResponseController {

    @Autowired
    private ResponseService rservice; 

    @GetMapping("/responses/{postId}")
    public ResponseEntity<List<Response>> getresponsesbypostid(@PathVariable("postId") long postId) { 
        List<Response> rs = rservice.getResponsesByPostId(postId);
        return new ResponseEntity<List<Response>>(rs, HttpStatus.OK); 
    }

    @PostMapping("/responses/submit-response")
    public ResponseEntity<Response> save(@RequestBody Response response) throws IOException {

        Response r = new Response(); 

        r.setContent(response.getContent());
        r.setPostId(response.getPostId());
        Response responseObject = rservice.submitResponse(response);
        return new ResponseEntity<Response>(responseObject, HttpStatus.OK);
    }

}
