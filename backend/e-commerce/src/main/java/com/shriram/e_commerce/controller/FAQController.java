package com.shriram.e_commerce.controller;

import com.shriram.e_commerce.dto.request.FAQDtoRequest;
import com.shriram.e_commerce.services.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/faq")
public class FAQController {

    @Autowired
    private FAQService faqService;

    @PostMapping("/add/{productId}")
    public ResponseEntity<HttpStatus> addNewQuestions(@RequestBody FAQDtoRequest faqDtoRequest,
                                                      @PathVariable int productId){
        boolean bool = faqService.addQuestions(faqDtoRequest,productId);
            if (bool){
                return new ResponseEntity<>(HttpStatus.CREATED);
            }else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
    }

}
