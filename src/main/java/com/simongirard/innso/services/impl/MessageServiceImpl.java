package com.simongirard.innso.services.impl;

import com.simongirard.innso.config.EnumConverter;
import com.simongirard.innso.model.Channel;
import com.simongirard.innso.model.CustomerFile;
import com.simongirard.innso.model.Message;
import com.simongirard.innso.repositories.CustomerFileRepository;
import com.simongirard.innso.repositories.MessageRepository;
import com.simongirard.innso.services.MessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final CustomerFileRepository customerFileRepository;

    public MessageServiceImpl(MessageRepository messageRepository, CustomerFileRepository customerFileRepository) {
        this.messageRepository = messageRepository;
        this.customerFileRepository = customerFileRepository;
    }

    @Override
    public Message saveMessage(String clientName, String content, String channel) {

        EnumConverter enumConverter = new EnumConverter();
        Channel channel1 = enumConverter.convert(channel);
        Message message = new Message(clientName, content, channel1);
        return messageRepository.save(message);
    }

    @Override
    public Message responseToClient(String authorName, String content, String channel) {
        EnumConverter enumConverter = new EnumConverter();
        Channel channel1 = enumConverter.convert(channel);
        Message message = new Message(authorName, content, channel1);
        CustomerFile customerFile = customerFileRepository.findAll().iterator().next();
        message.setCustomerFile(customerFile);
        customerFile.getMessages().add(message);

        return messageRepository.save(message);
    }
}
