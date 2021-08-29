package cdm.regulation;

import cdm.regulation.meta.QtyMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface Qty extends RosettaModelObject {
	Qty build();
	Qty.QtyBuilder toBuilder();
	
	/**
	 */
	String getUnit();
	final static QtyMeta metaData = new QtyMeta();
	
	@Override
	default RosettaMetaData<? extends Qty> metaData() {
		return metaData;
	} 
			
	static Qty.QtyBuilder builder() {
		return new Qty.QtyBuilderImpl();
	}
	
	default Class<? extends Qty> getType() {
		return Qty.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("unit"), String.class, getUnit(), this);
		
	}
	
	
	interface QtyBuilder extends Qty, RosettaModelObjectBuilder {
		Qty.QtyBuilder setUnit(String unit);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("unit"), String.class, getUnit(), this);
			
		}
		
	}
	
	//Qty.QtyImpl
	class QtyImpl implements Qty {
		private final String unit;
		
		protected QtyImpl(Qty.QtyBuilder builder) {
			this.unit = builder.getUnit();
		}
		
		@Override
		public String getUnit() {
			return unit;
		}
		
		@Override
		public Qty build() {
			return this;
		}
		
		@Override
		public Qty.QtyBuilder toBuilder() {
			Qty.QtyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Qty.QtyBuilder builder) {
			ofNullable(getUnit()).ifPresent(builder::setUnit);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Qty _that = getType().cast(o);
		
			if (!Objects.equals(unit, _that.getUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unit != null ? unit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Qty {" +
				"unit=" + this.unit +
			'}';
		}
	}
	
	//Qty.QtyBuilderImpl
	class QtyBuilderImpl implements Qty.QtyBuilder {
	
		protected String unit;
	
		public QtyBuilderImpl() {
		}
	
		@Override
		public String getUnit() {
			return unit;
		}
		
	
		@Override
		public Qty.QtyBuilder setUnit(String unit) {
			this.unit = unit==null?null:unit;
			return this;
		}
		
		@Override
		public Qty build() {
			return new Qty.QtyImpl(this);
		}
		
		@Override
		public Qty.QtyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Qty.QtyBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnit()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Qty.QtyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Qty.QtyBuilder o = (Qty.QtyBuilder) other;
			
			
			merger.mergeBasic(getUnit(), o.getUnit(), this::setUnit);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Qty _that = getType().cast(o);
		
			if (!Objects.equals(unit, _that.getUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unit != null ? unit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QtyBuilder {" +
				"unit=" + this.unit +
			'}';
		}
	}
}
