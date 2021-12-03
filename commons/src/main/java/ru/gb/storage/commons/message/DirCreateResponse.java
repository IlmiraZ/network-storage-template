package ru.gb.storage.commons.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class DirCreateResponse extends Message {
    private final int resultCode;
    private final String ResultMessage;

    @Override
    public CommandType getType() {
        return CommandType.DIR_CREATE_RESPONSE;
    }
}
