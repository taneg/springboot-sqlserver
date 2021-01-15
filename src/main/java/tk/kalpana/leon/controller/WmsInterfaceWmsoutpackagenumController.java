package tk.kalpana.leon.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.kalpana.leon.common.Result;
import tk.kalpana.leon.entity.WmsInterfaceWmsoutpackagenum;
import tk.kalpana.leon.service.WmsInterfaceWmsoutpackagenumService;


@RestController
@RequestMapping("/wms")
@RequiredArgsConstructor
@Slf4j
public class WmsInterfaceWmsoutpackagenumController {

    private final WmsInterfaceWmsoutpackagenumService wmsInterfaceWmsoutpackagenumService;

    @PostMapping("/list/{barCode}")
    public Result<WmsInterfaceWmsoutpackagenum> list(@PathVariable(value = "barCode") String barCode) {
        QueryWrapper<WmsInterfaceWmsoutpackagenum> wrapper = new QueryWrapper<>(WmsInterfaceWmsoutpackagenum.builder()
        .barcode(barCode).build());
        WmsInterfaceWmsoutpackagenum wmsOutPackageNum = wmsInterfaceWmsoutpackagenumService.getOne(wrapper);
        if(wmsOutPackageNum == null){
            log.error("barCode = {}不存在", barCode);
            throw new RuntimeException(String.format("barCode = %s的数据不存在", barCode));
        }
        return Result.ok(wmsOutPackageNum);
    }
}
