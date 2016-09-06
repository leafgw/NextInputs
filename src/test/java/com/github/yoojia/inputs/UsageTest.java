package com.github.yoojia.inputs;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.0
 */
public class UsageTest {

    @Test
    public void test(){
        NextInputs inputs = new NextInputs();
        inputs.add(Provider.fromString("yoojia"))
                .with(StaticScheme.Required())

                .add(Provider.fromString("yoojia.chen@gmail.com"))
                .with(StaticScheme.Email())

                .add(Provider.fromString("13800138000"))
                .with(StaticScheme.ChineseMobile())

                .add(Provider.fromString("4121551474702170"))
                .with(StaticScheme.BlankCard());
        Assert.assertTrue(inputs.test());
    }
}
