package cdm.legalagreement.csa.validation.datarule;

import cdm.base.datetime.CustomisableOffset;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.ExceptionEnum;
import cdm.legalagreement.csa.PledgeeRepresentativeRider;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.mapper.MapperTree;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("PledgeeRepresentativeRiderrepresentativeParty")
public class PledgeeRepresentativeRiderrepresentativeParty implements Validator<PledgeeRepresentativeRider> {
	
	private static final String NAME = "PledgeeRepresentativeRiderrepresentativeParty";
	private static final String DEFINITION = "if isApplicable = True then (party and representativeTerms and representativeEvent and representativeEndDate) exists";
	
	
	@Override
	public ValidationResult<PledgeeRepresentativeRider> validate(RosettaPath path, PledgeeRepresentativeRider pledgeeRepresentativeRider) {
		ComparisonResult result = executeDataRule(pledgeeRepresentativeRider);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "PledgeeRepresentativeRider", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PledgeeRepresentativeRider", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(PledgeeRepresentativeRider pledgeeRepresentativeRider) {
		if (ruleIsApplicable(pledgeeRepresentativeRider).get()) {
			return evaluateThenExpression(pledgeeRepresentativeRider);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(PledgeeRepresentativeRider pledgeeRepresentativeRider) {
		try {
			return areEqual(MapperS.of(pledgeeRepresentativeRider).<Boolean>map("getIsApplicable", _pledgeeRepresentativeRider -> _pledgeeRepresentativeRider.getIsApplicable()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(PledgeeRepresentativeRider pledgeeRepresentativeRider) {
		try {
			return exists(MapperTree.andDifferent(MapperTree.andDifferent(MapperTree.andDifferent(MapperTree.of(MapperS.of(pledgeeRepresentativeRider).<CounterpartyRoleEnum>map("getParty", _pledgeeRepresentativeRider -> _pledgeeRepresentativeRider.getParty())), MapperTree.of(MapperS.of(pledgeeRepresentativeRider).<String>map("getRepresentativeTerms", _pledgeeRepresentativeRider -> _pledgeeRepresentativeRider.getRepresentativeTerms()))), MapperTree.of(MapperS.of(pledgeeRepresentativeRider).<ExceptionEnum>map("getRepresentativeEvent", _pledgeeRepresentativeRider -> _pledgeeRepresentativeRider.getRepresentativeEvent()))), MapperTree.of(MapperS.of(pledgeeRepresentativeRider).<CustomisableOffset>map("getRepresentativeEndDate", _pledgeeRepresentativeRider -> _pledgeeRepresentativeRider.getRepresentativeEndDate()))));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
