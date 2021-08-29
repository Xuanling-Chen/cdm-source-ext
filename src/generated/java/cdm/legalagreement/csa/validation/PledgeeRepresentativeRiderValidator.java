package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.PledgeeRepresentativeRider;
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

public class PledgeeRepresentativeRiderValidator implements Validator<PledgeeRepresentativeRider> {

	@Override
	public ValidationResult<PledgeeRepresentativeRider> validate(RosettaPath path, PledgeeRepresentativeRider o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("isApplicable", o.getIsApplicable()!=null ? 1 : 0, 1, 1),
				checkCardinality("party", o.getParty()!=null ? 1 : 0, 0, 1),
				checkCardinality("representativeTerms", o.getRepresentativeTerms()!=null ? 1 : 0, 0, 1),
				checkCardinality("representativeEvent", o.getRepresentativeEvent()!=null ? 1 : 0, 0, 1),
				checkCardinality("representativeEventTerms", o.getRepresentativeEventTerms()!=null ? 1 : 0, 0, 1),
				checkCardinality("representativeEndDate", o.getRepresentativeEndDate()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("PledgeeRepresentativeRider", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("PledgeeRepresentativeRider", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
