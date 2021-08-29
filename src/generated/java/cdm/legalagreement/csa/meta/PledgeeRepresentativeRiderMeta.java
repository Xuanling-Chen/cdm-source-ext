package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.PledgeeRepresentativeRider;
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
@RosettaMeta(model=PledgeeRepresentativeRider.class)
public class PledgeeRepresentativeRiderMeta implements RosettaMetaData<PledgeeRepresentativeRider> {

	@Override
	public List<Validator<? super PledgeeRepresentativeRider>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.PledgeeRepresentativeRiderrepresentativeParty.class),
			factory.create(cdm.legalagreement.csa.validation.datarule.PledgeeRepresentativeRiderrepresentativeEventTerms.class)
		);
	}

	@Override
	public List<Validator<? super PledgeeRepresentativeRider>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PledgeeRepresentativeRider, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PledgeeRepresentativeRider> validator() {
		return new cdm.legalagreement.csa.validation.PledgeeRepresentativeRiderValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PledgeeRepresentativeRider, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.PledgeeRepresentativeRiderOnlyExistsValidator();
	}
}
