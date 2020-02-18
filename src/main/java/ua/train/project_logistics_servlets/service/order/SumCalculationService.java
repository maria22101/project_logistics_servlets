package ua.train.project_logistics_servlets.service.order;

import ua.train.project_logistics_servlets.persistence.domain.Route;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static ua.train.project_logistics_servlets.constant.BusinessInputConstant.*;

public class SumCalculationService {

    public BigDecimal calculateSum(BigDecimal weight, Route route) {
        return route.getBasicRate()
                .multiply(getWeightRateCoefficient(weight))
                .setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal getWeightRateCoefficient(BigDecimal weight) {

        BigDecimal weightRateCoefficient;

        if (weight.compareTo(new BigDecimal(WEIGHT_LIGHT_UPPER_BOUND)
                .setScale(2, RoundingMode.HALF_UP)) <= 0) {
            weightRateCoefficient = new BigDecimal(WEIGHT_LIGHT_COEFFICIENT)
                    .setScale(2, RoundingMode.HALF_UP);

        } else if (weight.compareTo(new BigDecimal(WEIGHT_MEDIUM_UPPER_BOUND)
                .setScale(2, RoundingMode.HALF_UP)) <= 0) {
            weightRateCoefficient = new BigDecimal(WEIGHT_MEDIUM_COEFFICIENT)
                    .setScale(2, RoundingMode.HALF_UP);

        } else {
            weightRateCoefficient = new BigDecimal(WEIGHT_HEAVY_COEFFICIENT)
                    .setScale(2, RoundingMode.HALF_UP);
        }

        return weightRateCoefficient;
    }
}
