package ru.gb.storage.commons.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class AuthRequest extends Message{
    private final String login;
    private final String password;


    @Override
    public CommandType getType() {
        return CommandType.AUTH_REQUEST;
    }
}
