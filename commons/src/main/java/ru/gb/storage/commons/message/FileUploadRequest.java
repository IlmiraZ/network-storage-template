package ru.gb.storage.commons.message;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@EqualsAndHashCode(callSuper = true)
@Data
public class FileUploadRequest extends Message {
    private final String name;
    private final byte[] content;

    public FileUploadRequest(Path path) throws IOException {
        this.name = path.getFileName().toString();
        this.content = Files.readAllBytes(path);
    }

    @Override
    public CommandType getType() {
        return CommandType.FILE_UPLOAD_REQUEST;
    }
}
