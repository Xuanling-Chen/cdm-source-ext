package cdm.base.math.meta;

import cdm.base.math.NonNegativeQuantitySchedule;
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
@RosettaMeta(model=NonNegativeQuantitySchedule.class)
public class NonNegativeQuantityScheduleMeta implements RosettaMetaData<NonNegativeQuantitySchedule> {

	@Override
	public List<Validator<? super NonNegativeQuantitySchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.base.math.validation.datarule.NonNegativeQuantityScheduleNonNegativeQuantityAmount.class)
		);
	}

	@Override
	public List<Validator<? super NonNegativeQuantitySchedule>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonNegativeQuantitySchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NonNegativeQuantitySchedule> validator() {
		return new cdm.base.math.validation.NonNegativeQuantityScheduleValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonNegativeQuantitySchedule, Set<String>> onlyExistsValidator() {
		return new cdm.base.math.validation.exists.NonNegativeQuantityScheduleOnlyExistsValidator();
	}
}
