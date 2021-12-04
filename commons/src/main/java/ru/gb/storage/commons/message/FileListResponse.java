package ru.gb.storage.commons.message;


import ru.gb.storage.commons.file.FileInfo;

import java.util.List;

public class FileListResponse extends Message {
    private final List<FileInfo> fileInfoList;

    @Override
    public CommandType getType() {
        return CommandType.FILE_LIST_RESPONSE;
    }

    public FileListResponse(List<FileInfo> fileInfoList) {
        this.fileInfoList = fileInfoList;
    }

    public List<FileInfo> getFileInfoList() {
        return fileInfoList;
    }
}
