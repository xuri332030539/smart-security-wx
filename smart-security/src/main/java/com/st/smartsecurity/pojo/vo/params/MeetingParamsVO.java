package com.st.smartsecurity.pojo.vo.params;

import com.qs.common.mysql.pager.dto.PagerReqDto;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 会议列表查询参数
 * @author lhm
 */
@Data
@ApiModel(value = "会议列表查询参数")
public class MeetingParamsVO extends PagerReqDto {

}
