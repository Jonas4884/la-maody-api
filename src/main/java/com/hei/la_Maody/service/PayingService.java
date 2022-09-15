package com.hei.la_Maody.service;

import com.hei.la_Maody.model.Paying;
import com.hei.la_Maody.repository.payingRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class PayingService {
    private payingRepository payingRepository;

  public List<Paying> getAllPaying (){
      return payingRepository.findAll();
  }
  public Paying createPaying(Paying paying){
      return payingRepository.save(paying);
  }

  public Paying PayingSituation(Long id){
    Paying paying =  payingRepository.findById(id).get();

    if(paying.getPayment_date().compareTo(Date.from(Instant.now()))<0){
        paying.setPayed(true);
    }
    return paying;
  }
}
