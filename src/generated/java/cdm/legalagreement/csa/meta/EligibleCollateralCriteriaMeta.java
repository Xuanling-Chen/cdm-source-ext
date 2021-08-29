package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.EligibleCollateralCriteria;
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
@RosettaMeta(model=EligibleCollateralCriteria.class)
public class EligibleCollateralCriteriaMeta implements RosettaMetaData<EligibleCollateralCriteria> {

	@Override
	public List<Validator<? super EligibleCollateralCriteria>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super EligibleCollateralCriteria>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EligibleCollateralCriteria, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EligibleCollateralCriteria> validator() {
		return new cdm.legalagreement.csa.validation.EligibleCollateralCriteriaValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EligibleCollateralCriteria, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.EligibleCollateralCriteriaOnlyExistsValidator();
	}
}
