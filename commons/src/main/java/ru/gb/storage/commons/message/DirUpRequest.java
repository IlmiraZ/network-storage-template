package ru.gb.storage.commons.message;

public class DirUpRequest extends Message {

    @Override
    public CommandType getType() {
        return CommandType.DIR_UP_REQUEST;
    }
}
