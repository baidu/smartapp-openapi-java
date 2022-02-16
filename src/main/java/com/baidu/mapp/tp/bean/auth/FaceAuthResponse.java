package com.baidu.mapp.tp.bean.auth;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-11-9 18:40
 **/
@Data
public class FaceAuthResponse {
    private String qrcode;
    private String timeout;
    private String legalFaceStatus;
}
