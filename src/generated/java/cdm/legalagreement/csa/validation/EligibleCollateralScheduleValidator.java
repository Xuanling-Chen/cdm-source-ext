package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.EligibleCollateralSchedule;
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

public class EligibleCollateralScheduleValidator implements Validator<EligibleCollateralSchedule> {

	@Override
	public ValidationResult<EligibleCollateralSchedule> validate(RosettaPath path, EligibleCollateralSchedule o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("scheduleIdentifier", o.getScheduleIdentifier()==null?0:o.getScheduleIdentifier().size(), 0, 0),
				checkCardinality("criteria", o.getCriteria()==null?0:o.getCriteria().size(), 1, 0),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("EligibleCollateralSchedule", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("EligibleCollateralSchedule", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
