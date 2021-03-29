package com.policyexpert.qademo.utility;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkFlow {

    /**
     * Convert the string for product selection to list of index
     *
     * @param products
     * @param productCount
     * @param sortOrder
     * @return list of index
     */
    public List<Integer> getProductsIndex(String products, int productCount, String sortOrder) {
        List<Integer> productsList = new ArrayList<Integer>() {
        };
        for (String s : products.split(",")) {
            s = s.trim();
            int index = 0;
            if (s.equals("cheapest")) {
                index = (sortOrder.equals("descending")) ? productCount : 1;
            } else if (s.equals("costliest")) {
                index = (sortOrder.equals("descending")) ? 1 : productCount;
            } else if (s.contains("cheapest")) {
                int i = Integer.parseInt(s.replaceAll("[^\\d.]", ""));
                if(index < productCount)
                index = (sortOrder.equals("descending")) ? productCount - i + 1 : i;
            } else if (s.contains("costliest")) {
                int i = Integer.parseInt(s.replaceAll("[^\\d.]", ""));
                if(index < productCount)
                index = (sortOrder.equals("descending")) ? i : productCount - i + 1;
            }
            if (index > 0)
                productsList.add(index - 1);
        }
        return productsList.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
