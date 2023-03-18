package com.twiliopowerup.twiliopowerup.domain.api;

import com.twiliopowerup.twiliopowerup.domain.model.MessageModel;

public interface ITwilioServicePort {
    Boolean sendMessage (MessageModel messageModel);
}
