package im.turms.turms.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class StatisticsRecordDTO {
    private Date startDate;
    private Date endDate;
    private Long total;
}
