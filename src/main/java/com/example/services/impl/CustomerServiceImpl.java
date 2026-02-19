package com.example.services.impl;

import com.example.dto.DtoAddress;
import com.example.dto.DtoCustomer;
import com.example.entities.Address;
import com.example.entities.Customer;
import com.example.repository.CustomerRepository;
import com.example.services.ICustomerServise;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerServise {
   @Autowired
    private CustomerRepository customerRepository;


    @Override
    public DtoCustomer findCustomerById(Long id) {

        DtoCustomer dtoCustomer=new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();
      Optional<Customer> optional= customerRepository.findById(id);
      //dışardan bir ıd cektik deger ıd bulabilirsek aşagıda bilgilerini cektik ve dto lara copy yaptık

     if (optional.isEmpty()){
         return null;
     }
     Customer customer=optional.get();
        Address address =optional.get().getAddress();

        BeanUtils.copyProperties(customer,dtoCustomer);
        BeanUtils.copyProperties(address, dtoAddress);

        dtoCustomer.setAddress(dtoAddress);

        return  dtoCustomer;

    }
}
