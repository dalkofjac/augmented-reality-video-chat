package com.example.augmentedrealityapp.services;

import com.example.augmentedrealityapp.BuildConfig;

import org.webrtc.PeerConnection;

import java.util.ArrayList;
import java.util.List;

public class IceServerService {
    public static List<PeerConnection.IceServer> getIceServers() {
        List<PeerConnection.IceServer> iceServers = new ArrayList<>();

        String[] stunServers = new String[] { BuildConfig.STUN_SERVER_1, BuildConfig.STUN_SERVER_2 };
        for (String iceServer : stunServers) {
            PeerConnection.IceServer peerIceServer = PeerConnection.IceServer.builder(iceServer).createIceServer();
            iceServers.add(peerIceServer);
        }

        String turnServerUrl = BuildConfig.TURN_SERVER_URL;
        if (turnServerUrl != null && !turnServerUrl.isEmpty()) {
            PeerConnection.IceServer peerIceServer = PeerConnection.IceServer.builder(turnServerUrl)
                    .setUsername(BuildConfig.TURN_SERVER_USERNAME)
                    .setPassword(BuildConfig.TURN_SERVER_CREDENTIAL)
                    .createIceServer();
            iceServers.add(peerIceServer);
        }

        return iceServers;
    }
}
