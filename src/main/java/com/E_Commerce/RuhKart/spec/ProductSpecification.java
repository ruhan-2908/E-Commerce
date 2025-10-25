package com.E_Commerce.RuhKart.spec;

import com.E_Commerce.RuhKart.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    public static Specification<Product> hasCategory(String category)
    {
        return (root,query,cb) -> category == null ? null : cb.equal(root.get("category"),category);
    }
    public static Specification<Product> priceBetween(Double min , Double max)
    {
        return (root,query,cb)-> {
            if(min  == null && max == null)
            {
                return null;
            }


            if(min == null )
            {
                return cb.lessThanOrEqualTo(root.get("price"),max);
            }


            if(max == null)
            {
                return cb.greaterThanOrEqualTo(root.get("price"),min);
            }

            return cb.between(root.get("price"),min,max);
        };
    }
}
