package cdm.base.datetime.meta;

import cdm.base.datetime.PeriodRange;
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
@RosettaMeta(model=PeriodRange.class)
public class PeriodRangeMeta implements RosettaMetaData<PeriodRange> {

	@Override
	public List<Validator<? super PeriodRange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.base.datetime.validation.datarule.PeriodRangeDataRule0.class)
		);
	}

	@Override
	public List<Validator<? super PeriodRange>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PeriodRange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PeriodRange> validator() {
		return new cdm.base.datetime.validation.PeriodRangeValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PeriodRange, Set<String>> onlyExistsValidator() {
		return new cdm.base.datetime.validation.exists.PeriodRangeOnlyExistsValidator();
	}
}
