package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.ProcessAgentElection;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;

public class ProcessAgentElectionValidator implements Validator<ProcessAgentElection> {

	@Override
	public ValidationResult<ProcessAgentElection> validate(RosettaPath path, ProcessAgentElection o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", o.getParty()!=null ? 1 : 0, 1, 1),
				checkCardinality("isApplicable", o.getIsApplicable()!=null ? 1 : 0, 1, 1),
				checkCardinality("processAgent", o.getProcessAgent()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ProcessAgentElection", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ProcessAgentElection", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}