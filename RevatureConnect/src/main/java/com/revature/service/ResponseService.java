package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Response;
import com.revature.repository.ResponseRepository;

@Service
@Transactional
public class ResponseService {
    @Autowired
    private ResponseRepository rrepo;

    public List<Response> getResponsesByPostId(long postId) {
        return rrepo.getResponsesByPostId(postId); 
    }

    public Response submitResponse(Response response) {
        rrepo.save(response);
        return response; 
    }

}