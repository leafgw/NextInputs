package com.github.yoojia.inputs;

/**
 * @author 陈小锅 (yoojia.chen@gmail.com)
 */
class VerifierMeta {

    public final Input input;
    public final Scheme[] mSchemes;

    public VerifierMeta(Input input, Scheme[] schemes) {
        this.input = input;
        this.mSchemes = schemes;
    }
}
