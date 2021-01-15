package tk.kalpana.leon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class WmsInterfaceWmsoutpackagenum {
    @TableId
    private Integer kid;
    private String oid;
    private String ocode;
    private Integer packageNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date insertTime;
    private Integer outFlag;
    private String barcode;
    private BigDecimal weight;
}
