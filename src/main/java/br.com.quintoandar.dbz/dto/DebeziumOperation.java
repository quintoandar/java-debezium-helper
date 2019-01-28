package br.com.quintoandar.dbz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DebeziumOperation {

    CREATED("c"),
    UPDATED("u"),
    DELETED("d"),
    UNESPECIFIED(null);

    private final String operationIdentifier;
}
