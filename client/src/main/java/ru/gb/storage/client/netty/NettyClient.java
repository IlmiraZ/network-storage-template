package ru.gb.storage.client.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import lombok.extern.slf4j.Slf4j;
import ru.gb.storage.commons.handler.JsonDecoder;
import ru.gb.storage.commons.handler.JsonEncoder;
import ru.gb.storage.commons.message.Message;

@Slf4j
public class NettyClient {
    private SocketChannel channel;
    private EventLoopGroup worker;
    public static NettyClient nettyClient;

    public NettyClient(CallBack callBack, String host, int port) {
        Thread thread = new Thread(() -> {
            worker = new NioEventLoopGroup();
            try {
                Bootstrap bootstrap = new Bootstrap();
                bootstrap.group(worker)
                        .channel(NioSocketChannel.class)
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel c) {
                                channel = c;
                                c.pipeline().addLast(
                                        new LengthFieldBasedFrameDecoder(1024 * 1024, 0, 10, 0, 10),
                                        new LengthFieldPrepender(10),
                                        new JsonDecoder(),
                                        new JsonEncoder(),
                                        new MessageHandler(callBack)
                                );
                            }
                        });
                ChannelFuture future = bootstrap.connect(host, port).sync();
                future.channel().closeFuture().sync();
            } catch (Exception e) {
                log.error("", e);
            } finally {
                close();
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    public void writeMessage(Message message) {
        channel.writeAndFlush(message);
    }

    public boolean isConnected() {
        return channel != null && channel.isActive();
    }

    public void close() {
        worker.shutdownGracefully();
    }


}



