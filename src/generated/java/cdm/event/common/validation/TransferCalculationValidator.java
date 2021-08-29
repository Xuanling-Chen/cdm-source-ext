package cdm.event.common.validation;

import cdm.event.common.TransferCalculation;
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

public class TransferCalculationValidator implements Validator<TransferCalculation> {

	@Override
	public ValidationResult<TransferCalculation> validate(RosettaPath path, TransferCalculation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("period", o.getPeriod()!=null ? 1 : 0, 0, 1),
				checkCardinality("lineage", o.getLineage()==null?0:o.getLineage().size(), 0, 0),
				checkCardinality("calculationOutcome", o.getCalculationOutcome()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("TransferCalculation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("TransferCalculation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
