package cdm.event.workflow.validation;

import cdm.event.workflow.EventTimestamp;
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

public class EventTimestampValidator implements Validator<EventTimestamp> {

	@Override
	public ValidationResult<EventTimestamp> validate(RosettaPath path, EventTimestamp o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("dateTime", o.getDateTime()!=null ? 1 : 0, 1, 1),
				checkCardinality("qualification", o.getQualification()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("EventTimestamp", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("EventTimestamp", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}