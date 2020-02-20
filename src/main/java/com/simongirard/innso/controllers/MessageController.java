package com.simongirard.innso.controllers;

import com.simongirard.innso.model.Message;
import com.simongirard.innso.services.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("messages")
public class MessageController {

    private final MessageService messageService;


    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping(path = "/addMessage")
    public Message saveMessage(@RequestParam(value = "clientName") String clientName,
                               @RequestParam(value = "content") String content,
                               @RequestParam(value = "channel") String channel) {
        return messageService.saveMessage(clientName, content, channel);
    }

    @PostMapping(path = "/helpClient")
    public Message responseToClient(@RequestParam(value = "authorName") String authorName,
                            @RequestParam(value = "content") String content,
                            @RequestParam(value = "channel") String channel) {
        return messageService.responseToClient(authorName, content, channel);
    }
}
