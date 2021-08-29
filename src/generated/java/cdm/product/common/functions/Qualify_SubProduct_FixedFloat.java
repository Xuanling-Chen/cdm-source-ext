package cdm.product.common.functions;

import cdm.observable.asset.FixedRateSpecification;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InflationRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_SubProduct_FixedFloat.Qualify_SubProduct_FixedFloatDefault.class)
public abstract class Qualify_SubProduct_FixedFloat implements RosettaFunction {

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
		is_product = areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRate", _rateSpecification -> _rateSpecification.getFixedRate()).resultCount()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.All).and(areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRate", _rateSpecification -> _rateSpecification.getFloatingRate()).resultCount()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.All)).or(areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRate", _rateSpecification -> _rateSpecification.getFixedRate()).resultCount()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.All).and(areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRate", _rateSpecification -> _rateSpecification.getInflationRate()).resultCount()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.All))).get();
		return is_product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);
	
	public static final class Qualify_SubProduct_FixedFloatDefault extends Qualify_SubProduct_FixedFloat {
		@Override
		protected  Boolean doEvaluate(EconomicTerms economicTerms) {
			return null;
		}
	}
}
