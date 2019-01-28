package br.com.quintoandar.dbz.converter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class BigDecimalValueToCentsConverter implements Converter<BigDecimal, Long> {

    private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    /**
     * @param value A {@code BigDecimal} that represents a valid value in BRL (e.g. 1972.54). It cannot be {@code null}
     *              or negative.
     * @return The input converted to Brazilian cents as a {@code Long} (e.g. 197254).
     * @throws NullPointerException     Thrown when the input is {@code null}.
     * @throws IllegalArgumentException Thrown when the input negative.
     */
    public Long convert(@NonNull BigDecimal value) {
        if (value.signum() < 0) {
            throw new IllegalArgumentException("There's no such thing as negative money");
        }

        BigDecimal valueInCents = value.setScale(2, RoundingMode.FLOOR).multiply(ONE_HUNDRED);
        return valueInCents.longValue();
    }

}
