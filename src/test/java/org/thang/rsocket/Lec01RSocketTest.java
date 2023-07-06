    package org.thang.rsocket;

    import io.rsocket.Payload;
    import io.rsocket.RSocket;
    import io.rsocket.core.RSocketConnector;
    import io.rsocket.transport.netty.client.TcpClientTransport;
    import io.rsocket.util.DefaultPayload;
    import org.junit.jupiter.api.BeforeAll;
    import org.junit.jupiter.api.RepeatedTest;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    import reactor.core.publisher.Mono;
    import reactor.test.StepVerifier;

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    public class Lec01RSocketTest {

        private RSocket rSocket;

        @BeforeAll
        public void setup() {
            rSocket = RSocketConnector.create()
                    .connect(TcpClientTransport.create("localhost",6565))
                    .block();
        }

        @RepeatedTest(3)
        public void fireAndForget() {
            Payload payload = DefaultPayload.create("Hello World!");
            Mono<Void> mono = rSocket.fireAndForget(payload);

            StepVerifier.create(mono)
                    .verifyComplete();
        }
    }
