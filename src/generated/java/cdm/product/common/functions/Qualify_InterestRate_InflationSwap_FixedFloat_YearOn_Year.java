package cdm.product.common.functions;

import cdm.product.common.functions.Qualify_BaseProduct_Inflation;
import cdm.product.common.functions.Qualify_SubProduct_FixedFloat;
import cdm.product.common.functions.Qualify_Transaction_YoY;
import cdm.product.template.EconomicTerms;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_InterestRate_InflationSwap_FixedFloat_YearOn_Year.Qualify_InterestRate_InflationSwap_FixedFloat_YearOn_YearDefault.class)
public abstract class Qualify_InterestRate_InflationSwap_FixedFloat_YearOn_Year implements RosettaFunction, IQualifyFunctionExtension<EconomicTerms> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Qualify_BaseProduct_Inflation qualify_BaseProduct_Inflation;
	@Inject protected Qualify_SubProduct_FixedFloat qualify_SubProduct_FixedFloat;
	@Inject protected Qualify_Transaction_YoY qualify_Transaction_YoY;

	/**
	* @param economicTerms 
	* @return is_product 
	*/
	public Boolean evaluate(EconomicTerms economicTerms) {
		
		Boolean is_productHolder = doEvaluate(economicTerms);
		Boolean is_product = assignOutput(is_productHolder, economicTerms);
		
		return is_product;
	}
	
	private Boolean assignOutput(Boolean is_product, EconomicTerms economicTerms) {
		is_product = areEqual(MapperS.of(qualify_BaseProduct_Inflation.evaluate(MapperS.of(economicTerms).get())), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All).and(areEqual(MapperS.of(qualify_SubProduct_FixedFloat.evaluate(MapperS.of(economicTerms).get())), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All)).and(areEqual(MapperS.of(qualify_Transaction_YoY.evaluate(MapperS.of(economicTerms).get())), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All)).get();
		return is_product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);
	
	public static final class Qualify_InterestRate_InflationSwap_FixedFloat_YearOn_YearDefault extends Qualify_InterestRate_InflationSwap_FixedFloat_YearOn_Year {
		@Override
		protected  Boolean doEvaluate(EconomicTerms economicTerms) {
			return null;
		}
	}
	
	@Override
	public String getNamePrefix() {
		return "Qualify";
	}
}
