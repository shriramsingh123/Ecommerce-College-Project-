package com.shriram.e_commerce.services.impl;

import com.shriram.e_commerce.dto.request.FAQDtoRequest;
import com.shriram.e_commerce.entity.FAQ;
import com.shriram.e_commerce.entity.Product;
import com.shriram.e_commerce.repository.FAQRepository;
import com.shriram.e_commerce.repository.ProductRepository;
import com.shriram.e_commerce.services.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FAQServiceImpl implements FAQService {

    @Autowired
    private FAQRepository faqRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean addQuestions(FAQDtoRequest faqDtoRequest, int productId) {
        FAQ faq = new FAQ();
        faq.setQuestion(faqDtoRequest.getQuestion());
        faq.setAnswer(faqDtoRequest.getAnswer());

        Product product = productRepository.findById(productId)
                        .orElseThrow(()-> new RuntimeException("Faq service impl Exception 1223"));
        faq.setProduct(product);
        faqRepository.save(faq);
        return true;
    }

}
