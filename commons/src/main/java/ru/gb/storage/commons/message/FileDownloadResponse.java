package ru.gb.storage.commons.message;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@EqualsAndHashCode(callSuper = true)
@Data
public class FileDownloadResponse extends Message {
    private final String name;
    public final byte[] content;

    public FileDownloadResponse(Path path) throws IOException {
        this.name = path.getFileName().toString();
        this.content = Files.readAllBytes(path);
    }

    @Override
    public CommandType getType() {
        return CommandType.FILE_DOWNLOAD_RESPONSE;
    }
}
