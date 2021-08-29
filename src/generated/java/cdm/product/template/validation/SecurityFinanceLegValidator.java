package cdm.product.template.validation;

import cdm.product.template.SecurityFinanceLeg;
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

public class SecurityFinanceLegValidator implements Validator<SecurityFinanceLeg> {

	@Override
	public ValidationResult<SecurityFinanceLeg> validate(RosettaPath path, SecurityFinanceLeg o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementDate", o.getSettlementDate()!=null ? 1 : 0, 1, 1),
				checkCardinality("deliveryMethod", o.getDeliveryMethod()!=null ? 1 : 0, 1, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("SecurityFinanceLeg", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("SecurityFinanceLeg", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
