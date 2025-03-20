package com.example.careerfyJobPortal.service;


import com.example.careerfyJobPortal.repositry.ComapanyReposity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private ComapanyReposity comapanyReposity;
    @Autowired
    private ModelMapper modelMapper;

}
