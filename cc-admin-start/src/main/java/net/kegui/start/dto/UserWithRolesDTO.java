package net.kegui.start.dto;

import net.kegui.start.entity.SysRole;

import java.io.Serializable;
import java.util.List;

public record UserWithRolesDTO(
        Long userId,
        String username,
        List<SysRole> roles
) implements Serializable {}