package cdm.base.staticdata.party.meta;

import cdm.base.staticdata.party.Bank;
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
@RosettaMeta(model=Bank.class)
public class BankMeta implements RosettaMetaData<Bank> {

	@Override
	public List<Validator<? super Bank>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Bank>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Bank, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Bank> validator() {
		return new cdm.base.staticdata.party.validation.BankValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Bank, Set<String>> onlyExistsValidator() {
		return new cdm.base.staticdata.party.validation.exists.BankOnlyExistsValidator();
	}
}
