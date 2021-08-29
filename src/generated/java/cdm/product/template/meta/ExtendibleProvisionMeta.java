package cdm.product.template.meta;

import cdm.product.template.ExtendibleProvision;
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
@RosettaMeta(model=ExtendibleProvision.class)
public class ExtendibleProvisionMeta implements RosettaMetaData<ExtendibleProvision> {

	@Override
	public List<Validator<? super ExtendibleProvision>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.template.validation.datarule.ExtendibleProvisionExtendibleProvisionExerciseNoticeReceiverParty.class)
		);
	}

	@Override
	public List<Validator<? super ExtendibleProvision>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.template.validation.choicerule.ExtendibleProvisionExerciseChoice()
		);
	}
	
	@Override
	public List<Function<? super ExtendibleProvision, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExtendibleProvision> validator() {
		return new cdm.product.template.validation.ExtendibleProvisionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExtendibleProvision, Set<String>> onlyExistsValidator() {
		return new cdm.product.template.validation.exists.ExtendibleProvisionOnlyExistsValidator();
	}
}
