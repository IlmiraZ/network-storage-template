package ru.gb.storage.commons.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class FileDeleteRequest extends Message {
    private final String name;

    @Override
    public CommandType getType() {
        return CommandType.FILE_DELETE_REQUEST;
    }
}
