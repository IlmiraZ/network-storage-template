package ru.gb.storage.client.netty;

import ru.gb.storage.commons.message.Message;

public interface CallBack {
    void call(Message message);
}
