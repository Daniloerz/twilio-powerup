package com.twiliopowerup.twiliopowerup.domain.usecase;

import com.twiliopowerup.twiliopowerup.domain.api.ITwilioServicePort;
import com.twiliopowerup.twiliopowerup.domain.model.MessageModel;
import com.twiliopowerup.twiliopowerup.domain.spi.ITwilioPersistencePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TwilioUseCase implements ITwilioServicePort {

    public final Logger log = LoggerFactory.getLogger(TwilioUseCase.class);


    private final String message = "¡Tu pedido esta listo! Reclamalo con el código: %s";
    private ITwilioPersistencePort twilioPersistencePort;

    public TwilioUseCase(ITwilioPersistencePort twilioPersistencePort) {
        this.twilioPersistencePort = twilioPersistencePort;
    }

    @Override
    public Boolean sendMessage(MessageModel messageModel) {
        this.validateMessage(messageModel);

        return twilioPersistencePort.sendMessage(messageModel.getPhoneNumber(),
                String.format(message, messageModel.getSecurityCode()));
    }

    public void validateMessage (MessageModel messageModel){
        if(messageModel.getPhoneNumber() == null || messageModel.getPhoneNumber().isEmpty()){
            log.error("Invalid phone number");
            throw new RuntimeException("Invalid phone number");
        }

        if(messageModel.getSecurityCode() == null || messageModel.getSecurityCode().isEmpty()){
            log.error("Invalid security code");
            throw new RuntimeException("Invalid security code");
        }
    }
}
