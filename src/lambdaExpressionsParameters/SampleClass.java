package lambdaExpressionsParameters;

import java.util.function.Consumer;

public class SampleClass<T> {

    private static final SampleClass EMPTY = new SampleClass(null);

    private T value;

    public SampleClass(T value) {
        this.value = value;
    }

    private boolean isPresent() {
        return this.value != null;
    }

    public SampleClass onA(Runnable runnable) {
        if (this.isPresent() && "A".equals(this.value)) {
            runnable.run();
            return this.EMPTY;
        } else {
            return this;
        }
    }

    public SampleClass onA(Consumer<? super T> consumer) {
        if (this.isPresent() && "A".equals(this.value)) {
            consumer.accept(this.value);
            return this.EMPTY;
        } else {
            return this;
        }
    }

    public SampleClass onB(Runnable runnable) {
        if (this.isPresent() && "B".equals(this.value)) {
            runnable.run();
            return this.EMPTY;
        } else {
            return this;
        }
    }

    public SampleClass onB(Consumer<? super T> consumer) {
        if (this.isPresent() && "B".equals(this.value)) {
            consumer.accept(this.value);
            return this.EMPTY;
        } else {
            return this;
        }
    }

    public void onLast(Runnable runnable) {
        if (this.isPresent()) {
            runnable.run();
        }
    }

    public void onLast(Consumer<? super T> consumer) {
        if (this.isPresent()) {
            consumer.accept(this.value);
        }
    }

}
