package cdm.product.common.functions;

import cdm.product.common.functions.Qualify_BaseProduct_IRSwap;
import cdm.product.common.functions.Qualify_SubProduct_FixedFloat;
import cdm.product.common.functions.Qualify_Transaction_OIS;
import cdm.product.common.functions.Qualify_Transaction_ZeroCoupon;
import cdm.product.template.EconomicTerms;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_InterestRate_IRSwap_FixedFloat.Qualify_InterestRate_IRSwap_FixedFloatDefault.class)
public abstract class Qualify_InterestRate_IRSwap_FixedFloat implements RosettaFunction, IQualifyFunctionExtension<EconomicTerms> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Qualify_BaseProduct_IRSwap qualify_BaseProduct_IRSwap;
	@Inject protected Qualify_SubProduct_FixedFloat qualify_SubProduct_FixedFloat;
	@Inject protected Qualify_Transaction_OIS qualify_Transaction_OIS;
	@Inject protected Qualify_Transaction_ZeroCoupon qualify_Transaction_ZeroCoupon;

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
		is_product = areEqual(MapperS.of(qualify_BaseProduct_IRSwap.evaluate(MapperS.of(economicTerms).get())), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All).and(areEqual(MapperS.of(qualify_SubProduct_FixedFloat.evaluate(MapperS.of(economicTerms).get())), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All)).and(areEqual(MapperS.of(qualify_Transaction_ZeroCoupon.evaluate(MapperS.of(economicTerms).get())), MapperS.of(Boolean.valueOf(false)), CardinalityOperator.All)).and(areEqual(MapperS.of(qualify_Transaction_OIS.evaluate(MapperS.of(economicTerms).get())), MapperS.of(Boolean.valueOf(false)), CardinalityOperator.All)).get();
		return is_product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);
	
	public static final class Qualify_InterestRate_IRSwap_FixedFloatDefault extends Qualify_InterestRate_IRSwap_FixedFloat {
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
