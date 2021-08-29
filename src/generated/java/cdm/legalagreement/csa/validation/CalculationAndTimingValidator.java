package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.CalculationAndTiming;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;

public class CalculationAndTimingValidator implements Validator<CalculationAndTiming> {

	@Override
	public ValidationResult<CalculationAndTiming> validate(RosettaPath path, CalculationAndTiming o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationAgentTerms", o.getCalculationAgentTerms()!=null ? 1 : 0, 0, 1),
				checkCardinality("bespokeCalculationDate", o.getBespokeCalculationDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("bespokeCalculationTime", o.getBespokeCalculationTime()!=null ? 1 : 0, 0, 1),
				checkCardinality("calculationDateLocation", o.getCalculationDateLocation()!=null ? 1 : 0, 0, 1),
				checkCardinality("notificationTime", o.getNotificationTime()!=null ? 1 : 0, 1, 1),
				checkCardinality("collateralValuationAgent", o.getCollateralValuationAgent()!=null ? 1 : 0, 0, 1),
				checkCardinality("cashSettlementDay", o.getCashSettlementDay()!=null ? 1 : 0, 0, 1),
				checkCardinality("securitiesSettlementDay", o.getSecuritiesSettlementDay()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CalculationAndTiming", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CalculationAndTiming", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
