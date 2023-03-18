package com.twiliopowerup.twiliopowerup.application.mapper;

import com.twiliopowerup.twiliopowerup.application.dto.request.MessageRequestDto;
import com.twiliopowerup.twiliopowerup.domain.model.MessageModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IMessageRequestMapper {
    MessageModel toModel(MessageRequestDto messageRequestDto);
    MessageRequestDto toRequestDto (MessageModel messageModel);
}
