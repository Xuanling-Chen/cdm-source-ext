package cdm.base.staticdata.party.validation;

import cdm.base.staticdata.party.Wallet;
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

public class WalletValidator implements Validator<Wallet> {

	@Override
	public ValidationResult<Wallet> validate(RosettaPath path, Wallet o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("accountGlobalRef", o.getAccountGlobalRef()!=null ? 1 : 0, 0, 1),
				checkCardinality("cards", o.getCards()==null?0:o.getCards().size(), 1, 0),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Wallet", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Wallet", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
