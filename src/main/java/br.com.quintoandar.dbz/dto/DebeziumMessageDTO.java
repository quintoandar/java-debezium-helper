package br.com.quintoandar.dbz.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DebeziumMessageDTO<T> {
    private DebeziumPayloadDTO<T> payload;
}
