package com.example.MovieTheaterAPI.discount;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discounts")
public class DiscountController {

  DiscountService discountService;

  @GetMapping({"/"})
  public ResponseEntity<List<Discount>> getAllDiscounts() {
    List<Discount> discounts = discountService.getAllDiscounts();
    return new ResponseEntity<>(discounts, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Discount> getDiscountById(@PathVariable Long id) {
    Discount discount = discountService.getDiscountById(id);
    if (discount != null) {
        return new ResponseEntity<>(discount, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping
  public ResponseEntity<Discount> createDiscount(@RequestBody Discount discount) {
    Discount createdDiscount = discountService.createDiscount(discount);
    return new ResponseEntity<>(createdDiscount, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Discount> updateDiscount(@PathVariable Long id, @RequestBody Discount discount) {
    Discount updatedDiscount = discountService.updateDiscount(id, discount);
    if (updatedDiscount != null) {
        return new ResponseEntity<>(updatedDiscount, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteDiscount(@PathVariable Long id) {
    discountService.deleteDiscount(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
  
}
