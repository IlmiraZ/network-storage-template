package ru.gb.storage.client.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import ru.gb.storage.commons.message.Message;

@Slf4j
public class MessageHandler extends SimpleChannelInboundHandler<Message> {
    private final CallBack callBack;

    public MessageHandler(CallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message message) {
        callBack.call(message);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("NettyClient exception", cause);
        ctx.close();
    }
}
