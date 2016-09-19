package com.github.yoojia.inputs;

/**
 * @author 陈小锅 (yoojia.chen@gmail.com)
 */
final class InputSchemes {

    public final Input input;
    public final Scheme[] schemes;

    public InputSchemes(Input input, Scheme[] schemes) {
        this.input = input;
        this.schemes = schemes;
    }

    public Result perform() throws Exception {
        final String value = input.getValue();
        for (Scheme scheme : schemes) {
            if (!scheme.verifier.perform(value)) {
                return new Result(false, scheme.message);
            }
        }
        return new Result(true, null);
    }

    public static class Result {
        public final boolean passed;
        public final String message;

        public Result(boolean passed, String message) {
            this.passed = passed;
            this.message = message;
        }
    }
}
