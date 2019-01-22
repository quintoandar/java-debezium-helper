package br.com.quintoandar.dbz.dto;

import br.com.quintoandar.dbz.converter.Converter;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class DebeziumOperationConverter implements Converter<String, DebeziumOperation> {
    private Map<String, DebeziumOperation> mapOperationDebezium;

    public DebeziumOperationConverter() {
        this.mapOperationDebezium = Arrays.stream(DebeziumOperation.values())
                                          .collect(Collectors.toMap(
                                                  dbzOperation -> dbzOperation.getOperationIdentifier(),
                                                  dbzOperation -> dbzOperation));
    }

    @Override
    public DebeziumOperation convert(String op) {
        if (op == null) {
            return DebeziumOperation.UNESPECIFIED;
        }

        return this.mapOperationDebezium.get(op);
    }
}
