package portals.ratis;

import org.apache.ratis.client.RaftClient;
import org.apache.ratis.conf.Parameters;
import org.apache.ratis.conf.RaftProperties;
import org.apache.ratis.grpc.GrpcFactory;
import org.apache.ratis.protocol.*;
import org.apache.ratis.thirdparty.com.google.protobuf.ByteString;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class RatisClient {

    public String ratisExecute(String operation, String arg1, String arg2 ) throws Exception {
        String raftGroupId = "raft_group___one";

        Map<String, InetSocketAddress> id2addr = new HashMap<>();
        id2addr.put("p1", new InetSocketAddress("127.0.0.1", 3456));
        id2addr.put("p2", new InetSocketAddress("127.0.0.1", 3457));
        id2addr.put("p3", new InetSocketAddress("127.0.0.1", 3458));

        List<RaftPeer> addresses = id2addr.entrySet()
                .stream()
                .map(e -> RaftPeer.newBuilder().setId(e.getKey()).setAddress(e.getValue()).build())
                .collect(Collectors.toList());

        final RaftGroup raftGroup = RaftGroup.valueOf(RaftGroupId.valueOf(ByteString.copyFromUtf8(raftGroupId)), addresses);

        RaftProperties raftProperties = new RaftProperties();

        RaftClient client = RaftClient.newBuilder()
                .setProperties(raftProperties)
                .setRaftGroup(raftGroup)
                .setClientRpc(new GrpcFactory(new Parameters())
                .newRaftClientRpc(ClientId.randomId(), raftProperties))
                .build();

        RaftClientReply getValue;
        CompletableFuture<RaftClientReply> compGetValue;
        String response;

        switch (operation){
            case "add":
                getValue = client.io().send(Message.valueOf("add:" + arg1 + ":" + arg2));
                response = getValue.getMessage().getContent().toString(Charset.defaultCharset());
                System.out.println("Response:" + response);
                return response;
            case "get":
                getValue = client.io().sendReadOnly(Message.valueOf("get:" + arg1));
                response = getValue.getMessage().getContent().toString(Charset.defaultCharset());
                System.out.println("Response:" + response);
                return response;
            default:
                System.out.println("invalid command");
        }

        client.close();

        return "general error, try again later";
    }
}