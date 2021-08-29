package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.ParametricDates;
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

public class ParametricDatesValidator implements Validator<ParametricDates> {

	@Override
	public ValidationResult<ParametricDates> validate(RosettaPath path, ParametricDates o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("dayType", o.getDayType()!=null ? 1 : 0, 1, 1),
				checkCardinality("dayDistribution", o.getDayDistribution()!=null ? 1 : 0, 0, 1),
				checkCardinality("dayOfWeek", o.getDayOfWeek()==null?0:o.getDayOfWeek().size(), 0, 7),
				checkCardinality("dayFrequency", o.getDayFrequency()!=null ? 1 : 0, 0, 1),
				checkCardinality("lag", o.getLag()!=null ? 1 : 0, 0, 1),
				checkCardinality("businessCalendar", o.getBusinessCalendar()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ParametricDates", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ParametricDates", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
