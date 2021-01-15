package tk.kalpana.leon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodeEnums {

    MISS_REQUEST_BODY(400001, "缺少请求体"),
    MISS_REQUEST_PARAM(400002, "缺少请求参数"),

    ;

    private final int code;
    private final String msg;

}
