package cdm.base.staticdata.party.meta;

import cdm.base.staticdata.party.Card;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

/**
 * @version ${project.version}
 */
@RosettaMeta(model=Card.class)
public class CardMeta implements RosettaMetaData<Card> {

	@Override
	public List<Validator<? super Card>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Card>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Card, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Card> validator() {
		return new cdm.base.staticdata.party.validation.CardValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Card, Set<String>> onlyExistsValidator() {
		return new cdm.base.staticdata.party.validation.exists.CardOnlyExistsValidator();
	}
}
