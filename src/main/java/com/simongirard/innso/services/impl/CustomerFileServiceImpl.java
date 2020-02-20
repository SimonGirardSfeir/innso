package com.simongirard.innso.services.impl;

import com.simongirard.innso.model.CustomerFile;
import com.simongirard.innso.model.Message;
import com.simongirard.innso.repositories.CustomerFileRepository;
import com.simongirard.innso.repositories.MessageRepository;
import com.simongirard.innso.services.CustomerFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerFileServiceImpl implements CustomerFileService {

    private final CustomerFileRepository customerFileRepository;
    private final MessageRepository messageRepository;

    @Autowired
    public CustomerFileServiceImpl(CustomerFileRepository customerFileRepository, MessageRepository messageRepository) {
        this.customerFileRepository = customerFileRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public CustomerFile createCustomerFile() {
        Message message = messageRepository.findAll().iterator().next();
        CustomerFile customerFile = new CustomerFile(LocalDate.now(), null, message);
        message.setCustomerFile(customerFile);
        return customerFileRepository.save(customerFile);
    }

    @Override
    public CustomerFile updateCustomerFile(String reference) {
        CustomerFile customerFile = customerFileRepository.findAll().iterator().next();
        customerFile.setReference(reference);
        return customerFileRepository.save(customerFile);
    }

    @Override
    public List<CustomerFile> listCustomerFiles() {
        List<CustomerFile> list = new ArrayList<>();
        customerFileRepository.findAll().forEach(list::add);

        return list;
    }
}
