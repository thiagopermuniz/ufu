package portals.ratis;

import org.apache.ratis.conf.RaftProperties;
import org.apache.ratis.grpc.GrpcConfigKeys;
import org.apache.ratis.protocol.RaftGroup;
import org.apache.ratis.protocol.RaftGroupId;
import org.apache.ratis.protocol.RaftPeer;
import org.apache.ratis.protocol.RaftPeerId;
import org.apache.ratis.server.RaftServer;
import org.apache.ratis.server.RaftServerConfigKeys;
import org.apache.ratis.thirdparty.com.google.protobuf.ByteString;
import org.apache.ratis.util.LifeCycle;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class RatisServer{

    public static void main(String args[]) throws IOException, InterruptedException {
        String raftGroupId = "raft_group___one";

        Map<String, InetSocketAddress> id2addr = new HashMap<>();
        id2addr.put("p1", new InetSocketAddress("127.0.0.1", 3456));
        id2addr.put("p2", new InetSocketAddress("127.0.0.1", 3457));

        List<RaftPeer> addresses = id2addr.entrySet()
                .stream()
                .map(e -> RaftPeer.newBuilder().setId(e.getKey()).setAddress(e.getValue()).build())
                .collect(Collectors.toList());

        RaftPeerId peerId1 = RaftPeerId.valueOf("p1");
        RaftPeerId peerId2 = RaftPeerId.valueOf("p2");

        new Thread("t1") {
            public void run(){
                RaftProperties properties1 = new RaftProperties();
                properties1.setInt(GrpcConfigKeys.OutputStream.RETRY_TIMES_KEY, Integer.MAX_VALUE);
                GrpcConfigKeys.Server.setPort(properties1, 1000);
                RaftServerConfigKeys.setStorageDir(properties1, Collections.singletonList(new File("/"+peerId1)));

                final RaftGroup raftGroup1 = RaftGroup.valueOf(RaftGroupId.valueOf(ByteString.copyFromUtf8(raftGroupId)), addresses);
                try {
                    RaftServer raftServer1 = RaftServer.newBuilder()
                            .setServerId(peerId1)
                            .setStateMachine(new StateMachine())
                            .setProperties(properties1)
                            .setGroup(raftGroup1)
                            .build();

                    raftServer1.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread("t2") {
            public void run(){
                RaftProperties properties2 = new RaftProperties();
                properties2.setInt(GrpcConfigKeys.OutputStream.RETRY_TIMES_KEY, Integer.MAX_VALUE);
                GrpcConfigKeys.Server.setPort(properties2, 1000);
                RaftServerConfigKeys.setStorageDir(properties2, Collections.singletonList(new File("/"+peerId2)));

                final RaftGroup raftGroup2 = RaftGroup.valueOf(RaftGroupId.valueOf(ByteString.copyFromUtf8(raftGroupId)), addresses);
                try {
                    RaftServer raftServer2 = RaftServer.newBuilder()
                            .setServerId(peerId2)
                            .setStateMachine(new StateMachine())
                            .setProperties(properties2)
                            .setGroup(raftGroup2)
                            .build();

                    raftServer2.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}