package com.simongirard.innso.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class Config extends WebMvcConfigurationSupport {

    @Override
    public FormattingConversionService mvcConversionService() {
        FormattingConversionService formattingConversionService = super.mvcConversionService();
        formattingConversionService.addConverter(new EnumConverter());
        return formattingConversionService;
    }
}
