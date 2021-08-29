package cdm.event.common.validation;

import cdm.event.common.ExecutionPrimitive;
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

public class ExecutionPrimitiveValidator implements Validator<ExecutionPrimitive> {

	@Override
	public ValidationResult<ExecutionPrimitive> validate(RosettaPath path, ExecutionPrimitive o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("before", o.getBefore()==null?0:o.getBefore().size(), 0, 0),
				checkCardinality("after", o.getAfter()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ExecutionPrimitive", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ExecutionPrimitive", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
