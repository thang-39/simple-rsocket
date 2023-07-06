package org.thang.rsocket.service;

import io.rsocket.ConnectionSetupPayload;
import io.rsocket.RSocket;
import io.rsocket.SocketAcceptor;
import reactor.core.publisher.Mono;

public class SocketAcceptorImpl implements SocketAcceptor {
    @Override
    public Mono accept(ConnectionSetupPayload connectionSetupPayload,
                       RSocket rSocket) {
        System.out.println("SocketAcceptorImpl-accept method");
        return Mono.fromCallable(MathService::new);
    }
}
