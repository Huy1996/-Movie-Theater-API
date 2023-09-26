package com.example.MovieTheaterAPI.discount;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiscountServiceImpl implements DiscountService{

  DiscountRepository discountRepository;

  @Override
  public List<Discount> getAllDiscounts(){
    return discountRepository.findAll();
  }

  @Override
  public Discount getDiscountById(Long id){
    return discountRepository.findById(id).orElse(null);
  }

  @Override
  @Transactional
  public Discount createDiscount(Discount discount) {
      return discountRepository.save(discount);
  }

  @Override
  @Transactional
  public Discount updateDiscount(Long id, Discount updatedDiscount) {
    Optional<Discount> optionalDiscount = discountRepository.findById(id);
    if (optionalDiscount.isPresent()) {
      Discount existingDiscount = optionalDiscount.get();
      existingDiscount.setTitle(updatedDiscount.getTitle());
      existingDiscount.setIsHappyHourBefore6PM(updatedDiscount.getIsHappyHourBefore6PM());
      existingDiscount.setIsTuesdayDiscount(updatedDiscount.getIsTuesdayDiscount());
      return discountRepository.save(existingDiscount);
    }
    return null;
  }

  @Override
  @Transactional
  public void deleteDiscount(Long id) {
      discountRepository.deleteById(id);
  }
}
