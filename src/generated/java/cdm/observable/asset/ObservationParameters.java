package cdm.observable.asset;

import cdm.observable.asset.meta.ObservationParametersMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Parameters on daily observed computed rates, specifically daily caps and floors. This type is used to represent modular computed rates in interestRatePayouts.
 * @version ${project.version}
 */
@RosettaClass

public interface ObservationParameters extends RosettaModelObject {
	ObservationParameters build();
	ObservationParameters.ObservationParametersBuilder toBuilder();
	
	/**
	 * A daily observation cap rate.
	 */
	BigDecimal getObservationCapRate();
	/**
	 * A daily observation floor rate.
	 */
	BigDecimal getObservationFloorRate();
	final static ObservationParametersMeta metaData = new ObservationParametersMeta();
	
	@Override
	default RosettaMetaData<? extends ObservationParameters> metaData() {
		return metaData;
	} 
			
	static ObservationParameters.ObservationParametersBuilder builder() {
		return new ObservationParameters.ObservationParametersBuilderImpl();
	}
	
	default Class<? extends ObservationParameters> getType() {
		return ObservationParameters.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("observationCapRate"), BigDecimal.class, getObservationCapRate(), this);
		processor.processBasic(path.newSubPath("observationFloorRate"), BigDecimal.class, getObservationFloorRate(), this);
		
	}
	
	
	interface ObservationParametersBuilder extends ObservationParameters, RosettaModelObjectBuilder {
		ObservationParameters.ObservationParametersBuilder setObservationCapRate(BigDecimal observationCapRate);
		ObservationParameters.ObservationParametersBuilder setObservationFloorRate(BigDecimal observationFloorRate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("observationCapRate"), BigDecimal.class, getObservationCapRate(), this);
			processor.processBasic(path.newSubPath("observationFloorRate"), BigDecimal.class, getObservationFloorRate(), this);
			
		}
		
	}
	
	//ObservationParameters.ObservationParametersImpl
	class ObservationParametersImpl implements ObservationParameters {
		private final BigDecimal observationCapRate;
		private final BigDecimal observationFloorRate;
		
		protected ObservationParametersImpl(ObservationParameters.ObservationParametersBuilder builder) {
			this.observationCapRate = builder.getObservationCapRate();
			this.observationFloorRate = builder.getObservationFloorRate();
		}
		
		@Override
		public BigDecimal getObservationCapRate() {
			return observationCapRate;
		}
		
		@Override
		public BigDecimal getObservationFloorRate() {
			return observationFloorRate;
		}
		
		@Override
		public ObservationParameters build() {
			return this;
		}
		
		@Override
		public ObservationParameters.ObservationParametersBuilder toBuilder() {
			ObservationParameters.ObservationParametersBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObservationParameters.ObservationParametersBuilder builder) {
			ofNullable(getObservationCapRate()).ifPresent(builder::setObservationCapRate);
			ofNullable(getObservationFloorRate()).ifPresent(builder::setObservationFloorRate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservationParameters _that = getType().cast(o);
		
			if (!Objects.equals(observationCapRate, _that.getObservationCapRate())) return false;
			if (!Objects.equals(observationFloorRate, _that.getObservationFloorRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationCapRate != null ? observationCapRate.hashCode() : 0);
			_result = 31 * _result + (observationFloorRate != null ? observationFloorRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationParameters {" +
				"observationCapRate=" + this.observationCapRate + ", " +
				"observationFloorRate=" + this.observationFloorRate +
			'}';
		}
	}
	
	//ObservationParameters.ObservationParametersBuilderImpl
	class ObservationParametersBuilderImpl implements ObservationParameters.ObservationParametersBuilder {
	
		protected BigDecimal observationCapRate;
		protected BigDecimal observationFloorRate;
	
		public ObservationParametersBuilderImpl() {
		}
	
		@Override
		public BigDecimal getObservationCapRate() {
			return observationCapRate;
		}
		
		@Override
		public BigDecimal getObservationFloorRate() {
			return observationFloorRate;
		}
		
	
		@Override
		public ObservationParameters.ObservationParametersBuilder setObservationCapRate(BigDecimal observationCapRate) {
			this.observationCapRate = observationCapRate==null?null:observationCapRate;
			return this;
		}
		@Override
		public ObservationParameters.ObservationParametersBuilder setObservationFloorRate(BigDecimal observationFloorRate) {
			this.observationFloorRate = observationFloorRate==null?null:observationFloorRate;
			return this;
		}
		
		@Override
		public ObservationParameters build() {
			return new ObservationParameters.ObservationParametersImpl(this);
		}
		
		@Override
		public ObservationParameters.ObservationParametersBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationParameters.ObservationParametersBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservationCapRate()!=null) return true;
			if (getObservationFloorRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationParameters.ObservationParametersBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ObservationParameters.ObservationParametersBuilder o = (ObservationParameters.ObservationParametersBuilder) other;
			
			
			merger.mergeBasic(getObservationCapRate(), o.getObservationCapRate(), this::setObservationCapRate);
			merger.mergeBasic(getObservationFloorRate(), o.getObservationFloorRate(), this::setObservationFloorRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservationParameters _that = getType().cast(o);
		
			if (!Objects.equals(observationCapRate, _that.getObservationCapRate())) return false;
			if (!Objects.equals(observationFloorRate, _that.getObservationFloorRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationCapRate != null ? observationCapRate.hashCode() : 0);
			_result = 31 * _result + (observationFloorRate != null ? observationFloorRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationParametersBuilder {" +
				"observationCapRate=" + this.observationCapRate + ", " +
				"observationFloorRate=" + this.observationFloorRate +
			'}';
		}
	}
}
