package cdm.legalagreement.csa.validation.datarule;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.OneWayProvisions;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

/**
 * @version ${project.version}
 */
@RosettaDataRule("OneWayProvisionsPostingPartyAbsent")
public class OneWayProvisionsPostingPartyAbsent implements Validator<OneWayProvisions> {
	
	private static final String NAME = "OneWayProvisionsPostingPartyAbsent";
	private static final String DEFINITION = "if isApplicable = False then postingParty is absent";
	
	
	@Override
	public ValidationResult<OneWayProvisions> validate(RosettaPath path, OneWayProvisions oneWayProvisions) {
		ComparisonResult result = executeDataRule(oneWayProvisions);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "OneWayProvisions", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "OneWayProvisions", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(OneWayProvisions oneWayProvisions) {
		if (ruleIsApplicable(oneWayProvisions).get()) {
			return evaluateThenExpression(oneWayProvisions);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(OneWayProvisions oneWayProvisions) {
		try {
			return areEqual(MapperS.of(oneWayProvisions).<Boolean>map("getIsApplicable", _oneWayProvisions -> _oneWayProvisions.getIsApplicable()), MapperS.of(Boolean.valueOf(false)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(OneWayProvisions oneWayProvisions) {
		try {
			return notExists(MapperS.of(oneWayProvisions).<CounterpartyRoleEnum>map("getPostingParty", _oneWayProvisions -> _oneWayProvisions.getPostingParty()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
