package ru.gb.storage.commons.message;

public enum CommandType {
    FILE_LIST_REQUEST,
    FILE_LIST_RESPONSE,
    DIR_CREATE_REQUEST,
    DIR_CREATE_RESPONSE,
    DIR_UP_REQUEST,
    DIR_UP_RESPONSE,
    DIR_DOWN_REQUEST,
    DIR_DOWN_RESPONSE,
    FILE_UPLOAD_REQUEST,
    FILE_UPLOAD_RESPONSE,
    FILE_DOWNLOAD_REQUEST,
    FILE_DOWNLOAD_RESPONSE,
    FILE_DELETE_REQUEST,
    FILE_DELETE_RESPONSE,
    AUTH_REQUEST,
    AUTH_RESPONSE
}