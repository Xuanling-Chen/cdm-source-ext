package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.SubstitutedRegime;
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

public class SubstitutedRegimeValidator implements Validator<SubstitutedRegime> {

	@Override
	public ValidationResult<SubstitutedRegime> validate(RosettaPath path, SubstitutedRegime o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("regime", o.getRegime()!=null ? 1 : 0, 0, 1),
				checkCardinality("additionalRegime", o.getAdditionalRegime()!=null ? 1 : 0, 0, 1),
				checkCardinality("regimeTerms", o.getRegimeTerms()==null?0:o.getRegimeTerms().size(), 2, 2)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("SubstitutedRegime", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("SubstitutedRegime", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
