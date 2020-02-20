package com.simongirard.innso.controllers;

import com.simongirard.innso.model.CustomerFile;
import com.simongirard.innso.services.CustomerFileService;
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

    private final CustomerFileService customerFileService;

    public CustomerFileController(CustomerFileService customerFileService) {
        this.customerFileService = customerFileService;
    }

    @PostMapping(path = "/addCustomerFile")
    public CustomerFile createCustomerFile() {
        return customerFileService.createCustomerFile();

    }

    @PostMapping(path = "/update")
    public CustomerFile updateCustomerFile(@RequestParam(value = "reference") String reference) {
        return customerFileService.updateCustomerFile(reference);
    }

    @ResponseBody
    @GetMapping(path = "listCustomerFiles")
    public List<CustomerFile> listCustomerFiles() {
        return customerFileService.listCustomerFiles();
    }
}
