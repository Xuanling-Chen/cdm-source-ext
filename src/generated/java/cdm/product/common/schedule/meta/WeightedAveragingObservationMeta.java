package cdm.product.common.schedule.meta;

import cdm.product.common.schedule.WeightedAveragingObservation;
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
@RosettaMeta(model=WeightedAveragingObservation.class)
public class WeightedAveragingObservationMeta implements RosettaMetaData<WeightedAveragingObservation> {

	@Override
	public List<Validator<? super WeightedAveragingObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.common.schedule.validation.datarule.WeightedAveragingObservationPositiveObservationNumber.class),
			factory.create(cdm.product.common.schedule.validation.datarule.WeightedAveragingObservationPositiveWeight.class)
		);
	}

	@Override
	public List<Validator<? super WeightedAveragingObservation>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.common.schedule.validation.choicerule.WeightedAveragingObservationWeightedAveragingObservationChoice()
		);
	}
	
	@Override
	public List<Function<? super WeightedAveragingObservation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super WeightedAveragingObservation> validator() {
		return new cdm.product.common.schedule.validation.WeightedAveragingObservationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WeightedAveragingObservation, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.schedule.validation.exists.WeightedAveragingObservationOnlyExistsValidator();
	}
}
