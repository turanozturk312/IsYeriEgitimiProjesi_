package com.isyeri.modules.chat.entity.projection;

import com.isyeri.modules.chat.entity.Message;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "messageContent", types = { Message.class })
public interface MessageContent {

    String getContent();

}
