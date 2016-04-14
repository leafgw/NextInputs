package com.github.yoojia.inputs;

/**
 * @author 陈小锅 (yoojia.chen@gmail.com)
 */
class VerifierMeta {

    public final Input input;
    public final Schema[] schemas;

    public VerifierMeta(Input input, Schema[] schemas) {
        this.input = input;
        this.schemas = schemas;
    }
}
