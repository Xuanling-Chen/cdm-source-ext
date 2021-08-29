package cdm.product.common.schedule.validation;

import cdm.product.common.schedule.DateRelativeToPaymentDates;
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

public class DateRelativeToPaymentDatesValidator implements Validator<DateRelativeToPaymentDates> {

	@Override
	public ValidationResult<DateRelativeToPaymentDates> validate(RosettaPath path, DateRelativeToPaymentDates o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("paymentDatesReference", o.getPaymentDatesReference()==null?0:o.getPaymentDatesReference().size(), 1, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("DateRelativeToPaymentDates", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("DateRelativeToPaymentDates", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
