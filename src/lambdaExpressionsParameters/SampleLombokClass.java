package lambdaExpressionsParameters;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.function.Consumer;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class SampleLombokClass implements Serializable {
    private static final long serialVersionUID = -1007459684190159575L;

    private static final SampleLombokClass EMPTY = new SampleLombokClass();

    private String a;
    private String b;

    private boolean isValid() {
        return !EMPTY.equals(this);
    }

    public SampleLombokClass onA(Runnable runnable) {
        if (this.isValid() && "A".equals(this.a)) {
            runnable.run();
            return this.EMPTY;
        } else {
            return this;
        }
    }

    public SampleLombokClass onA(Consumer<SampleLombokClass> consumer) {
        if (this.isValid() && "A".equals(this.a)) {
            consumer.accept(this);
            return this.EMPTY;
        } else {
            return this;
        }
    }

    public SampleLombokClass onB(Runnable runnable) {
        if (this.isValid() && "B".equals(this.b)) {
            runnable.run();
            return this.EMPTY;
        } else {
            return this;
        }
    }

    public SampleLombokClass onB(Consumer<SampleLombokClass> consumer) {
        if (this.isValid() && "B".equals(this.b)) {
            consumer.accept(this);
            return this.EMPTY;
        } else {
            return this;
        }
    }

    public void onLast(Runnable runnable) {
        if (this.isValid()) {
            runnable.run();
        }
    }

    public void onLast(Consumer<SampleLombokClass> consumer) {
        if (this.isValid()) {
            consumer.accept(this);
        }
    }

}
