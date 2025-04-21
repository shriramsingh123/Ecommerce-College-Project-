package com.shriram.e_commerce.services;

import com.shriram.e_commerce.dto.request.FAQDtoRequest;

public interface FAQService {
    boolean addQuestions(FAQDtoRequest faqDtoRequest,int productId);
}
