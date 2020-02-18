package com.simongirard.innso.controllers;

import com.simongirard.innso.config.EnumConverter;
import com.simongirard.innso.model.Channel;
import com.simongirard.innso.model.CustomerFile;
import com.simongirard.innso.model.Message;
import com.simongirard.innso.repositories.CustomerFileRepository;
import com.simongirard.innso.repositories.MessageRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("messages")
public class MessageController {

    private final MessageRepository messageRepository;
    private final CustomerFileRepository customerFileRepository;


    public MessageController(MessageRepository messageRepository, CustomerFileRepository customerFileRepository) {
        this.messageRepository = messageRepository;
        this.customerFileRepository = customerFileRepository;
    }

    @PostMapping(path = "/addMessage")
    public void saveMessage(@RequestParam(value = "clientName") String clientName,
                               @RequestParam(value = "content") String content,
                               @RequestParam(value = "channel") String channel) {

        EnumConverter enumConverter = new EnumConverter();
        Channel channel1 = enumConverter.convert(channel);
        Message message = new Message(clientName, content, channel1);
        messageRepository.save(message);
    }

    @PostMapping(path = "/helpClient")
    public void responseToClient(@RequestParam(value = "authorName") String authorName,
                            @RequestParam(value = "content") String content,
                            @RequestParam(value = "channel") String channel) {

        EnumConverter enumConverter = new EnumConverter();
        Channel channel1 = enumConverter.convert(channel);
        Message message = new Message(authorName, content, channel1);
        CustomerFile customerFile = customerFileRepository.findAll().iterator().next();
        message.setCustomerFile(customerFile);
        customerFile.getMessages().add(message);

        messageRepository.save(message);
    }
}
