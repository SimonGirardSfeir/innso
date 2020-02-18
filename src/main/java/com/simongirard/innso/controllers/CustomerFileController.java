package com.simongirard.innso.controllers;

import com.simongirard.innso.model.CustomerFile;
import com.simongirard.innso.model.Message;
import com.simongirard.innso.repositories.CustomerFileRepository;
import com.simongirard.innso.repositories.MessageRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("customer-file")
public class CustomerFileController {

    private final CustomerFileRepository customerFileRepository;
    private final MessageRepository messageRepository;

    public CustomerFileController(CustomerFileRepository customerFileRepository, MessageRepository messageRepository) {
        this.customerFileRepository = customerFileRepository;
        this.messageRepository = messageRepository;
    }

    @PostMapping(path = "/addCustomerFile")
    public void createCustomerFile(@RequestParam(value = "name") String name) {

        Message message = messageRepository.findByAuthorName(name);
        CustomerFile customerFile = new CustomerFile(LocalDate.now(), null, message);
        customerFile.setClientName(message.getAuthorName());
        message.setCustomerFile(customerFile);
        customerFileRepository.save(customerFile);

    }

    @PostMapping(path = "/update")
    public void updateCustomerFile(@RequestParam(value = "reference") String reference,
                                   @RequestParam(value = "clientName") String clientName) {
        CustomerFile customerFile = customerFileRepository.findByClientName(clientName);
        customerFile.setReference(reference);
        customerFileRepository.save(customerFile);

    }

    @ResponseBody
    @GetMapping(path = "listCustomerFiles")
    public List<CustomerFile> listCustomerFiles() {
        List<CustomerFile> list = new ArrayList<>();
        customerFileRepository.findAll().forEach(list::add);

        return list;
    }
}
