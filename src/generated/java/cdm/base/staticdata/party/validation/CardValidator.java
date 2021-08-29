package cdm.base.staticdata.party.validation;

import cdm.base.staticdata.party.Card;
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

public class CardValidator implements Validator<Card> {

	@Override
	public ValidationResult<Card> validate(RosettaPath path, Card o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("cardNumber", o.getCardNumber()!=null ? 1 : 0, 1, 1),
				checkCardinality("bankGlobalRef", o.getBankGlobalRef()!=null ? 1 : 0, 1, 1),
				checkCardinality("balance", o.getBalance()!=null ? 1 : 0, 1, 1),
				checkCardinality("currency", o.getCurrency()!=null ? 1 : 0, 1, 1),
				checkCardinality("isDefaultCard", o.getIsDefaultCard()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Card", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Card", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
