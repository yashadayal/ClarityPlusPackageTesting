package com.ClarityPlusPackage.RecipientMService.Config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;

import java.io.IOException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CustomRecipientDeserializerDiffblueTest {
    /**
     * Method under test:
     * {@link CustomRecipientDeserializer#deserialize(JsonParser, DeserializationContext)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeserialize() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.fasterxml.jackson.core.ObjectCodec.readTree(com.fasterxml.jackson.core.JsonParser)" because the return value of "com.fasterxml.jackson.core.JsonParser.getCodec()" is null
        //       at com.ClarityPlusPackage.RecipientMService.Config.CustomRecipientDeserializer.deserialize(CustomRecipientDeserializer.java:17)
        //   See https://diff.blue/R013 to resolve this issue.

        CustomRecipientDeserializer customRecipientDeserializer = new CustomRecipientDeserializer();
        JsonParserDelegate jsonParser = new JsonParserDelegate(new TreeTraversingParser(MissingNode.getInstance()));
        customRecipientDeserializer.deserialize(jsonParser,
                new DefaultDeserializationContext.Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig())));
    }
}
