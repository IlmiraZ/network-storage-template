package ru.gb.storage.commons.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class AuthResponse extends Message {
    private final String userName;
    private final int resultCode;
    private final String resultMessage;
    @Override
    public CommandType getType() {
        return CommandType.AUTH_RESPONSE;
    }
}
