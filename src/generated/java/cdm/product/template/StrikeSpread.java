package cdm.product.template;

import cdm.product.template.meta.StrikeSpreadMeta;
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
 * A class for defining a strike spread feature.
 * @version ${project.version}
 */
@RosettaClass

public interface StrikeSpread extends RosettaModelObject {
	StrikeSpread build();
	StrikeSpread.StrikeSpreadBuilder toBuilder();
	
	/**
	 * Upper strike in a strike spread.
	 */
	OptionStrike getUpperStrike();
	/**
	 * Number of options at the upper strike price in a strike spread.
	 */
	BigDecimal getUpperStrikeNumberOfOptions();
	final static StrikeSpreadMeta metaData = new StrikeSpreadMeta();
	
	@Override
	default RosettaMetaData<? extends StrikeSpread> metaData() {
		return metaData;
	} 
			
	static StrikeSpread.StrikeSpreadBuilder builder() {
		return new StrikeSpread.StrikeSpreadBuilderImpl();
	}
	
	default Class<? extends StrikeSpread> getType() {
		return StrikeSpread.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("upperStrikeNumberOfOptions"), BigDecimal.class, getUpperStrikeNumberOfOptions(), this);
		
		processRosetta(path.newSubPath("upperStrike"), processor, OptionStrike.class, getUpperStrike());
	}
	
	
	interface StrikeSpreadBuilder extends StrikeSpread, RosettaModelObjectBuilder {
		OptionStrike.OptionStrikeBuilder getOrCreateUpperStrike();
		OptionStrike.OptionStrikeBuilder getUpperStrike();
		StrikeSpread.StrikeSpreadBuilder setUpperStrike(OptionStrike upperStrike);
		StrikeSpread.StrikeSpreadBuilder setUpperStrikeNumberOfOptions(BigDecimal upperStrikeNumberOfOptions);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("upperStrikeNumberOfOptions"), BigDecimal.class, getUpperStrikeNumberOfOptions(), this);
			
			processRosetta(path.newSubPath("upperStrike"), processor, OptionStrike.OptionStrikeBuilder.class, getUpperStrike());
		}
		
	}
	
	//StrikeSpread.StrikeSpreadImpl
	class StrikeSpreadImpl implements StrikeSpread {
		private final OptionStrike upperStrike;
		private final BigDecimal upperStrikeNumberOfOptions;
		
		protected StrikeSpreadImpl(StrikeSpread.StrikeSpreadBuilder builder) {
			this.upperStrike = ofNullable(builder.getUpperStrike()).map(f->f.build()).orElse(null);
			this.upperStrikeNumberOfOptions = builder.getUpperStrikeNumberOfOptions();
		}
		
		@Override
		public OptionStrike getUpperStrike() {
			return upperStrike;
		}
		
		@Override
		public BigDecimal getUpperStrikeNumberOfOptions() {
			return upperStrikeNumberOfOptions;
		}
		
		@Override
		public StrikeSpread build() {
			return this;
		}
		
		@Override
		public StrikeSpread.StrikeSpreadBuilder toBuilder() {
			StrikeSpread.StrikeSpreadBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StrikeSpread.StrikeSpreadBuilder builder) {
			ofNullable(getUpperStrike()).ifPresent(builder::setUpperStrike);
			ofNullable(getUpperStrikeNumberOfOptions()).ifPresent(builder::setUpperStrikeNumberOfOptions);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StrikeSpread _that = getType().cast(o);
		
			if (!Objects.equals(upperStrike, _that.getUpperStrike())) return false;
			if (!Objects.equals(upperStrikeNumberOfOptions, _that.getUpperStrikeNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (upperStrike != null ? upperStrike.hashCode() : 0);
			_result = 31 * _result + (upperStrikeNumberOfOptions != null ? upperStrikeNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StrikeSpread {" +
				"upperStrike=" + this.upperStrike + ", " +
				"upperStrikeNumberOfOptions=" + this.upperStrikeNumberOfOptions +
			'}';
		}
	}
	
	//StrikeSpread.StrikeSpreadBuilderImpl
	class StrikeSpreadBuilderImpl implements StrikeSpread.StrikeSpreadBuilder {
	
		protected OptionStrike.OptionStrikeBuilder upperStrike;
		protected BigDecimal upperStrikeNumberOfOptions;
	
		public StrikeSpreadBuilderImpl() {
		}
	
		@Override
		public OptionStrike.OptionStrikeBuilder getUpperStrike() {
			return upperStrike;
		}
		
		@Override
		public OptionStrike.OptionStrikeBuilder getOrCreateUpperStrike() {
			OptionStrike.OptionStrikeBuilder result;
			if (upperStrike!=null) {
				result = upperStrike;
			}
			else {
				result = upperStrike = OptionStrike.builder();
			}
			
			return result;
		}
		
		@Override
		public BigDecimal getUpperStrikeNumberOfOptions() {
			return upperStrikeNumberOfOptions;
		}
		
	
		@Override
		public StrikeSpread.StrikeSpreadBuilder setUpperStrike(OptionStrike upperStrike) {
			this.upperStrike = upperStrike==null?null:upperStrike.toBuilder();
			return this;
		}
		@Override
		public StrikeSpread.StrikeSpreadBuilder setUpperStrikeNumberOfOptions(BigDecimal upperStrikeNumberOfOptions) {
			this.upperStrikeNumberOfOptions = upperStrikeNumberOfOptions==null?null:upperStrikeNumberOfOptions;
			return this;
		}
		
		@Override
		public StrikeSpread build() {
			return new StrikeSpread.StrikeSpreadImpl(this);
		}
		
		@Override
		public StrikeSpread.StrikeSpreadBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StrikeSpread.StrikeSpreadBuilder prune() {
			if (upperStrike!=null && !upperStrike.prune().hasData()) upperStrike = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUpperStrike()!=null && getUpperStrike().hasData()) return true;
			if (getUpperStrikeNumberOfOptions()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StrikeSpread.StrikeSpreadBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			StrikeSpread.StrikeSpreadBuilder o = (StrikeSpread.StrikeSpreadBuilder) other;
			
			merger.mergeRosetta(getUpperStrike(), o.getUpperStrike(), this::setUpperStrike);
			
			merger.mergeBasic(getUpperStrikeNumberOfOptions(), o.getUpperStrikeNumberOfOptions(), this::setUpperStrikeNumberOfOptions);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StrikeSpread _that = getType().cast(o);
		
			if (!Objects.equals(upperStrike, _that.getUpperStrike())) return false;
			if (!Objects.equals(upperStrikeNumberOfOptions, _that.getUpperStrikeNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (upperStrike != null ? upperStrike.hashCode() : 0);
			_result = 31 * _result + (upperStrikeNumberOfOptions != null ? upperStrikeNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StrikeSpreadBuilder {" +
				"upperStrike=" + this.upperStrike + ", " +
				"upperStrikeNumberOfOptions=" + this.upperStrikeNumberOfOptions +
			'}';
		}
	}
}
