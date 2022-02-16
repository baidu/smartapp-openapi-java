package com.baidu.mapp.developer.riskcontrol;

import com.baidu.mapp.developer.SmartAppClient;
import com.baidu.mapp.common.error.OpenAPIErrorException;
import com.baidu.mapp.common.error.SmartAppErrorException;

public class SmartAppDetectRiskDemo {
    public static void main(String[] args) {
        String accessToken = "24.be46429d7c1bedc93bb139508f121c5c.2592000.1643351387.282335-24976143";
        try {
            SmartAppClient smartAppClient = new SmartAppClient();
            String res = smartAppClient.getRiskControlService().detectRisk(
                    accessToken,
                    "WXF3pGOvo1TTGU6qCMMhEjvFBkF2bO7Z",
                    "{\"key\":\"jU+mx2VJ" +
                            "9+k6+JfN6cLPNfQZIVbCAZwhMIlTtnt0yl+YTP" +
                            "K3E+70s79UwTqR3eKQEyKu5Qbd8xknxNNoYl8w9o/2/qemfUNn6pDXmsYnaZz4tM6k8bhR" +
                            "D3TusfOXXqXRo5gWuUdnWttnIhxvYKG" +
                            "whzL4sUF3fqnxY4S7PUnGE9g=\", \"value\": \"TPHtjm0RTDX1pUpcUjbhRu/t3" +
                            "MA59kF+mFv7DPmNSx0zMsTsT4Yitu+DoQ" +
                            "7CJS9f5tQBHpqzQ2vfW5nV9Zm7HWkkXK8xkF5jSTSEWH6KkLAMdzWwqLKZQTaWG6r" +
                            "+MU+9qOqYF4mc18oB8WSSfPJQ7ZUYpY+1Re" +
                            "zUMWK8xyUB/8vEy53HZ8SYZjsfmJOYNcVsh4A8fTsoHDsNBiXYA2KUe2ZxiSzmy" +
                            "LYe2EYjW2XLcL+iUgcToNuH834Ypn+Py0OxOD6lS" +
                            "2BgWVNV0sdGriYuRDAN7rcugPbVscFoEeOcDWIDaHNKs214vDvmQQCc6M7EXsQ3W/NDd" +
                            "ze94dgJ2AL0ZLV+3Ahe9ISoxflpRKjvl7Jl" +
                            "89+p6jESon4DLJA51/+n4FAbCifa5mZLvyHJ+gTSR2h0lLSZW2ZntrbeofVP7" +
                            "MZTYsPip0k1Kt0A7G/ABj0K1k0FIx0iM3UQWvPgFFOJ/vbCf4c1FXVDLHDid3V5qGwJ2TTRur9M" +
                            "JH1yVPiS5dltOQkIIAQcK3C+nTgi+EKY7RwwoOYw\"}",
                    "marketing",
                    "127.0.0.1",
                    1631928890,
                    "1",
                    "Mozilla/5.0 (Macintosh, Intel Mac OS X 10_12_6)" +
                            " AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.75 Safari/537.36",
                    "");
            System.out.println(res);
        } catch (SmartAppErrorException | OpenAPIErrorException e) {
            e.printStackTrace();
        }
    }
}
