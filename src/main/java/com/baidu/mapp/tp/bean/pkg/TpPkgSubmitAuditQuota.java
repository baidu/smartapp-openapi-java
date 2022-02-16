package com.baidu.mapp.tp.bean.pkg;

import lombok.Data;

/**
 * @description:
 * @author: chenhaonan02
 * @create: 2021-10-27 17:23
 **/
@Data
public class TpPkgSubmitAuditQuota {
    private Integer quotaType;
    private Integer quotaTimes;
    private Integer remainTimes;
}
