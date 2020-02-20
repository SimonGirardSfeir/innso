package com.simongirard.innso.services;

import com.simongirard.innso.model.CustomerFile;

import java.util.List;

public interface CustomerFileService {

    CustomerFile createCustomerFile();

    CustomerFile updateCustomerFile(String reference);

    List<CustomerFile> listCustomerFiles();
}
