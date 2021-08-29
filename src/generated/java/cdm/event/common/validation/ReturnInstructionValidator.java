package cdm.event.common.validation;

import cdm.event.common.ReturnInstruction;
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

public class ReturnInstructionValidator implements Validator<ReturnInstruction> {

	@Override
	public ValidationResult<ReturnInstruction> validate(RosettaPath path, ReturnInstruction o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("quantity", o.getQuantity()==null?0:o.getQuantity().size(), 1, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ReturnInstruction", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ReturnInstruction", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
