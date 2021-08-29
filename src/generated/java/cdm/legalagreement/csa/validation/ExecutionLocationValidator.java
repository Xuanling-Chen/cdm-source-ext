package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.ExecutionLocation;
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

public class ExecutionLocationValidator implements Validator<ExecutionLocation> {

	@Override
	public ValidationResult<ExecutionLocation> validate(RosettaPath path, ExecutionLocation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("executionLocation", o.getExecutionLocation()!=null ? 1 : 0, 1, 1),
				checkCardinality("otherLanguage", o.getOtherLanguage()!=null ? 1 : 0, 0, 1),
				checkCardinality("dutyPayer", o.getDutyPayer()!=null ? 1 : 0, 0, 1),
				checkCardinality("dutyPayerLanguage", o.getDutyPayerLanguage()!=null ? 1 : 0, 0, 1),
				checkCardinality("dutyPaymentDate", o.getDutyPaymentDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("dutyPaymentLanguage", o.getDutyPaymentLanguage()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ExecutionLocation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ExecutionLocation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
