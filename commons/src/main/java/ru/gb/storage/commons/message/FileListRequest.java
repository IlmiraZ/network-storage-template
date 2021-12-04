package ru.gb.storage.commons.message;

public class FileListRequest extends Message {
    @Override
    public CommandType getType() {
        return CommandType.FILE_LIST_REQUEST;
    }
}
