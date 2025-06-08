package common;

import lombok.Data;

@Data
public class Result {
        private Boolean flag;

        private Integer code;

        private String message;

        private Object data;
}
