package cdm.observable.asset.meta;

import cdm.observable.asset.FloatingRateCalculationParameters;
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
@RosettaMeta(model=FloatingRateCalculationParameters.class)
public class FloatingRateCalculationParametersMeta implements RosettaMetaData<FloatingRateCalculationParameters> {

	@Override
	public List<Validator<? super FloatingRateCalculationParameters>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super FloatingRateCalculationParameters>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingRateCalculationParameters, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingRateCalculationParameters> validator() {
		return new cdm.observable.asset.validation.FloatingRateCalculationParametersValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateCalculationParameters, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.FloatingRateCalculationParametersOnlyExistsValidator();
	}
}
