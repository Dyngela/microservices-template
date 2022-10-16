package com.diy.service;

import com.diy.generated.model.CategoryWithProductDto;
import com.diy.generated.model.CategoryWithoutProductDto;
import com.diy.generated.model.PagerDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {

    public CategoryWithoutProductDto getAllCategoryByStoreId(PagerDto pagerDto) {
        return null;
    }

    public CategoryWithProductDto getCategoryAndItsProductByStoreId(Long categoryid, PagerDto pagerDto) {
        return null;
    }

}
