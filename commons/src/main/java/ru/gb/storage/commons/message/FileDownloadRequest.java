package ru.gb.storage.commons.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class FileDownloadRequest extends Message {
    String name;

    @Override
    public CommandType getType() {
        return CommandType.FILE_DOWNLOAD_REQUEST;
    }
}
