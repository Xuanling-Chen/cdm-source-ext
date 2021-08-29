package cdm.base.datetime.meta;

import cdm.base.datetime.DateGroup;
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
@RosettaMeta(model=DateGroup.class)
public class DateGroupMeta implements RosettaMetaData<DateGroup> {

	@Override
	public List<Validator<? super DateGroup>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super DateGroup>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DateGroup, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DateGroup> validator() {
		return new cdm.base.datetime.validation.DateGroupValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DateGroup, Set<String>> onlyExistsValidator() {
		return new cdm.base.datetime.validation.exists.DateGroupOnlyExistsValidator();
	}
}
