package cdm.base.datetime;

import cdm.base.datetime.meta.AdjustableRelativeOrPeriodicDatesMeta;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class giving the choice between defining a series of dates as an explicit list of dates together with applicable adjustments or as relative to some other series of (anchor) dates, or as a calculation period schedule.
 * @version ${project.version}
 */
@RosettaClass

public interface AdjustableRelativeOrPeriodicDates extends RosettaModelObject, GlobalKey {
	AdjustableRelativeOrPeriodicDates build();
	AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder toBuilder();
	
	/**
	 * A series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
	 */
	AdjustableDates getAdjustableDates();
	/**
	 */
	MetaFields getMeta();
	/**
	 * A calculation period schedule.
	 */
	PeriodicDates getPeriodicDates();
	/**
	 * A series of dates specified as some offset to another series of dates (the anchor dates).
	 */
	RelativeDates getRelativeDates();
	final static AdjustableRelativeOrPeriodicDatesMeta metaData = new AdjustableRelativeOrPeriodicDatesMeta();
	
	@Override
	default RosettaMetaData<? extends AdjustableRelativeOrPeriodicDates> metaData() {
		return metaData;
	} 
			
	static AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder builder() {
		return new AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilderImpl();
	}
	
	default Class<? extends AdjustableRelativeOrPeriodicDates> getType() {
		return AdjustableRelativeOrPeriodicDates.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("adjustableDates"), processor, AdjustableDates.class, getAdjustableDates());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("periodicDates"), processor, PeriodicDates.class, getPeriodicDates());
		processRosetta(path.newSubPath("relativeDates"), processor, RelativeDates.class, getRelativeDates());
	}
	
	
	interface AdjustableRelativeOrPeriodicDatesBuilder extends AdjustableRelativeOrPeriodicDates, RosettaModelObjectBuilder {
		AdjustableDates.AdjustableDatesBuilder getOrCreateAdjustableDates();
		AdjustableDates.AdjustableDatesBuilder getAdjustableDates();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		PeriodicDates.PeriodicDatesBuilder getOrCreatePeriodicDates();
		PeriodicDates.PeriodicDatesBuilder getPeriodicDates();
		RelativeDates.RelativeDatesBuilder getOrCreateRelativeDates();
		RelativeDates.RelativeDatesBuilder getRelativeDates();
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setAdjustableDates(AdjustableDates adjustableDates);
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setMeta(MetaFields meta);
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setPeriodicDates(PeriodicDates periodicDates);
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setRelativeDates(RelativeDates relativeDates);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("adjustableDates"), processor, AdjustableDates.AdjustableDatesBuilder.class, getAdjustableDates());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("periodicDates"), processor, PeriodicDates.PeriodicDatesBuilder.class, getPeriodicDates());
			processRosetta(path.newSubPath("relativeDates"), processor, RelativeDates.RelativeDatesBuilder.class, getRelativeDates());
		}
		
	}
	
	//AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesImpl
	class AdjustableRelativeOrPeriodicDatesImpl implements AdjustableRelativeOrPeriodicDates {
		private final AdjustableDates adjustableDates;
		private final MetaFields meta;
		private final PeriodicDates periodicDates;
		private final RelativeDates relativeDates;
		
		protected AdjustableRelativeOrPeriodicDatesImpl(AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder builder) {
			this.adjustableDates = ofNullable(builder.getAdjustableDates()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.periodicDates = ofNullable(builder.getPeriodicDates()).map(f->f.build()).orElse(null);
			this.relativeDates = ofNullable(builder.getRelativeDates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AdjustableDates getAdjustableDates() {
			return adjustableDates;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public PeriodicDates getPeriodicDates() {
			return periodicDates;
		}
		
		@Override
		public RelativeDates getRelativeDates() {
			return relativeDates;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates build() {
			return this;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder toBuilder() {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder builder) {
			ofNullable(getAdjustableDates()).ifPresent(builder::setAdjustableDates);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getPeriodicDates()).ifPresent(builder::setPeriodicDates);
			ofNullable(getRelativeDates()).ifPresent(builder::setRelativeDates);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableRelativeOrPeriodicDates _that = getType().cast(o);
		
			if (!Objects.equals(adjustableDates, _that.getAdjustableDates())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(periodicDates, _that.getPeriodicDates())) return false;
			if (!Objects.equals(relativeDates, _that.getRelativeDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustableDates != null ? adjustableDates.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (periodicDates != null ? periodicDates.hashCode() : 0);
			_result = 31 * _result + (relativeDates != null ? relativeDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableRelativeOrPeriodicDates {" +
				"adjustableDates=" + this.adjustableDates + ", " +
				"meta=" + this.meta + ", " +
				"periodicDates=" + this.periodicDates + ", " +
				"relativeDates=" + this.relativeDates +
			'}';
		}
	}
	
	//AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilderImpl
	class AdjustableRelativeOrPeriodicDatesBuilderImpl implements AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder, GlobalKeyBuilder {
	
		protected AdjustableDates.AdjustableDatesBuilder adjustableDates;
		protected MetaFields.MetaFieldsBuilder meta;
		protected PeriodicDates.PeriodicDatesBuilder periodicDates;
		protected RelativeDates.RelativeDatesBuilder relativeDates;
	
		public AdjustableRelativeOrPeriodicDatesBuilderImpl() {
		}
	
		@Override
		public AdjustableDates.AdjustableDatesBuilder getAdjustableDates() {
			return adjustableDates;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getOrCreateAdjustableDates() {
			AdjustableDates.AdjustableDatesBuilder result;
			if (adjustableDates!=null) {
				result = adjustableDates;
			}
			else {
				result = adjustableDates = AdjustableDates.builder();
			}
			
			return result;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@Override
		public PeriodicDates.PeriodicDatesBuilder getPeriodicDates() {
			return periodicDates;
		}
		
		@Override
		public PeriodicDates.PeriodicDatesBuilder getOrCreatePeriodicDates() {
			PeriodicDates.PeriodicDatesBuilder result;
			if (periodicDates!=null) {
				result = periodicDates;
			}
			else {
				result = periodicDates = PeriodicDates.builder();
			}
			
			return result;
		}
		
		@Override
		public RelativeDates.RelativeDatesBuilder getRelativeDates() {
			return relativeDates;
		}
		
		@Override
		public RelativeDates.RelativeDatesBuilder getOrCreateRelativeDates() {
			RelativeDates.RelativeDatesBuilder result;
			if (relativeDates!=null) {
				result = relativeDates;
			}
			else {
				result = relativeDates = RelativeDates.builder();
			}
			
			return result;
		}
		
	
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setAdjustableDates(AdjustableDates adjustableDates) {
			this.adjustableDates = adjustableDates==null?null:adjustableDates.toBuilder();
			return this;
		}
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setPeriodicDates(PeriodicDates periodicDates) {
			this.periodicDates = periodicDates==null?null:periodicDates.toBuilder();
			return this;
		}
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setRelativeDates(RelativeDates relativeDates) {
			this.relativeDates = relativeDates==null?null:relativeDates.toBuilder();
			return this;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates build() {
			return new AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesImpl(this);
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder prune() {
			if (adjustableDates!=null && !adjustableDates.prune().hasData()) adjustableDates = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (periodicDates!=null && !periodicDates.prune().hasData()) periodicDates = null;
			if (relativeDates!=null && !relativeDates.prune().hasData()) relativeDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustableDates()!=null && getAdjustableDates().hasData()) return true;
			if (getPeriodicDates()!=null && getPeriodicDates().hasData()) return true;
			if (getRelativeDates()!=null && getRelativeDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder o = (AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder) other;
			
			merger.mergeRosetta(getAdjustableDates(), o.getAdjustableDates(), this::setAdjustableDates);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getPeriodicDates(), o.getPeriodicDates(), this::setPeriodicDates);
			merger.mergeRosetta(getRelativeDates(), o.getRelativeDates(), this::setRelativeDates);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableRelativeOrPeriodicDates _that = getType().cast(o);
		
			if (!Objects.equals(adjustableDates, _that.getAdjustableDates())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(periodicDates, _that.getPeriodicDates())) return false;
			if (!Objects.equals(relativeDates, _that.getRelativeDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustableDates != null ? adjustableDates.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (periodicDates != null ? periodicDates.hashCode() : 0);
			_result = 31 * _result + (relativeDates != null ? relativeDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableRelativeOrPeriodicDatesBuilder {" +
				"adjustableDates=" + this.adjustableDates + ", " +
				"meta=" + this.meta + ", " +
				"periodicDates=" + this.periodicDates + ", " +
				"relativeDates=" + this.relativeDates +
			'}';
		}
	}
}
