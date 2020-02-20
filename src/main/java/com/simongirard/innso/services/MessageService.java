package com.simongirard.innso.services;

import com.simongirard.innso.model.Message;

public interface MessageService {

    Message saveMessage(String clientName, String content, String channel);

    Message responseToClient(String authorName, String content, String channel);
}
