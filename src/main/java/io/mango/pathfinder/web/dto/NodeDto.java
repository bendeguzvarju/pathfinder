package io.mango.pathfinder.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NodeDto {
    @NotNull
    @NotEmpty
    private int x;
    @NotNull
    @NotEmpty
    private int y;
}
