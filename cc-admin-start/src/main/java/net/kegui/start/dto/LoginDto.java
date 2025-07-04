package net.kegui.start.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LoginDto(
    @NotBlank(message = "用户名不能为空")
    @Size(min = 5, message = "用户名长度不能小于5个字符")
    String username,

    @NotBlank(message = "密码不能为空")
    @Size(min = 6, message = "密码长度不能小于6个字符")
    String password
) {

}
