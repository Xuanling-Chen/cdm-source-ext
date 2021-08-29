package cdm.event.common.meta;

import cdm.event.common.State;
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
@RosettaMeta(model=State.class)
public class StateMeta implements RosettaMetaData<State> {

	@Override
	public List<Validator<? super State>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.event.common.validation.datarule.StateDataRule0.class)
		);
	}

	@Override
	public List<Validator<? super State>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super State, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super State> validator() {
		return new cdm.event.common.validation.StateValidator();
	}
	
	@Override
	public ValidatorWithArg<? super State, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.StateOnlyExistsValidator();
	}
}
