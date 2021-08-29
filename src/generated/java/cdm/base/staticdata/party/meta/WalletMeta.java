package cdm.base.staticdata.party.meta;

import cdm.base.staticdata.party.Wallet;
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
@RosettaMeta(model=Wallet.class)
public class WalletMeta implements RosettaMetaData<Wallet> {

	@Override
	public List<Validator<? super Wallet>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Wallet>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Wallet, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Wallet> validator() {
		return new cdm.base.staticdata.party.validation.WalletValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Wallet, Set<String>> onlyExistsValidator() {
		return new cdm.base.staticdata.party.validation.exists.WalletOnlyExistsValidator();
	}
}
