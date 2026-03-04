package com.chanpller.chapter2web.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class YamlHttpMessageConverter extends AbstractHttpMessageConverter<Object> {
    private ObjectMapper mapper = null;
    public YamlHttpMessageConverter(){
        //添加支持的类型
        super(new MediaType("text","yaml", StandardCharsets.UTF_8));
        //YAMLFactory工厂，.disable(YAMLGenerator.Feature .WRITE_DOC_START_MARKER)去掉生成三个横杠。
        YAMLFactory factory = new YAMLFactory().disable(YAMLGenerator.Feature .WRITE_DOC_START_MARKER);
        //jackson的ObjectMapper传入YAMLFactory工厂
        this.mapper = new ObjectMapper(factory);
    }
    @Override
    protected boolean supports(Class<?> clazz) {
        //支持的类
        return true;
    }

    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        //读取request Body
        return null;
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        //response 返回内容
        try(OutputStream body = outputMessage.getBody()) {
          mapper.writeValue(body, o);
        }
    }
}
