package cdm.event.common.meta;

import cdm.event.common.ExerciseEvent;
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
@RosettaMeta(model=ExerciseEvent.class)
public class ExerciseEventMeta implements RosettaMetaData<ExerciseEvent> {

	@Override
	public List<Validator<? super ExerciseEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ExerciseEvent>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExerciseEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExerciseEvent> validator() {
		return new cdm.event.common.validation.ExerciseEventValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExerciseEvent, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.ExerciseEventOnlyExistsValidator();
	}
}
