package com.baidu.mapp.developer.login;

import com.baidu.mapp.common.error.GetAccessTokenException;
import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.developer.bean.login.AccessToken;

public class SmartAppGetAccessToken {
    public static void main(String[] args) {
        SmartAppClient smartAppClient = new SmartAppClient();
        String clientID = "MXF3axvo1TTGU6qCMMhEjvFBkFzjO7Z";
        String clientSecret = "9ojk037mRnxR199T4qYVEeBY=7gZXFHzpvz0";
        try {
            AccessToken accessToken = smartAppClient.getLoginService().getGetAccessToken(clientID, clientSecret);
            System.out.println(accessToken);
        } catch (GetAccessTokenException e) {
            e.printStackTrace();
        }

    }
}
