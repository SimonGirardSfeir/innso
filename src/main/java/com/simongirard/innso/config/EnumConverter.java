package com.simongirard.innso.config;

import com.simongirard.innso.model.Channel;
import org.springframework.core.convert.converter.Converter;

public class EnumConverter implements Converter<String, Channel> {
    @Override
    public Channel convert(String channel) {
        try {
            return Channel.valueOf(channel);
        } catch(Exception e) {
            return Channel.MAIL;
        }
    }
}
