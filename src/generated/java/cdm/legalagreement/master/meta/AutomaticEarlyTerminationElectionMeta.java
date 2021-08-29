package cdm.legalagreement.master.meta;

import cdm.legalagreement.master.AutomaticEarlyTerminationElection;
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
@RosettaMeta(model=AutomaticEarlyTerminationElection.class)
public class AutomaticEarlyTerminationElectionMeta implements RosettaMetaData<AutomaticEarlyTerminationElection> {

	@Override
	public List<Validator<? super AutomaticEarlyTerminationElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super AutomaticEarlyTerminationElection>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AutomaticEarlyTerminationElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AutomaticEarlyTerminationElection> validator() {
		return new cdm.legalagreement.master.validation.AutomaticEarlyTerminationElectionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AutomaticEarlyTerminationElection, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.master.validation.exists.AutomaticEarlyTerminationElectionOnlyExistsValidator();
	}
}
